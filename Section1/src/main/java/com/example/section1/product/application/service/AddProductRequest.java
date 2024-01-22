package com.example.section1.product.application.service;

import com.example.section1.product.domain.DiscountPolicy;
import org.springframework.util.Assert;

public record AddProductRequest(String name, int price, DiscountPolicy discountPolicy) {
    public AddProductRequest {
        // check validation
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
    }
}
