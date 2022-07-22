# Alura Stickers - Imersão Java Alura

![badge_issues](https://img.shields.io/github/issues/vsantsal/alura-stickers)
![example workflow](https://github.com/vsantsal/alura-stickers/actions/workflows/maven.yml/badge.svg)


## Descrição

Repositório para acompanhar a Imersão Java da Alura, acontecendo de 18 a 22/07.

Utilizaremos o projeto proposto pela Alura para desenvolver a habilidade na linguagem Java de consumir uma API (no caso, do IMDB).

Também praticaremos Integração Contínua com o uso do Github Actions.

### Dia 01

O Enum *TipoApi* retorna a Url a ser consultada para obter os dados do serviço. 

Dado que o uso da [API do IMDB](https://imdb-api.com/api) demanda a geração de uma **APIKey** que não se deve disponibilizar publicamente, é importante que ela não esteja *hard coded* e sim em arquivo de propriedades, o qual não será commitado no repositório.

Como **framework** de testes do projeto, usamos o [JUnit 5](https://junit.org/junit5/).

Antes de prosseguir para as atividades do segundo dia, reorganizamos estrutura de diretórios do projeto e adicionamos arquivo para build e testes.


