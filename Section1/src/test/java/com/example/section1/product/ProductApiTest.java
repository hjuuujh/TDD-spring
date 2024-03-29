package com.example.section1.product;

import com.example.section1.ApiTest;
import com.example.section1.product.adapter.ProductRepository;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ProductApiTest extends ApiTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void 상품등록() {
        final var request = ProductSteps.상품등록요청_생성();

//        productService.addProduct(request);

        final var response = ProductSteps.상품등록요청(request);

        // response의 status code가 201인지 확인
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());

    }
    @Test
    void 상품조회() {
        // 상품등록하고 등록한 상품으로 restassured 요청
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        Long productId = 1L;

        final var response = ProductSteps.상품조회요청(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
    }

    @Test
    void 상품수정() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final long productId = 1L;


        final ExtractableResponse<Response> response = 상품수정요청(productId);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());

        // 실제로 값이 잘 변했는지 확인
        assertThat(productRepository.findById(1L).get().getName()).isEqualTo("상품 수정");
    }

    private static ExtractableResponse<Response> 상품수정요청(long productId) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(ProductSteps.상품수정요청_생성())
                .when()
                .patch("/products/{productId}", productId)
                .then()
                .log().all().extract();
    }
}
