package com.systemdesign.lowlevel.factory;

public class PaymentServiceFactory {

    public static PaymentService create(PaymentType paymentType){
        return switch (paymentType) {
            case PAYPAL -> new PaypalService();
            case CREDIT_CARD, DEBIT_CARD -> new CreditCardService();
        };
    }

}
