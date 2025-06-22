public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

       
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        context.executePayment(250.0);

        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.executePayment(120.5);
    }
}
