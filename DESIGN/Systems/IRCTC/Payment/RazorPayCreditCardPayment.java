
public class RazorPayCreditCardPayment extends CreditCardPayment{

    @Override
    public void makeCreditCardPayment(double amount) {
        System.out.println("[RAZOR_PAY] CREDIT_CARD_PAYMENT of amount : " + amount);
    }
    
}
