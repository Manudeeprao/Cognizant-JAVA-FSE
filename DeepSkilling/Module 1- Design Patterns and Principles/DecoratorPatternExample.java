public class DecoratorPatternExample {

    // Component Interface
    interface Notifier {
        void send(String message);
    }

    // Concrete Component
    static class EmailNotifier implements Notifier {
        @Override
        public void send(String message) {
            System.out.println("Sending Email: " + message);
        }
    }

    // Abstract Decorator
    static abstract class NotifierDecorator implements Notifier {
        protected Notifier notifier;

        public NotifierDecorator(Notifier notifier) {
            this.notifier = notifier;
        }

        @Override
        public void send(String message) {
            notifier.send(message);
        }
    }

    // Concrete Decorator 1
    static class SMSNotifierDecorator extends NotifierDecorator {

        public SMSNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        @Override
        public void send(String message) {
            super.send(message);
            System.out.println("Sending SMS: " + message);
        }
    }

    // Concrete Decorator 2
    static class SlackNotifierDecorator extends NotifierDecorator {

        public SlackNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        @Override
        public void send(String message) {
            super.send(message);
            System.out.println("Sending Slack Message: " + message);
        }
    }

    // Test Class
    public static void main(String[] args) {

        System.out.println("Email Notification:");
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("System Update Available");

        System.out.println("\nEmail + SMS Notification:");
        Notifier smsNotifier =
                new SMSNotifierDecorator(new EmailNotifier());
        smsNotifier.send("System Update Available");

        System.out.println("\nEmail + SMS + Slack Notification:");
        Notifier multiNotifier =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));

        multiNotifier.send("System Update Available");
    }
}