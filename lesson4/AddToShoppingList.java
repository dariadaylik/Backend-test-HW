package lesson4;

import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddToShoppingList extends AbstractTest {

    String id;

    @Test
    void addMealPositiveTest() {
        id = given(requestSpecification)
                .body("{\n" +
                        "    \"date\": 1589500800,\n" +
                        "    \"slot\": 1,\n" +
                        "    \"position\": 0,\n" +
                        "    \"type\": \"PRODUCT\",\n" +
                        "    \"value\": {\n" +
                        "    \"id\": 183433,\n" +
                        "    \"servings\": 1,\n" +
                        "    \"title\": \"Ahold Lasagna with Meat Sauce\",\n" +
                        "    \"imageType\": \"jpg\"\n" +
                        "    }\n" +
                        "}")
                .log()
                .all()
                .when()
                .post("https://api.spoonacular.com/mealplanner/dardi/items")
                .prettyPeek()
                .then()
                .spec(responseSpecification)
                .extract()
                .body()
                .as(Response.class)
                .getSessionId();
    }


    @Test
    void getRecipePositiveTest() {
        given().spec(getRequestSpecification())
                .when()
                .get("https://api.spoonacular.com/recipes/638642/information")
                .then()
                .spec(responseSpecification);
    }


    @Test
    void test(){
        given().spec(requestSpecification)
                .when()
                .formParam("title","Monte Cristo Egg Rolls")
                .formParam("language", "en")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
    void delete() {
        given().spec(requestSpecification)
                .body("{\n" +
                        "    \"date\": 1589500800,\n" +
                        "    \"slot\": 1,\n" +
                        "    \"position\": 0,\n" +
                        "    \"type\": \"PRODUCT\",\n" +
                        "    \"value\": {\n" +
                        "    \"id\": 183433,\n" +
                        "    \"servings\": 1,\n" +
                        "    \"title\": \"Ahold Lasagna with Meat Sauce\",\n" +
                        "    \"imageType\": \"jpg\"\n" +
                        "    }\n" +
                        "}")
                .delete("https://api.spoonacular.com/mealplanner/dardi/items/15914921")
                .then()
                .statusCode(200);
    }


}

