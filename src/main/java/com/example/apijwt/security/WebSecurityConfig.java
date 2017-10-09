package com.example.apijwt.security;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.apijwt.security.JWTAuthenticationFilter;
import com.example.apijwt.service.SecUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    SecUserDetailsService userDetailsService;
 
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors();
        httpSecurity.csrf().disable().authorizeRequests().antMatchers("/home").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll().anyRequest().authenticated().and()
 
                // filtra requisições de login
                .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
 
                // filtra outras requisições para verificar a presença do JWT no header
                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
 
     @Autowired
        public void configAuthBuilder(AuthenticationManagerBuilder builder) throws Exception {
            builder.userDetailsService(userDetailsService);
        }
     
     @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurerAdapter() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    applyFullCorsAllowedPolicy(registry);
                }
            };
        }
       
        public static void applyFullCorsAllowedPolicy(CorsRegistry registry) {
            registry.addMapping("/**") //
                    .allowedOrigins("*") //
                    .allowedMethods("OPTIONS", "HEAD", "GET", "PUT", "POST", "DELETE", "PATCH") //
                    .allowedHeaders("*") //
                    .exposedHeaders("WWW-Authenticate","authorization","authorization_expiration") //
                    .allowCredentials(true)
                    .maxAge(TimeUnit.DAYS.toSeconds(1));
        }
}