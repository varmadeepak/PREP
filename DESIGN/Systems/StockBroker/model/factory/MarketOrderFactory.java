package model.factory;

import dto.OrderMetaData;
import model.MarketOrder;
import model.OrderStatus;
import model.Stock;
import model.Order;
import java.util.UUID;
import java.time.LocalDate;

public class MarketOrderFactory implements OrderFactory {

    @Override
    public Order createOrder(OrderMetaData meta) {

        Stock stock = new Stock("stock123","HDFC",450.59); // resolved or stubbed
        UUID orderId = UUID.randomUUID();

        return new MarketOrder(
                orderId,
                meta.getCustomerName(),
                meta.getQuantity(),
                stock,
                0.0, // calculated later
                OrderStatus.CREATED,
                LocalDate.now().toString()
        );
    }
    
}
