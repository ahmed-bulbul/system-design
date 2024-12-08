package com.systemdesign.lowlevel.factory;

public class PaymentApplication {
    public static void main(String[] args) {

        PaymentService paymentService = PaymentServiceFactory.create(PaymentType.PAYPAL);
        paymentService.processPayment(100);

        paymentService = PaymentServiceFactory.create(PaymentType.CREDIT_CARD);
        paymentService.processPayment(100);

        paymentService = PaymentServiceFactory.create(PaymentType.DEBIT_CARD);
        paymentService.processPayment(100);
    }
}
