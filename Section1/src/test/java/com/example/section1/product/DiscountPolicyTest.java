package com.example.section1.product;

import com.example.section1.product.domain.DiscountPolicy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DiscountPolicyTest {

    @Test
    void noneDiscountPolicy() {
        final int price = 1000;
        final int discountPrice = DiscountPolicy.NONE.applyDiscount(price);

        // 할인 안했으므로 정가와 같아야함
        assertThat(discountPrice).isEqualTo(price);
    }

    @Test
    void fix_1000_discounted_price() {
        final int price = 2000;
        final int discountPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);

        // 정가 2000이므로 100원 깎아서 1000원 남아야함
        assertThat(discountPrice).isEqualTo(1000);
    }
    @Test
    void over_discounted_price() {
        final int price = 500;
        final int discountPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);

        assertThat(discountPrice).isEqualTo(0);
    }
}