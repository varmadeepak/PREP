import dto.OrderMetaData;
import model.*;
import service.StockBrokerSystem;

public class StockBrokerApplication {
    private static StockBrokerSystem stockBrokerSystem;
    public static void main(String[] args) {
        stockBrokerSystem = StockBrokerSystem.getStockBrokerSystem();
            OrderMetaData orderMetaData = new OrderMetaData(
                "Deepak",                 // customerName
                "INFY",                   // stockSymbol
                10,                        // quantity
                OrderType.LIMIT,           // orderType
                1500.50,                   // limitPrice (only for LIMIT)
                ExchangeType.NSE           // exchange
        );
        stockBrokerSystem.placeOrder(orderMetaData);
    }
}
