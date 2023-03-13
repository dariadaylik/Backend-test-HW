package lesson3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class addMealTest extends AbstractTest{

    String id;

    @Test
    void eddMealTest(){
        given()
                .queryParam("hash", "d09d48895edc44f2fde757ad29ab10a79ebd983c")
                .queryParam("apiKey", getApiKey())
                .body("{\n"
                        + " \"date\": 1644881179,\n"
                        + " \"slot\": 1,\n"
                        + " \"position\": 0,\n"
                        + " \"type\": \"INGREDIENTS\",\n"
                        + " \"value\": {\n"
                        + " \"ingredients\": [\n"
                        + " {\n"
                        + " \"name\": \"1 banana\"\n"
                        + " }\n"
                        + " ]\n"
                        + " }\n"
                        + "}")
                .when()
                .post(getBaseUrl()+"mealplanner/dardi/items")
                .then()
                .statusCode(200);
    }

    @AfterEach
    void tearDown() {
        given()
                .queryParam("hash", "d09d48895edc44f2fde757ad29ab10a79ebd983c")
                .queryParam("apiKey", getApiKey())
                .delete("https://api.spoonacular.com/mealplanner/dardi/items/" + id)
                .then()
                .statusCode(200);
    }

}
