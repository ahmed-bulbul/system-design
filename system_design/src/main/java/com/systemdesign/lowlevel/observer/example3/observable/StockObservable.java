package com.systemdesign.lowlevel.observer.example3.observable;

import com.systemdesign.lowlevel.observer.example3.observer.NotificationAlertObserver;

public interface StockObservable {
    void add(NotificationAlertObserver observer);
    void remove(NotificationAlertObserver observer);
    void notifySubscribers();
    void setStockCount(int newStockAdded);
    int getStockCount();
}
