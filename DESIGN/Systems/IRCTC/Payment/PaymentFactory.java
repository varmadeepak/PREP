
public abstract class PaymentFactory {
    public abstract UPIPayment createUPIPayment();
    public abstract CreditCardPayment createCreditCardPayment();
}

