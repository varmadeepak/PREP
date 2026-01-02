
public class PaytmUPIPayment extends UPIPayment {

    @Override
    public void makeUPIPayment(double amount) {
        System.out.println("[PAYTM] UPI_PAYMENT of amount : " + amount);
    }
    
}
