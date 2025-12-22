abstract class OrderProcessor{
    public final void processOrder(){
        validateOrder();
        validateInventory();
        payemntValidation();
        deliveryAssignment();
    }
    abstract void validateOrder();
    abstract void validateInventory();
    abstract void payemntValidation();
    abstract void deliveryAssignment();
}

class LocalOrderProcessor extends OrderProcessor {

    @Override
    void validateOrder() {
       System.out.println("[LOCAL_ORDER] Validating the order");
    }

    @Override
    void validateInventory() {
       System.out.println("[LOCAL_ORDER] Validating the Inventory");
    }

    @Override
    void payemntValidation() {
        System.out.println("[LOCAL_ORDER] Validating the Payment for order");
    }

    @Override
    void deliveryAssignment() {
       System.out.println("[LOCAL_ORDER] Assigning delivery partner for order");
    }
    
}
class InternationalOrderProcessor extends OrderProcessor {

    @Override
    void validateOrder() {
       System.out.println("[INTERNATIONAL_ORDER] Validating the order");
    }

    @Override
    void validateInventory() {
       System.out.println("[INTERNATIONAL_ORDER] Validating the Inventory");
    }

    @Override
    void payemntValidation() {
        System.out.println("[INTERNATIONAL_ORDER] Validating the Payment for order");
    }

    @Override
    void deliveryAssignment() {
       System.out.println("[INTERNATIONAL_ORDER] Assigning delivery partner for order");
    }
    
}
public class TemplateDemo {
    public static void main(String[] args) {
        OrderProcessor localOrder = new LocalOrderProcessor();
        localOrder.processOrder();

        OrderProcessor internationalOrder = new InternationalOrderProcessor();
        internationalOrder.processOrder();
    }
}
