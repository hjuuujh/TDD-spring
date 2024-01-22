package com.example.section1.order;

import com.example.section1.order.domain.Order;
import com.example.section1.product.domain.DiscountPolicy;
import com.example.section1.product.domain.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OrderTest {

    @Test
    void getTotalPrice() {
        final Order order1 = new Order(new Product("상품명", 1000, DiscountPolicy.NONE), 2);

        final int totalPrice1 = order1.getTotalPrice();

        assertThat(totalPrice1).isEqualTo(2000);

        final Order order2 = new Order(new Product("상품명", 2000, DiscountPolicy.FIX_1000_AMOUNT), 2);

        final int totalPrice2 = order2.getTotalPrice();

        assertThat(totalPrice2).isEqualTo(2000);

    }
}