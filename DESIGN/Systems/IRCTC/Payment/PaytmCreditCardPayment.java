
public class PaytmCreditCardPayment extends CreditCardPayment {

    @Override
    public void makeCreditCardPayment(double amount) {
        System.out.println("[PAYTM] CREDIT_CARD_PAYMENT of amount : " + amount);
    }
    
}
