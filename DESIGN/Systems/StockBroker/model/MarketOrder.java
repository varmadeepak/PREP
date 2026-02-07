package model;

import java.util.UUID;

public class MarketOrder extends Order {

    public MarketOrder(UUID orderId,
                       String customerName,
                       double quantity,
                       Stock stock,
                       double totalPrice,
                       OrderStatus status,
                       String orderDate) {

        super(orderId, customerName, quantity, stock, totalPrice, status, orderDate);
    }
}