package com.systemdesign.lowlevel.observer.example2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Concrete publisher: Contains business logic and uses EventManager for notifications
class Editor {
    private final EventManager events = new EventManager();
    private File file;

    public EventManager getEvents() {
        return events;
    }

    public void openFile(String path) throws IOException {
        this.file = new File(path);
        if (!file.exists()) {
            file.createNewFile(); // For demonstration purposes
        }
        events.notify("open", file.getName());
    }

    public void saveFile() throws IOException {
        if (file != null) {
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write("File content updated\n"); // Simulate saving
            }
            events.notify("save", file.getName());
        }
    }
}

