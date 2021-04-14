# Tinnova

Esse projeto é uma API para CRUD de planetas

## Começando

Para executar o projeto, será necessário instalar os seguintes programas:

- [JDK: Necessário para executar o projeto Java]
- [Maven: Necessário para realizar o build do projeto Java]
- [Eclipse ou STS: Para desenvolvimento do projeto]


## Desenvolvimento

Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub num diretório de sua preferência:

```shell
cd "diretorio de sua preferencia"
git clone https://github.com/lucashmm94/b2w
```

### Construção
Para rodar o back end, basta entra no eclipse ou sts, importar o projeto, esperar o build e rodar com spring devtools(plugin do eclipse) a aplicação em debug
Para rodar o banco basta,instalar o mongodb e o compass, rodar o mongod no terminal para subir uma instância, 
criar uma database no compass,  e criar uma coleção e passar esses parametros no application.propeties:<br>

spring.data.mongodb.uri=mongodb://localhost:27017/db_b2w

server.port=${port:8081}


```shell
mvn clean install
```

O comando irá baixar todas as dependências do projeto e criar um diretório *target* com os artefatos construídos, que incluem o arquivo jar do projeto. 
Além disso, serão executados os testes unitários, e se algum falhar, o Maven exibirá essa informação no console.



```




