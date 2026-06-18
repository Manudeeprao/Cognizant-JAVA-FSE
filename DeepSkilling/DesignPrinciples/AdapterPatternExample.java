public class AdapterPatternExample {

    // Target Interface
    interface PaymentProcessor {
        void processPayment(double amount);
    }

    // Adaptee 1
    static class PayPalGateway {
        public void makePayment(double amount) {
            System.out.println("Payment of Rs." + amount + " processed using PayPal.");
        }
    }

    // Adaptee 2
    static class StripeGateway {
        public void pay(double amount) {
            System.out.println("Payment of Rs." + amount + " processed using Stripe.");
        }
    }

    // Adapter for PayPal
    static class PayPalAdapter implements PaymentProcessor {

        private PayPalGateway payPalGateway;

        public PayPalAdapter(PayPalGateway payPalGateway) {
            this.payPalGateway = payPalGateway;
        }

        @Override
        public void processPayment(double amount) {
            payPalGateway.makePayment(amount);
        }
    }

    // Adapter for Stripe
    static class StripeAdapter implements PaymentProcessor {

        private StripeGateway stripeGateway;

        public StripeAdapter(StripeGateway stripeGateway) {
            this.stripeGateway = stripeGateway;
        }

        @Override
        public void processPayment(double amount) {
            stripeGateway.pay(amount);
        }
    }

    // Test Class
    public static void main(String[] args) {

        PaymentProcessor paypal =
                new PayPalAdapter(new PayPalGateway());

        PaymentProcessor stripe =
                new StripeAdapter(new StripeGateway());

        paypal.processPayment(5000);
        stripe.processPayment(7500);
    }
}