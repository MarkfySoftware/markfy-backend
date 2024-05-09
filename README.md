# Markfy

## Integrantes do Grupo:

### Representante/gestor do projeto:
- Bruno de Paula (RM552226)

### Líder Técnico:
- Kayque Lima (RM550782)

### Desenvolvedor Frontend/Mobile:
- Gabriel França (RM551905)

### Desenvolvedor/redator:
- Edward de Lima (RM98676)

## Como Rodar a Aplicação:

Para rodar a aplicação, siga os passos abaixo:

1. Clone o repositório do projeto para o seu ambiente local.
2. Certifique-se de ter o Java JDK e o Spring Boot instalados em sua máquina.
3. Abra o terminal e navegue até o diretório onde está o projeto.
4. Abra o projeto na sua IDE de preferencia.
5. Baixe as dependências do Maven utilizando o comando: `mvn clean install`.
6. Rode a classe `GerenciamentoDeComprasApplication`
5. Use o `-Dspring.profiles.active=dev` caso queira rodar em um ambiente de desenvolvimento com um banco de dados em memória (H2).
5. Acesse a aplicação em seu navegador ou client utilizando o endereço `http://localhost:8080/gerenciamento-de-compras/endpoint-desejado`.

## Autenticação e autorização 

<p>Para se autenticar na API do Markfy, siga os seguintes passos:</p>

1. Acesse o endpoint `/gerenciamento-de-compras/usuario/cadastro`
2. Faça seu cadastro como usuário do Markfy
3. Acesse o endpoint `/gerenciamento-de-compras/login/token`
4. Insira o email e senha que foi cadastrado no sistema
5. Copie o token que foi retornado
6. Insira esse token no header das requisições que você deseja efetuar 
 
#### Utilize a chave `Authorization` e o prefixo "Bearer". Ex: Authorization: Bearer eyJhbGci...


## Diagramas da arquitetura do software:

### Diagrama de classes:
![Diagrama de classes.png](https://drive.google.com/uc?export=view&id=1OPtObgZA_xpn8W3M-Fb5qXG9g-NKWYQ0)


### Diagrama de Entidade e Relacionamento:
![DER.png](https://drive.google.com/uc?export=view&id=1g8Z4mrtree0fMHMXuwoTZ6eveRQOJGGP)

## Vídeo de Apresentação:

Acesse: [Clique aqui para assistir o vídeo de apresentação](https://www.youtube.com/watch?v=k0ObOt--m1k)

## Documentação da API:

Aqui estão listados todos os endpoints disponíveis na API de acordo com os domínios do software:

#### Login
1. POST `/login/token`: Realiza o login de um usuário já existente no sistema.
2. GET  `/login`: Lista todos os logins já feitos.
3. GET  `/login/{id}`: Retorna um login específico com base no ID fornecido.

### Usuário
4. POST `/usuario/cadastro`: Cadastra um usuário no sistema.
5. GET  `/usuario`: Lista todos os usuários presentes na base de dados.
6. GET  `/usuario/{id}`: Retorna um usuário específico com base no ID fornecido.
7. PUT `/usuario/{id}`: Altera as informações de um usuário na base de dados
8. DELETE `/usuario/{id}`: Deleta um usuário da base de dado

### Endereço
9. GET `/endereco`: Lista todos os endereços presentes na base de dados.
10. GET  `/endereco/{id}`: Retorna um endereço específico com base no ID fornecido.
11. PUT `/endereco/{id}`: Altera as informações de um endereço na base de dados

### Item
12. POST `/item`: Cadastra um item no sistema.
13. GET  `/item`: Lista todos os items presentes na base de dados.
14. GET  `/item/{id}`: Retorna um item específico com base no ID fornecido.
15. PUT `/item/{id}`: Altera as informações de um item na base de dados
16. DELETE `/item/{id}`: Deleta um item da base de dado

### Compra
17. POST `/compra`: Cadastra uma compra no sistema.
18. POST `/compra/{id}`: Confirma que a compra foi realizada com êxito.
19. GET  `/compra`: Lista todos os compras presentes na base de dados.
20. GET  `/compra/{id}`: Retorna uma compra específico com base no ID fornecido.
21. DELETE `/compra/{id}`: Deleta uma compra da base de dados


## Atenção
Para mais detalhes sobre cada endpoint acesse a collection do Insomnia com todas as requisiçoes existentes. Siga os passos abaixo para executá-las.
1. Na raiz desse repositório entre na pasta `documentos_do_projeto`.
2. Faça o download do arquivo: `Insominia_Collection_Markfy.json`.
1. Certifique-se de ter o software Insomnia instalado na sua máquina.
3. No Insomnia clique no botão `create` ou no ícone de mais `+`.
4. Depois clique na opção `importar`.
5. Selecione o JSON (Insominia_Collection_Markfy.json) baixado e importe a collection.
6. Faça as chamadas aos endpoints listados acima respeitando a ordem das requisições




## Próximos passos 

[ ]  Bean validation <br/>
[x]  Reorganizar a documentação <br/>
[x]  Documentar a API com Swagger <br/>
[x]  Liberar rota do Swagger para oauth e doFilter <br/>
[ ]  Implementar autenticação pela interface do Swagger <br/>
[ ]  Bater em api para buscar dados automaticamento com o cpf <br/>
[x]  Autenticação e autorização com JWT <br/>
[ ]  Retorno da excpetion do oauth para o usuário <br/>
[ ]  Sistema de roles pra bloquear os endpoint de cadastro de itens para o usuario <br/>
[x]  Refatorar camada de login <br/>
[ ]  Autenticação com google e github <br/>
[ ]  Integração com frontend <br/>
[ ]  Integração com IA

## Melhorias do sistema 
- Validação da existencia do usuário pelo email informado.
- Remoção da necessidade de passar o id do usuário no momento do login.
- Documentação da API com Swagger
