package service.exchange;

import model.Order;

public class NSEExchange implements StockExchange {
    private static NSEExchange instance;

    private NSEExchange() {}
    public static NSEExchange getNseExchange() {
        if(instance == null) {
            instance = new NSEExchange();
        }
        return instance;
    }
    @Override
    public void executeOrder(Order order) {
        System.out.println("[NSE] Executed Order with id : " + order.getOrderId());
    }
    
}
