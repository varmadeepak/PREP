// ============== SUBSYSTEMS ==========
class InventoryService {
    public void validateOrder(String orderId) {
        System.out.println("VALIDATING Order for id : " + orderId);
    }
}
class PaymentService {
    public void makePayment(String orderId) {
        System.out.println("Payment processing for order "+ orderId);
    } 
}
class NotificationService{
    public void sendConfirmation(String orderId) {
        System.out.println("ORDER : "+ orderId + " CONFIRMED");
    }
}
// ============== FACADE ==========
class CheckoutFacade {
    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final NotificationService notificationService;

    CheckoutFacade() {
        this.inventoryService = new InventoryService();
        this.paymentService = new PaymentService();
        this.notificationService = new NotificationService();
    }
    public void placeOrder(String orderId) {
        inventoryService.validateOrder(orderId);
        paymentService.makePayment(orderId);
        notificationService.sendConfirmation(orderId);
    }
}
public class FacadeDemo {
    public static void main(String[] args) {
        CheckoutFacade facade = new CheckoutFacade();
        facade.placeOrder("IPHONE_17");
    }
}
