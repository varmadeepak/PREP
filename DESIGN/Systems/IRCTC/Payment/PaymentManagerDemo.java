
public class PaymentManagerDemo {
    public static void main(String[] args) {
        PaymentManager paymentManager = PaymentManager.getPaymentManager();
        PaymentFactory paytmPaymentFactory = new PaytmPaymentFactory();
        paymentManager.processPaymentWithCreditCard(paytmPaymentFactory, 1500);

        PaymentFactory razorPayFactory = new RazorPayPaymentmentFactory();
        paymentManager.processPaymentWithUPI(razorPayFactory, 20000);
    }
}

