
public class RazorPayPaymentmentFactory extends PaymentFactory {

    @Override
    public UPIPayment createUPIPayment() {
        return new RazorPayUPIPayment();
    }

    @Override
    public CreditCardPayment createCreditCardPayment() {
        return new RazorPayCreditCardPayment();
    }
    
}
