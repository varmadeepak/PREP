import java.util.List;
// ===== DOMAIN =====
class Order{
    String id;
    double amount;
    Order(String id,double amount) {
        this.id = id;
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "Order{id='" + id + "', amount=" + amount + "}";
    }
}

// ===== AGGREGATE [ABSTRACT] =====
interface OrderRepository {
    Iterator createIterator();
}

// ===== CONCRETE AGGREGATES =====
class CacheOrderRepository implements OrderRepository {
    private List<Order> orders;
    CacheOrderRepository(List<Order> orders) {
        this.orders = orders;
    }
    @Override
    public Iterator createIterator() {
       return new CacheOrderIterator(orders);
    } 
}
class DBOrderRepository implements OrderRepository {
     private Order[] orders;
    DBOrderRepository(Order[] orders) {
        this.orders = orders;
    }
    @Override
    public Iterator createIterator() {
       return new DBOrderIterator(orders);
    }
    
}
// ===== ITERATOR [ABSTRACT]=====
interface Iterator {
    boolean hasNext();
    Order next();
}

// ===== CONCRETE ITERATORS =====
class CacheOrderIterator implements Iterator {
    private List<Order> orders;
    private int index = 0;
    CacheOrderIterator(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean hasNext() {
        return index < orders.size();
    }

    @Override
    public Order next() {
       if(hasNext()) {
        return orders.get(index++);
       }
       return null;
    }
    
}
class DBOrderIterator implements Iterator {
    private Order[] orders;
    private int index =0;
    DBOrderIterator(Order[] orders) {
        this.orders = orders;
    }

    @Override
    public boolean hasNext() {
        return index < orders.length;
    }

    @Override
    public Order next() {
       if(hasNext()) {
        return orders[index++];
       }
       return null;
    }
    
}
// ===== CLIENT =====
class OrderHistoryService {
    public void showOrders(OrderRepository orderRepository) {
        Iterator iterator = orderRepository.createIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
public class IteratorDemo {
    public static void main(String[] args) {
        List<Order> cahceOrders = List.of(
            new Order("C_ORDER_1",100.5),
            new Order("C_ORDER_2",200.5)
        );

        Order[] dbOrders = {
            new Order("D_ORDER_1",500.5),
            new Order("D_ORDER_2",700.5)
        };

        OrderRepository cacheRepo = new CacheOrderRepository(cahceOrders);
        OrderRepository dbRepo = new DBOrderRepository(dbOrders);

        OrderHistoryService orderHistoryService = new OrderHistoryService();
        orderHistoryService.showOrders(cacheRepo);
        orderHistoryService.showOrders(dbRepo);
    }
}
