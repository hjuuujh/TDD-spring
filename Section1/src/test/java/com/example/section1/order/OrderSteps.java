package com.example.section1.order;

import com.example.section1.order.CreateOrderRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class OrderSteps {
    public static ExtractableResponse<Response> 상품주문요청(CreateOrderRequest request) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/orders")
                .then()
                .log().all().extract();
    }

    public static CreateOrderRequest 상품주문요청_생성() {
        // 상품의 번호를 받고 상품 몇건을 주문할건지 quantity를 받을것
        final Long productId = 1L;
        final int quantity = 2;
        final CreateOrderRequest request = new CreateOrderRequest(productId, quantity);
        return request;
    }
}