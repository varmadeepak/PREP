package repository;

import java.util.UUID;

import model.Order;
import model.OrderStatus;

public interface OrderRepository {
    void saveOrder(Order order);
    Order getOrder(UUID orderId);
    void updateOrderStatus(UUID orderId, OrderStatus status);
}