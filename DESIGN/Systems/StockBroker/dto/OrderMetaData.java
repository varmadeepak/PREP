package dto;

import model.OrderType;
import model.ExchangeType;

public class OrderMetaData {

    private final String customerName;
    private final String stockSymbol;
    private final double quantity;
    private final OrderType orderType;
    private final Double limitPrice;   
    private final ExchangeType exchange;

    public OrderMetaData(String customerName,
                         String stockSymbol,
                         double quantity,
                         OrderType orderType,
                         Double limitPrice,
                         ExchangeType exchange) {

        this.customerName = customerName;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.orderType = orderType;
        this.limitPrice = limitPrice;
        this.exchange = exchange;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public double getQuantity() {
        return quantity;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public Double getLimitPrice() {
        return limitPrice;
    }

    public ExchangeType getExchange() {
        return exchange;
    }
}