package repository;

import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

import model.Order;
import model.OrderStatus;


public class InMemmoryOrderRepository implements OrderRepository {
    private static InMemmoryOrderRepository instance;
    Map<UUID, Order> ordersMap = new HashMap<>();

    private InMemmoryOrderRepository() {}

    public static InMemmoryOrderRepository getInMemmoryOrderRepository() {
        if (instance == null) {
            instance = new InMemmoryOrderRepository();
        }
        return instance;
    }

    @Override
    public void saveOrder(Order order) {
        System.out.println("ORDER WITH ID : " + order.getOrderId() + "SAVED SUCCESSFULLY");
        ordersMap.putIfAbsent(order.getOrderId(), order);
    }

    @Override
    public Order getOrder(UUID orderId) {

        return ordersMap.get(orderId);
    }

    @Override
    public void updateOrderStatus(UUID orderId, OrderStatus status) {
        System.out.println("Order status updated to : " + status);
    }
    
}
