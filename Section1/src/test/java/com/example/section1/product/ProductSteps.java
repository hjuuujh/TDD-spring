package com.example.section1.product;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class ProductSteps {
    //        API test로 전환하므로 서비스가 아니라 api요청이 들어가야함
    // Api 요청 보내기
    // log().all() : // 요청 보내는 로그를 남기겠다는 것
    public static ExtractableResponse<Response> 상품등록요청(AddProdcutRequest request) {
        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/products")
                .then()
                .log().all().extract();
        return response;
    }

    public static AddProdcutRequest 상품등록요청_생성() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProdcutRequest request = new AddProdcutRequest(name, price, discountPolicy);
        return request;
    }
}