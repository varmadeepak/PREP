package service.exchange;

import model.Order;

public class BSEExchange implements StockExchange {
    private static BSEExchange instance;

    private BSEExchange() {}
    public static BSEExchange getBseExchange() {
        if(instance == null) {
            instance = new BSEExchange();
        }
        return instance;
    }
    @Override
    public void executeOrder(Order order) {
        System.out.println("[BSE] Executed Order with id : " + order.getOrderId());
    }
    
}