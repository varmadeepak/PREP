import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PaymentGatewayManager {
    private PaymentGatewayManager() {
        System.out.println("Using Private Constructor once to create object instance");
    }
    private static PaymentGatewayManager instace;
    private static Lock mtx = new ReentrantLock();
    
    public static PaymentGatewayManager getInstance() {
        if(instace == null) {
            mtx.lock(); 
            try {
                if(instace == null) {
                    instace = new PaymentGatewayManager();
                }
            } finally {
                mtx.unlock(); // Always release the lock
            }
        }
        return instace;
    }

    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through the payment gateway.");
    }
}
public class Singleton {
    public static void main(String[] args) {
        PaymentGatewayManager razorPayManager = PaymentGatewayManager.getInstance();
        razorPayManager.processPayment(1000.56);
        PaymentGatewayManager stripePaymentManager = PaymentGatewayManager.getInstance();

        if(razorPayManager == stripePaymentManager) {
            System.out.println("SAME_INSTANCE");
        } else {
            System.out.println("MULTIPLE_INSTANCES");
        }
    }
}
