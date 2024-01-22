package com.example.section1.payment.adapter;

interface PaymentGateway {
    void execute(int totalPrice, String cardNumber);
}
