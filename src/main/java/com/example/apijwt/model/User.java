package com.example.apijwt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	
	@Id
    public String id;

    public String nickname;
    public String password;
    public float idade;
    public String petname;
    public User() {}

    public User(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, nickname='%s', password='%s']",
                id, nickname, password);
    }

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
