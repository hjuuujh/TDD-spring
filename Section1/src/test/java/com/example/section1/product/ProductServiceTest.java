package com.example.section1.product;

import com.example.section1.product.application.service.GetProductResponse;
import com.example.section1.product.application.service.ProductService;
import com.example.section1.product.application.service.UpdateProductRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void 상품수정() {
        // 상품 등록
        productService.addProduct(ProductSteps.상품등록요청_생성());

        // updateProduct하고 프로덕트 아이디랑 request받으면 해당 productId의 상품이 수정
        final Long productId = 1L;
        final UpdateProductRequest request = ProductSteps.상품수정요청_생성();

        productService.updateProduct(productId, request);

        // 등록된 상품으로 조회
        final ResponseEntity<GetProductResponse> response = productService.getProduct(productId);
        final GetProductResponse productResponse = response.getBody();

        assertThat(productResponse.name()).isEqualTo("상품 수정");
        assertThat(productResponse.price()).isEqualTo(2000);
    }


}
