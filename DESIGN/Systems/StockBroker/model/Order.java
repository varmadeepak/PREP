package model;

import java.util.UUID;

public abstract class Order {

    private final UUID orderId;
    private final String customerName;
    private final double quantity;
    private final Stock stock;

    private double totalPrice;
    private OrderStatus status;
    private String orderDate;

    protected Order(UUID orderId,
                    String customerName,
                    double quantity,
                    Stock stock,
                    double totalPrice,
                    OrderStatus status,
                    String orderDate) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.quantity = quantity;
        this.stock = stock;
        this.totalPrice = totalPrice;
        this.status = status;
        this.orderDate = orderDate;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getQuantity() {
        return quantity;
    }

    public Stock getStock() {
        return stock;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}