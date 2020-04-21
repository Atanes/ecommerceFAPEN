# ecommerceFAPEN
Repositório para aplicação exemplo de um ecommerce com utilização de JDBC e Servlet utilizado no curso de ADS do Pentagono.

# Para uso com o Spring Security é preciso executar os camandos abaixo no Banco de Dados

Incluir usuário ADMIN no banco:
insert into usuario values (0,1,'2000-02-02','admin@admin.com','admin','$2a$10$paMEJH7Fh.hkD3/xm1v6oul9dzW0/N9WzE4whYbMyhMtg9D4Essbq')

Incluir GRUPOS de usuários:
insert into grupo values (1,'Administrador')
insert into grupo values (2,'Colaborador')
insert into grupo values (3,'Cliente')
insert into grupo values (4,'Gerente')

Incluir PERMISSÕES de acesso:
insert into permissao values (1, 'CADASTRAR_USUARIO')
insert into permissao values (2, 'CADASTRAR_PRODUTO')
insert into permissao values (3, 'VISUALIZAR_PRODUTO')
insert into permissao values (4, 'VISUALIZAR_USUARIO')

Relacionar GRUPOS x PERMISSÕES:
insert into grupo_permissao values (1,1)
insert into grupo_permissao values (1,2)
insert into grupo_permissao values (1,3)
insert into grupo_permissao values (1,4)
insert into grupo_permissao values (3,3)

Para logar no sistema usar as credenciais:

e-mail: admin@admin.com
senha: 123

