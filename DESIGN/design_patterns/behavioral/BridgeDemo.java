interface Payment {
    void pay(double amount);
}
class EMIPayment implements Payment {
    private final PaymentGateway paymentGateway;
    EMIPayment(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
    @Override
    public void pay(double amount) {
        System.out.println("<===== EMI =====>");
        paymentGateway.processPayment(amount);
    }
    
}
class SubscriptionPayment implements Payment {
    private final PaymentGateway paymentGateway;
    SubscriptionPayment(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
    @Override
    public void pay(double amount) {
        System.out.println("<===== SUBSCRIPTION =====>");
        paymentGateway.processPayment(amount);
    }
    
}
interface PaymentGateway {
    void processPayment(double amount);
}
class RazorPayPaymentGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
         System.out.println("[RAZORPAY] Payment being done of amount : " + amount);
    }
    
}
class StripePaymentGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("[STRIPE] Payment being done of amount : " + amount);
    }
    
}
public class BridgeDemo {
    public static void main(String[] args) {
        PaymentGateway razorPay = new RazorPayPaymentGateway();
        Payment razorPayWithEMI = new EMIPayment(razorPay);
        razorPayWithEMI.pay(5000);

        PaymentGateway stripe = new StripePaymentGateway();
        Payment stripeWithEMI = new EMIPayment(stripe);
        stripeWithEMI.pay(5000);

        Payment stripeWithSubscription = new SubscriptionPayment(stripe);
        stripeWithSubscription.pay(5000);

        Payment razorPayWithSubscription = new SubscriptionPayment(razorPay);
        razorPayWithSubscription.pay(10000);

    }
}
    