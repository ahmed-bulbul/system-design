package com.systemdesign.lowlevel.observer.example2;

// Concrete subscriber: Sends email alerts for updates
class EmailAlertsListener implements EventListener {
    private final String email;
    private final String message;

    public EmailAlertsListener(String email, String message) {
        this.email = email;
        this.message = message;
    }

    @Override
    public void update(String filename) {
        System.out.println("Email sent to " + email + ": " + message.replace("%s", filename));
    }
}