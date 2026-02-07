package service.exchange;
import model.Order;
public interface StockExchange {
   public void executeOrder(Order order);
}
