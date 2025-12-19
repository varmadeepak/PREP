// =====HANDLER [ABSTRACT] =====
abstract class OrderHandler {
    protected OrderHandler nextHandler;

    public void setNextHandler(OrderHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    protected abstract void handle(String order);
}

// =====CONCRETE HANDLERS=====
class OrderValidationHandler extends OrderHandler {

    @Override
    protected void handle(String order) {
        System.out.println("VALIDATING order : " +order);
        if(nextHandler != null) {
            nextHandler.handle(order);
        }
    }
    
}
class OrderInventoryHandler extends OrderHandler {

    @Override
    protected void handle(String order) {
        System.out.println("checking INVENTORY for order : " +order);
        if(nextHandler != null) {
            nextHandler.handle(order);
        }
    }
    
}
class OrderPaymentProcessingHandler extends OrderHandler {

    @Override
    protected void handle(String order) {
        System.out.println("PAYMENT validation for order : " +order);
        if(nextHandler != null) {
            nextHandler.handle(order);
        }
    }
    
}
class OrderDeliveryAssigmentHandler extends OrderHandler {

    @Override
    protected void handle(String order) {
        System.out.println("Assigning DELIVERY Partner for order : " +order);
        if(nextHandler != null) {
            nextHandler.handle(order);
        }
    }
    
}
class OrderTrackingHandler extends OrderHandler {

    @Override
    protected void handle(String order) {
        System.out.println("TRACKING order : " +order);
    }
    
}

public class CORDemo {
    public static void main(String[] args) {
        OrderHandler validation = new OrderValidationHandler();
        OrderHandler inventory = new OrderInventoryHandler();
        OrderHandler payment = new OrderPaymentProcessingHandler();
        OrderHandler delivery = new OrderDeliveryAssigmentHandler();
        OrderHandler tracking = new OrderTrackingHandler();

        validation.setNextHandler(inventory);
        inventory.setNextHandler(payment);
        payment.setNextHandler(delivery);
        delivery.setNextHandler(tracking);

        validation.handle("IPHONE_16_PRO_256_BLACK");
    }
}
