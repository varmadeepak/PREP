interface OrderService {
    void placeOrder(String orderId);
}
class RealOrderService implements OrderService {

    @Override
    public void placeOrder(String orderId) {
        System.out.println("[REAL_ORDER_SERVICE] Placing the order with id : " + orderId);
    }
    
}
class APIGatewayProxy implements OrderService {
    private final RealOrderService realOrderService;
    private final String authToken;
    APIGatewayProxy(String authToken) {
        this.authToken = authToken;
        this.realOrderService = new RealOrderService();
    }

    @Override
    public void placeOrder(String orderId) {
        if (!authenticate()) {
            System.out.println("Unauthorized request. Invalid token.");
            return;
        }

        logRequest(orderId);
        realOrderService.placeOrder(orderId);
    }

    private boolean authenticate() {
        return "VALID_TOKEN".equals(authToken);
    }

    private void logRequest(String orderId) {
       System.out.println("[API_GATEWAY] Placing the order with id : " + orderId);
    }
} 
public class ProxyDemo {
    public static void main(String[] args) {
        OrderService orderService = new APIGatewayProxy("VALID_TOKEN");
        orderService.placeOrder("IPHONE_17");
        
        orderService = new APIGatewayProxy("random-token");
        orderService.placeOrder("IPHONE_17");
    }
}
