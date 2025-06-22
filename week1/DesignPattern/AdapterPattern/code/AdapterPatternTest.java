public class AdapterPatternTest {
    public static void main(String[] args) {
        PayPal paypal = new PayPal();
        Stripe stripe = new Stripe();

        PaymentProcessor paypalProcessor = new PayPalAdapter(paypal);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);

        paypalProcessor.processPayment(100.0);
        stripeProcessor.processPayment(250.0);
    }
}
