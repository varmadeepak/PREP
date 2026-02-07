package model.factory;

import dto.OrderMetaData;
import model.Order;

public interface OrderFactory {
    public Order createOrder(OrderMetaData orderMetaData);
}
