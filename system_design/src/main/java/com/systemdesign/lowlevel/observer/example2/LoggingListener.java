package com.systemdesign.lowlevel.observer.example2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Concrete subscriber: Logs updates to a file
class LoggingListener implements EventListener {
    private final File logFile;
    private final String message;

    public LoggingListener(String logFilePath, String message) {
        this.logFile = new File(logFilePath);
        this.message = message;
    }

    @Override
    public void update(String filename) {
        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.write(message.replace("%s", filename) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
