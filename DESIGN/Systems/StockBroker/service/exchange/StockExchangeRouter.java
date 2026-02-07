package service.exchange;
import model.Order;
public class StockExchangeRouter {
    private static StockExchangeRouter instance;
    private StockExchange stockExchange;
    private StockExchangeRouter() {}

    public static StockExchangeRouter getStockExchangeRouter() {
        if (instance == null) {
            instance = new StockExchangeRouter();
        }
        return instance;
    }

    public void routeOrder(Order order) {
        // route order to the appropriate exchange
        stockExchange = NSEExchange.getNseExchange();
        stockExchange.executeOrder(order);
    }
}
