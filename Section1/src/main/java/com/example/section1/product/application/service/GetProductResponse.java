package com.example.section1.product.application.service;

import com.example.section1.product.domain.DiscountPolicy;
import org.springframework.util.Assert;

public record GetProductResponse(long id, String name, int price, DiscountPolicy discountPolicy) {

    public GetProductResponse {
        // 응답에 정상적인 값이 담기는지 검증
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.notNull(id, "상품 id는 필수입니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
    }
}
