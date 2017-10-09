Necessária pré configuração das seguintes tecnologias:

Apache Maven 3.5.0 ( ou superior)
Java version: 1.8.0_144 ( ou superior)
Seguintes extensões foram utilizadas para implementação
io.jsonwebtoken-jjwt-0.8.0
org.springframework.boot - 1.5.7.RELEASE
-spring-boot-starter-security
-spring-boot-starter-data-mongodb


1. Fazer download do projeto 

2. Alterar conexões do banco de dados no arquivo application.properties

Em caso de utilização do banco localmente ( Gerar um arquivo Js para os inserts abaixo)

db.user.insertMany([{"nickname": "Camila","password": "13579"},
		                {"nickname": "Pedro","password": "02468"}])

db.product.insertMany([{"name":"Beer","type": "drink"},
		                {"name":"Coca-cola","type": "drink"},
		                {"name":"Doritos","type": "Snack"}])
                    
*Recomendo a utilização do https://mlab.com/ e a utilização do URI gerado 

3. No cmd na pasta do projeto rodar os seguintes comando: 
- mvn clean install 
- mvn spring-boot:run

4. Browser ( De sua preferencia)

http:localhost:8080 ( Esperado Erro 402: Access Denied)

5. Gerando requisições 

Para gerar o token é necessario gerar uma requisição POST com as informações do usuário.
* Recomendo a utilzação do Postman 

http:localhost:8080/login
Em body->raw adicionei o seguinte Json
{"nickname": "Camila","password": "13579"}

EXEMPLO DE TOKEN GERADO
"Beard eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjEzODY4OTkxMzEsImlzcyI6ImppcmE6MTU0ODk1OTUiLCJxc2giOiI4MDYzZmY0Y2ExZTQxZGY3YmM5MGM4YWI2ZDBmNjIwN2Q0OTFjZjZkYWQ3YzY2ZWE3OTdiNDYxNGI3MTkyMmU5IiwiaWF0IjoxMzg2ODk4OTUxfQ.uKqU9dTB6gKwG6jQCuXYAiMNdfNRw98Hw_IWuA5MaMo.."

Em Header adicionar (key: Authorization value: token gerado) e fazer uma nova requisição GET para o endereço 
http:localhost:8080/home 

Retorno esperado:

{"name":"Beer","type": "drink"}, {"name":"Coca-cola","type": "drink"},{"name":"Doritos","type": "Snack"}

         
         
