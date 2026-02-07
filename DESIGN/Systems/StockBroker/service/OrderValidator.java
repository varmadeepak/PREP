package service;
import dto.OrderMetaData;

public class OrderValidator {

    private static OrderValidator instance;

    private OrderValidator() {}

    public static OrderValidator getOrderValidator() {
        if (instance == null) {
            instance = new OrderValidator();
        }
        return instance;
    }

    public boolean validateOrder(OrderMetaData orderMetaData) {
        // validation logic
        return true;
    }
}
