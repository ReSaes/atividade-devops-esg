# language: pt
Funcionalidade: Gestão de Inclusão e Diversidade Corporativa (ESG)

  Contexto:
    Dado que a API de monitoramento está ativa e pronta para receber requisições

  @regressivo
  Cenário: Registrar novos dados de diversidade com sucesso (Caminho Feliz)
    Quando eu enviar uma requisição POST para "/api/monitoramento" com dados válidos
    Então o sistema deve retornar o status code 201
    E o corpo da resposta deve conter o campo "id"

  @regressivo
  Cenário: Tentar registrar dados sem campos obrigatórios
    Quando eu enviar uma requisição POST para "/api/monitoramento" com o campo "nome" vazio
    Então o sistema deve retornar o status code 400
    E a mensagem de erro deve ser "O nome é obrigatório"

  @regressivo
  Cenário: Validar contrato da lista de indicadores
    Quando eu requisitar a lista de indicadores via GET para "/api/monitoramento"
    Então o status code deve ser 200
    E a estrutura do JSON deve estar conforme o contrato estabelecido