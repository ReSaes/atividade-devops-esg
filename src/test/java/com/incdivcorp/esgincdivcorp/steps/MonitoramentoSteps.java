package com.incdivcorp.esgincdivcorp.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MonitoramentoSteps {

    private Response response;
    private RequestSpecification spec;
    private final String ROTA_API = "/api/diversidade/registro";

    public MonitoramentoSteps() {
        RestAssured.baseURI = "http://localhost:8080";

        this.spec = new RequestSpecBuilder()
                .setContentType("application/json")
                .build();
    }

    @Dado("que a API de monitoramento está ativa e pronta para receber requisições")
    public void que_a_api_de_monitoramento_está_ativa_e_pronta_para_receber_requisições() {
        given()
            .spec(spec)
        .when()
            .get(ROTA_API)
        .then()
            .statusCode(not(404));
    }

    @Quando("eu enviar uma requisição POST para {string} com dados válidos")
    public void eu_enviar_uma_requisição_post_para_com_dados_válidos(String path) {
        String corpoJson = "{" +
                "\"area\": \"TI\"," +
                "\"indicador\": \"Etnia\"," +
                "\"percentual\": 45.5," +
                "\"dataRegistro\": \"2026-05-11\"" +
                "}";

        response = given()
            .spec(spec)
            .body(corpoJson)
        .when()
            .post(path);
    }

    @Então("o sistema deve retornar o status code {int}")
    public void o_sistema_deve_retornar_o_status_code(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @Então("o corpo da resposta deve conter o campo {string}")
    public void o_corpo_da_resposta_deve_conter_o_campo(String campo) {
        response.then().body("$", hasKey(campo));
    }

    @Quando("eu enviar uma requisição POST para {string} com o campo {string} vazio")
    public void eu_enviar_uma_requisição_post_para_com_o_campo_vazio(String path, String campo) {
        String corpoJson = "{" +
                "\"area\": \"RH\"," +
                "\"indicador\": null," + 
                "\"percentual\": 10.0," +
                "\"dataRegistro\": \"2026-05-11\"" +
                "}";

        response = given()
            .spec(spec)
            .body(corpoJson)
        .when()
            .post(path);
    }

    @Quando("eu requisitar a lista de indicadores via GET para {string}")
    public void eu_requisitar_a_lista_de_indicadores_via_get_para(String path) {
        response = given()
            .spec(spec)
        .when()
            .get(path);
    }

    @Então("o status code deve ser {int}")
    public void o_status_code_deve_ser(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @Então("a estrutura do JSON deve estar conforme o contrato estabelecido")
    public void a_estrutura_do_json_deve_estar_conforme_o_contrato_estabelecido() {
        response.then().body("$", instanceOf(java.util.List.class));
    }
}