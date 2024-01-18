package com.example.section1.payment;

public class ConsolePaymentGateway implements PaymentGateway {
    @Override
    public void execute(int totalPrice, String cardNumber) {
        System.out.println("결제완료");
    }
}
