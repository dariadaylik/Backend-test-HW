package lesson3;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class MyPostTest extends AbstractTest{


    @Test
    void getPostTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Turkey Tomato Cheese Pizza")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void getPostTest2() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Monte Cristo Egg Rolls")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void getPostTest3() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Crab Wonton")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .statusCode(200);
    }


    @Test
    void getPostTest4() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Asparagus Lemon Risotto")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void getPostTest5() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Vegetable Minestrone Soup")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .statusCode(200);
    }



}
