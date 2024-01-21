package com.example.section1.payment;

import com.example.section1.ApiTest;
import com.example.section1.order.OrderSteps;
import com.example.section1.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PaymentApiTest extends ApiTest {

    @Test
    void 상품주문() {
        // 상품을 등록하고
       ProductSteps.상품등록요청_생성();

        // 주문을 만들고
        OrderSteps.상품주문요청_생성();

        // 만들어진 주문으로 결제 생성
        final var request = PaymentSteps.주문결제요청_생성();

        final var response = PaymentSteps.주문결제요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

}
