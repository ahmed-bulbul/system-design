package com.systemdesign.lowlevel.observer.example2;

// Subscriber interface: Defines the contract for subscribers
interface EventListener {
    void update(String filename);
}
