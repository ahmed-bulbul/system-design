package com.systemdesign.lowlevel.observer.example2;

import java.io.IOException;

public class Observer2Application {
    public static void main(String[] args) {
        Editor editor = new Editor();

        LoggingListener logger = new LoggingListener(
                "log.txt", "Someone has opened the file: %s");
        editor.getEvents().subscribe("open", logger);

        EmailAlertsListener emailAlerts = new EmailAlertsListener(
                "admin@example.com", "Someone has changed the file: %s");
        editor.getEvents().subscribe("save", emailAlerts);

        try {
            editor.openFile("example.txt");
            editor.saveFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
