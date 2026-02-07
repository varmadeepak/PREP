package model.factory;

import dto.OrderMetaData;
import model.LimitOrder;
import model.OrderStatus;
import model.Stock;
import model.Order;
import java.util.UUID;
import java.time.LocalDate;

public class LimitOrderFactory implements OrderFactory {

    @Override
    public Order createOrder(OrderMetaData meta) {

        Stock stock = new Stock("stock123","HDFC",450.59);
        UUID orderId = UUID.randomUUID();

        return new LimitOrder(
                orderId,
                meta.getCustomerName(),
                meta.getQuantity(),
                stock,
                meta.getQuantity() * meta.getLimitPrice(),
                OrderStatus.CREATED,
                LocalDate.now().toString(),
                meta.getLimitPrice()
        );
    }
    
}
