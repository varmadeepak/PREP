package service;
import dto.OrderMetaData;
import model.factory.MarketOrderFactory;
import model.factory.OrderFactory;
import model.Order;
import repository.InMemmoryOrderRepository;
import repository.OrderRepository;
import service.exchange.StockExchangeRouter;
public class OrderService {
    private static OrderService instance;
    private OrderValidator orderValidator;
    private OrderRepository orderRepository;
    private StockExchangeRouter stockExchangeRouter;
    private OrderFactory orderFactory = new MarketOrderFactory();
    private OrderService() {}


    public static OrderService getOrderService() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }
    public boolean validateOrder(OrderMetaData orderMetaData) {
        orderValidator = OrderValidator.getOrderValidator();
        return orderValidator.validateOrder(orderMetaData);
    }
    public void placeOrder(OrderMetaData orderMetaData) {
        if(validateOrder(orderMetaData)) {
            System.out.println("ORDER PLACED");
            // create order 
            Order order = orderFactory.createOrder(orderMetaData);
            // direct to exchange 
            stockExchangeRouter = StockExchangeRouter.getStockExchangeRouter();
            stockExchangeRouter.routeOrder(order);
            // save in db
            orderRepository = InMemmoryOrderRepository.getInMemmoryOrderRepository();
            orderRepository.saveOrder(order);
        }
       else {
        System.out.println("ORDER_VALIDATION_FAILED");
       }
    }
}
