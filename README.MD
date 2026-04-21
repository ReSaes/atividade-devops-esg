Projeto - Esgincdivcorp (Gestão de Diversidade e Inclusão)
## Como executar localmente com Docker
Para subir o ambiente completo (Aplicação + Banco de Dados Oracle XE) em sua máquina:

Certifique-se de ter o Docker Desktop instalado e funcional.

Navegue até a raiz do projeto via terminal.

Execute o comando:

Bash
docker-compose up --build
Acompanhe os logs no terminal. Quando visualizar a mensagem DATABASE IS READY TO USE!, o ambiente estará pronto.

A aplicação poderá ser acessada em: http://localhost:8080.

## Pipeline CI/CD
A automação deste projeto foi implementada via GitHub Actions, garantindo um fluxo contínuo desde o commit até a entrega final.

Ferramentas: GitHub Actions, Maven, Docker Hub.

Etapas do Pipeline:

Build & Dockerize: Compilação do código Java 21 e criação da imagem Docker.

Deploy Staging: Publicação automatizada em ambiente de homologação.

Deploy Production: Entrega final em ambiente de produção.

Funcionamento: O gatilho de execução é disparado a cada push na branch principal (main).

[INSERIR PRINT 2: Print do gráfico visual do GitHub Actions mostrando os 3 blocos verdes: Build, Staging e Production]

## Containerização
O projeto utiliza uma estratégia de containerização moderna para garantir leveza e segurança:

Dockerfile: Implementado com Multi-stage Build.

Estágio 1 (Build): Utiliza Maven para compilar o projeto e gerar o .jar.

Estágio 2 (Runtime): Utiliza eclipse-temurin:21-jre-alpine, uma imagem otimizada que contém apenas o necessário para rodar a aplicação, reduzindo a superfície de ataque e o tamanho do arquivo final.

Orquestração: O arquivo docker-compose.yml automatiza a subida do banco de dados Oracle e realiza o vínculo (link) com a aplicação, permitindo que o sistema esteja pronto para uso com um único comando.

## Prints do funcionamento
Abaixo, as evidências de que o ciclo de vida do software está operacional em todos os níveis:

Execução de Deploy (Staging e Produção)
[INSERIR PRINT 3: Print do log detalhado dentro do GitHub Actions mostrando a mensagem de "Deploy em PRODUÇÃO finalizado com sucesso"]

## Tecnologias utilizadas
Backend: Java 21 / Spring Boot 3.x

Banco de Dados: Oracle XE 21c (Containerizado)

Infraestrutura: Docker e Docker Compose

Automação (CI/CD): GitHub Actions

Gerenciador de Dependências: Maven