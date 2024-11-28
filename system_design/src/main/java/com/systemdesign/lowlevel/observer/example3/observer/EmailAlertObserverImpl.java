package com.systemdesign.lowlevel.observer.example3.observer;

import com.systemdesign.lowlevel.observer.example3.observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {

    String emailId;
    StockObservable stockObservable;

    public EmailAlertObserverImpl(String emailId,StockObservable stockObservable) {
        this.emailId = emailId;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        sendEmail(emailId, "product is back in stock, hurry up!");
    }

    private void sendEmail(String emailId, String message) {
        System.out.println("Email sent to " + emailId + ": " + message);
    }

}
