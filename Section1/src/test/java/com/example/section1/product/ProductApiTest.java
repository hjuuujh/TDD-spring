package com.example.section1.product;

import com.example.section1.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ProductApiTest extends ApiTest {

    @Test
    void 상품등록() {
        final var request = 상품등록요청_생성();

//        productService.addProduct(request);
//        API test로 전환하므로 서비스가 아니라 api요청이 들어가야함
        // Api 요청 보내기
        // log().all() : // 요청 보내는 로그를 남기겠다는 것
        final var response = 상품등록요청(request);

        // response의 status code가 201인지 확인
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());

    }

    private static ExtractableResponse<Response> 상품등록요청(AddProdcutRequest request) {
        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/products")
                .then()
                .log().all().extract();
        return response;
    }

    private static AddProdcutRequest 상품등록요청_생성() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProdcutRequest request = new AddProdcutRequest(name, price, discountPolicy);
        return request;
    }


}
