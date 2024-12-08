package com.systemdesign.lowlevel.factory;

import java.util.logging.Logger;

public class CreditCardService implements PaymentService{
    private static final Logger logger = Logger.getLogger(CreditCardService.class.getName());
    @Override
    public void processPayment(double amount) {
        logger.info("Processing credit card payment of $" + amount);
    }
}
