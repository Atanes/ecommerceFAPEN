# ecommerceFAPEN
Repositório para aplicação exemplo de um ecommerce simples utilizado no curso de ADS do Pentagono.

## Objetivo
Mostrar a utilização do Spring Boot e MVC integrado com páginsa HTML simples para criar um ecommerce simples 🛒 que permite o cadastro, listagem e pesquisa 
de usuários e produtos bem como a geração de relatórios no formato PDF e o uso do Spring Security 🔑 para controlar o acesso e as ações dos usuários na aplicação.

![image](https://user-images.githubusercontent.com/18126923/176027474-f2255ae8-a420-469e-ade7-bfd458ab0d35.png)

### Tecnologias/Ferramentas Utilizadas
Java, JavaScript, HTML, CSS, Spring Boot, Spring MVC, Spring Security, MYSQL, Eclipse

### Configurações inciais
Depois de clonar o projeto com o comando ```git clone https://github.com/Atanes/ecommerceFAPEN```, você precisa abrir o projeto no eclipse através do menu File -> Open Projects from File System..., na tela que aparece na sequencia selecionar a pasta do projeto e depois clicar em Finish para carregar o projeto.

![image](https://user-images.githubusercontent.com/18126923/176019533-ded3f095-221b-481a-abd6-34c158b87642.png)

![image](https://user-images.githubusercontent.com/18126923/176019353-2f0d0543-48a4-4c44-9297-55183892e2bc.png)

## Para uso com o Spring Security
Após criar o banco de dados usando a ferramenta de sua preferencia é preciso criar os Grupos, Permissões, suas relações e o usuário admin, conforme comandos abaixo: 

### Incluir usuário ADMIN no banco:  
insert into usuario values (0,1,'2000-02-02','admin@admin.com','admin','$2a$10$paMEJH7Fh.hkD3/xm1v6oul9dzW0/N9WzE4whYbMyhMtg9D4Essbq')

### Incluir GRUPOS de usuários:  
insert into grupo values (1,'Administrador');  
insert into grupo values (2,'Colaborador');  
insert into grupo values (3,'Cliente');  
insert into grupo values (4,'Gerente');  

### Relacionar usuario ADMIN com o grupo ADMINISTRADOR:  
insert into usuario_grupo values (1,1);

### Incluir PERMISSÕES de acesso:  
insert into permissao values (1, 'CADASTRAR_USUARIO');  
insert into permissao values (2, 'CADASTRAR_PRODUTO');  
insert into permissao values (3, 'VISUALIZAR_PRODUTO');  
insert into permissao values (4, 'VISUALIZAR_USUARIO');  

### Relacionar GRUPOS x PERMISSÕES:  
insert into grupo_permissao values (1,1);  
insert into grupo_permissao values (1,2);  
insert into grupo_permissao values (1,3);  
insert into grupo_permissao values (1,4);  
insert into grupo_permissao values (3,3);  

### Para logar no sistema usar as credenciais:

### e-mail: admin@admin.com
### senha: 123

## Configuração de acesso a Base de Dados
No arquivo applications-properties alterar as informações abaixo conforme a configuração que você fez no seu banco de dados local:

![image](https://user-images.githubusercontent.com/18126923/176029763-3ea87537-0160-454f-9749-395c13534992.png)

```
# ===============================
# = DATA SOURCE - MySQL
# ===============================
 spring.datasource.dbcp2.driver = com.mysql.cj.jdbc.Driver
 spring.datasource.url = jdbc:mysql://localhost:3306/seubancodedados?useTimezone=true&serverTimezone=UTC
 spring.datasource.username = SeuUsuario
 spring.datasource.password = SuaSenha
```
### Execução do projeto
Clicar com o botão direito do mouse sobre o nome do projeto na janela Project Explorer do Eclipse, depois no menu Run As... e por fim selecionar Spring Boot App

![image](https://user-images.githubusercontent.com/18126923/176030267-52ec7dad-b8fa-41c6-bbda-16b4ae80e98b.png)

Obs.: Sua contribuição é sempre bem vinda, por isso, se tiver alguma sugestão de melhoria e ou recomendação de ajuste/mudança das informações desse repositório, fique a vontade para abrir uma [ISSUE](https://github.com/Atanes/ecommerceFAPEN/issues) que ficarei muito feliz em receber suas sugestões, criticas e comentários!! 😊
