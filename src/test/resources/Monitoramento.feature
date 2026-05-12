# language: pt
Funcionalidade: Gestão de Inclusão e Diversidade Corporativa (ESG)

Contexto:
Dado que a API de monitoramento está ativa e pronta para receber requisições

@regressivo
Cenário: Registrar novos dados de diversidade com sucesso (Caminho Feliz)
Quando eu enviar uma requisição POST para "/api/diversidade/registro" com dados válidos
Então o sistema deve retornar o status code 201
E o corpo da resposta deve conter o campo "id"

@regressivo
Cenário: Tentar registrar dados sem campos obrigatórios
Quando eu enviar uma requisição POST para "/api/diversidade/registro" com o campo "indicador" vazio
Então o sistema deve retornar o status code 400

@regressivo
Cenário: Validar contrato da lista de indicadores
Quando eu requisitar a lista de indicadores via GET para "/api/diversidade/registro"
Então o status code deve ser 200
E a estrutura do JSON deve estar conforme o contrato estabelecido