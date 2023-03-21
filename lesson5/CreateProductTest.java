package lesson5;

import io.swagger.models.Response;
import lesson5.dto.Product;
import lesson5.dto.api.ProductService;
import lesson5.dto.utils.RetrofitUtils;
import lombok.SneakyThrows;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CreateProductTest {

     static ProductService productService;
    Product product = null;
//    Faker faker = new Faker();
    int id;

    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }
//
//    @BeforeEach
//    void setUp() {
//        product = new Product()
//                .withTitle(faker.food().ingredient())
//                .withCategoryTitle("Food")
//                .withPrice((int) (Math.random() * 10000));
//    }

    @Test
    void createProductInFoodCategoryTest() throws IOException {
        Response<Product> response = productService.createProduct(product)
                .execute();
        id =  response.body().getId();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }

    @SneakyThrows
    @AfterEach
    void tearDown() {
        Response<ResponseBody> response = productService.deleteProduct(id).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }



}
