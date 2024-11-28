package com.systemdesign.lowlevel.observer.example3.observer;

import com.systemdesign.lowlevel.observer.example3.observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {

    String username;
    StockObservable observable;

    public MobileAlertObserverImpl(String username, StockObservable observable) {
        this.username = username;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMsg(username, "product is back in stock, hurry up!");
    }

    private void sendMsg(String username, String message) {
        System.out.println("Message sent to " + username + ": " + message);
    }

}
