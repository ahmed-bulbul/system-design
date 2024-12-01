package com.youtube.systemdesign.observer;

public interface Channel {

    public void notifyAllSubscriber(Object o);

}
