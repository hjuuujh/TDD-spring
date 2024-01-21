package com.example.section1.payment;

interface PaymentGateway {
    void execute(int totalPrice, String cardNumber);
}
