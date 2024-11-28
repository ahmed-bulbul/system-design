package com.systemdesign.lowlevel.observer.example3;

import com.systemdesign.lowlevel.observer.example3.observable.IPhoneObservableImpl;
import com.systemdesign.lowlevel.observer.example3.observable.StockObservable;
import com.systemdesign.lowlevel.observer.example3.observer.EmailAlertObserverImpl;
import com.systemdesign.lowlevel.observer.example3.observer.MobileAlertObserverImpl;
import com.systemdesign.lowlevel.observer.example3.observer.NotificationAlertObserver;

public class Store {

    public static void main(String[] args) {
        StockObservable iphonStockObservable = new IPhoneObservableImpl();
        NotificationAlertObserver observer1 =  new EmailAlertObserverImpl("xOyOe@example.com", iphonStockObservable);
        NotificationAlertObserver observer2 =  new EmailAlertObserverImpl("yGhV8@example.com", iphonStockObservable);
        NotificationAlertObserver observer3 =  new MobileAlertObserverImpl("01753155400", iphonStockObservable);

        iphonStockObservable.add(observer1);
        iphonStockObservable.add(observer2);
        iphonStockObservable.add(observer3);


        iphonStockObservable.setStockCount(10);
        System.out.println("Stock count is : " + iphonStockObservable.getStockCount());






    }

}
