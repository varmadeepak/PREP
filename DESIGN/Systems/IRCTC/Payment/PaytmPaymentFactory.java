
public class PaytmPaymentFactory extends PaymentFactory{

    @Override
    public UPIPayment createUPIPayment() {
        return new PaytmUPIPayment();
    }

    @Override
    public CreditCardPayment createCreditCardPayment() {
       return new PaytmCreditCardPayment();
    }
    
}
