package lesson5.dto.api;

import org.aspectj.weaver.ast.Call;
import org.springframework.web.bind.annotation.ResponseBody;
import retrofit2.http.*;
import ru.geekbrains.mini.market.entites.Product;

public interface ProductService {

    @POST("products")
    Call<Product> createProduct(@Body Product createProductRequest);

    @DELETE("products/{id}")
    Call<ResponseBody> deleteProduct(@Path("id") int id);

    @PUT("products")
    Call<Product> modifyProduct(@Body Product modifyProductRequest);

    @GET("products/{id}")
    Call<Product> getProductById(@Path("id") int id);

    @GET("products")
    Call<ResponseBody> getProducts();

}