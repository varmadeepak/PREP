package model;

import java.util.UUID;

public class LimitOrder extends Order {

    private final double limitPrice;

    public LimitOrder(UUID orderId,
                      String customerName,
                      double quantity,
                      Stock stock,
                      double totalPrice,
                      OrderStatus status,
                      String orderDate,
                      double limitPrice) {

        super(orderId, customerName, quantity, stock, totalPrice, status, orderDate);
        this.limitPrice = limitPrice;
    }

    public double getLimitPrice() {
        return limitPrice;
    }
}