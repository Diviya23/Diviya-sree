public class DecoratorPatternTest {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();

        // Decorate with SMS
        Notifier smsAndEmailNotifier = new SMSNotifierDecorator(emailNotifier);

        // Decorate with Slack as well
        Notifier fullNotifier = new SlackNotifierDecorator(smsAndEmailNotifier);

        System.out.println("Sending notification via Email only:");
        emailNotifier.send("Hello User!");

        System.out.println("\nSending notification via Email and SMS:");
        smsAndEmailNotifier.send("Hello User!");

        System.out.println("\nSending notification via Email, SMS, and Slack:");
        fullNotifier.send("Hello User!");
    }
}
