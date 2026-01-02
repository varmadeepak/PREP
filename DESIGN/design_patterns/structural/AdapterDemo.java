interface PaymentGateway {
    void pay(int amount);
}
class RazorPayPaymentGateway implements PaymentGateway {

    @Override
    public void pay(int amount) {
        System.out.println("[RAZOR_PAY] Making payment for amount : " + amount);
    }
    
}
class StripePaymentGatewayAdapter implements PaymentGateway {
    private final StripeAPI stripeAPI;

    StripePaymentGatewayAdapter(StripeAPI stripeAPI) {
        this.stripeAPI = stripeAPI;
    }

    @Override
    public void pay(int amount) {
        stripeAPI.makePayment(amount);
    }

}
class StripeAPI {
    public void makePayment(int amount) {
         System.out.println("[STRIPE] Making payment for amount : " + amount);
    }
}
class CheckoutService {
    private PaymentGateway paymentGateway;

    public void setPaymentGateway(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
    public void initiatePayment(int amount) {
        paymentGateway.pay(amount);
    }
}
public class AdapterDemo {
    public static void main(String[] args) {
        PaymentGateway razorPay = new RazorPayPaymentGateway();
        CheckoutService service = new CheckoutService();
        service.setPaymentGateway(razorPay);
        service.initiatePayment(5000);

        StripeAPI stripeAPI = new StripeAPI();
        PaymentGateway stripe = new StripePaymentGatewayAdapter(stripeAPI);
        service.setPaymentGateway(stripe);
        service.initiatePayment(10000);
    }
}