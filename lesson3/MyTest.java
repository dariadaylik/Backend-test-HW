package lesson3;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class MyTest extends AbstractTest {

    @Test
    void getRequestTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("includeIngredients", "garlic")
                .pathParam("id", 716426)
                .when()
                .get(getBaseUrl()+"recipes/{id}/information")
                .then()
                .statusCode(200);


    }

    @Test
    void getRequestTest2() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "chinese")
                .queryParam("query", "salad")
                .queryParam("maxReadyTime", "120")
                .pathParam("id", 638642)
                .when()
                .get(getBaseUrl() + "recipes/{id}/information")
                .then()
                .statusCode(200);

    }

    @Test
    void getRequestTest3() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "italian")
                .queryParam("excludeIngredients", "rice")
                .queryParam("maxReadyTime", "120")
                .queryParam("includeIngredients", "cheese")
                .pathParam("id", 715495)
                .when()
                .get(getBaseUrl() + "recipes/{id}/information")
                .then()
                .statusCode(200);

    }


    @Test
    void getRequestTest4() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "chinese")
                .queryParam("excludeIngredients", "rice")
                .queryParam("maxReadyTime", "120")
                .queryParam("includeIngredients", "cheese")
                .queryParam("diet", "no suga")
                .pathParam("id", 652354)
                .when()
                .get(getBaseUrl() + "recipes/{id}/information")
                .then()
                .statusCode(200);

    }


    @Test
    void getRequestTest5() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "italian")
                .queryParam("maxReadyTime", "120")
                .queryParam("includeIngredients", "cheese")
                .queryParam("diet", "no suga")
                .pathParam("id", 652354)
                .when()
                .get(getBaseUrl() + "recipes/{id}/information")
                .then()
                .statusCode(200);

    }


}
