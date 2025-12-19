// ===== RECEIVER =====
class OrderService{
    public void placeOrder() {
        System.out.println("Order PLACED successfully");
    }
    public void cancelOrder() {
        System.out.println("Order CANCELLED successfully");
    }
    public void shipOrder() {
        System.out.println("Order SHIPPED successfully");
    }
    
}
// ===== ABSTRACT COMMAND =====
interface Command {
    void execute();
}
// ===== CONCRETE COMMANDs =====
class PlaceOrderCommand implements Command{
    private OrderService orderService;
    PlaceOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute() {
        orderService.placeOrder();
    }
    
}
class CancelOrderCommand implements Command{
    private OrderService orderService;
    CancelOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute() {
        orderService.cancelOrder();
    }
    
}
class ShipOrderCommand implements Command{
    private OrderService orderService;
    ShipOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute() {
        orderService.shipOrder();
    }
    
}
// =====INVOKER =====
class OrderController{
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void handleRequest() {
        command.execute();
    }
}
public class CommadDemo {
    public static void main(String[] args) {
        
        OrderService orderService = new OrderService();

        Command placeOrderCommand = new PlaceOrderCommand(orderService);
        Command cancelOrderCommand = new CancelOrderCommand(orderService);
        Command shipOrderCommand = new ShipOrderCommand(orderService);

        OrderController orderController = new OrderController();

        orderController.setCommand(placeOrderCommand);
        orderController.handleRequest();

        orderController.setCommand(cancelOrderCommand);
        orderController.handleRequest();

        orderController.setCommand(shipOrderCommand);
        orderController.handleRequest();

    }
}
