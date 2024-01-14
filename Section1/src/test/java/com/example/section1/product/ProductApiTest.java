package com.example.section1.product;

import com.example.section1.ApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ProductApiTest extends ApiTest {

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

}
