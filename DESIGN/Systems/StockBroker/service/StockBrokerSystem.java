package service;
import dto.OrderMetaData;

public class StockBrokerSystem {
    private static StockBrokerSystem instance;
    private OrderService orderService;

    private StockBrokerSystem() {}

    public static StockBrokerSystem getStockBrokerSystem() {
        if (instance == null) {
            instance = new StockBrokerSystem();
        }
        return instance;
    }

    public void placeOrder(OrderMetaData orderMetaData)  {
        orderService = OrderService.getOrderService();
        System.out.println("ATTEMPTING TO PLACE ORDER");
        orderService.placeOrder(orderMetaData);
    }
}
