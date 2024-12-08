package com.systemdesign.lowlevel.factory;

import java.util.logging.Logger;

public class PaypalService implements PaymentService{
    private static final Logger logger = Logger.getLogger(PaypalService.class.getName());
    @Override
    public void processPayment(double amount) {
        logger.info("Processing Paypal payment : -> $" + amount);
    }
}
