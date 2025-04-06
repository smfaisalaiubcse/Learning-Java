package MidLabPracticeQuestions;

interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class SMSNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class PushNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
}

// Generic Processor
class NotificationProcessor<T extends Notification> {
    public void process(T notification, String message) {
        notification.send(message);
    }
}

public class GenericsQ1 {
    public static void main(String[] args) {
        NotificationProcessor<EmailNotification> emailProcessor = new NotificationProcessor<>();
        emailProcessor.process(new EmailNotification(), "Welcome to our app!");

        NotificationProcessor<SMSNotification> smsProcessor = new NotificationProcessor<>();
        smsProcessor.process(new SMSNotification(), "Your OTP is 123456");

        NotificationProcessor<PushNotification> pushProcessor = new NotificationProcessor<>();
        pushProcessor.process(new PushNotification(), "New update available!");
    }
}

