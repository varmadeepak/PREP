
public class RazorPayUPIPayment extends UPIPayment {

    @Override
    public void makeUPIPayment(double amount) {
        System.out.println("[RAZOR_PAY] UPI_PAYMENT of amount : " + amount);
    }
    
}
