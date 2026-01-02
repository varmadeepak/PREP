public class PaymentManager {
    private static PaymentManager paymentManager;
    private PaymentFactory paymentFactory;
    private UPIPayment upiPayment;
    private CreditCardPayment creditCardPayment;
    private PaymentManager() {}
    public static PaymentManager getPaymentManager() {
        if(null == paymentManager) {
            paymentManager = new PaymentManager();
        }
        return paymentManager;
    }

    public void processPaymentWithCreditCard(PaymentFactory paymentFactory,double amount) {
       CreditCardPayment creditCardPayment = paymentFactory.createCreditCardPayment();
       creditCardPayment.makeCreditCardPayment(amount);
    }

     public void processPaymentWithUPI(PaymentFactory paymentFactory,double amount) {
       UPIPayment upiPayment = paymentFactory.createUPIPayment();
       upiPayment.makeUPIPayment(amount);
    }
}