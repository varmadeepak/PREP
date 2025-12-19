import java.util.List;
import java.util.ArrayList;

class OrderService {
    private List<Observer> observers = new ArrayList<>();
    private String orderStatus;

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    public void unRegisterObserver(Observer observer) {
        observers.remove(observer);
    }
    public void updateOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
        notifyObservers();
    }
    private void notifyObservers() {
        for(Observer observer : observers) {
            observer.updateOrderStatus(orderStatus);
        }
    }
    public int getObserverCount() {
        return observers.size();
    }
}

interface Observer{
    void updateOrderStatus(String orderStatus);
}
class EmailNotificationSender implements Observer {

    @Override
    public void updateOrderStatus(String orderStatus) {
        System.out.println("[EMAIL] Status of your order has been changed to :  " + orderStatus);
    }
    
}
class SMSNotificationSender implements Observer {

    @Override
    public void updateOrderStatus(String orderStatus) {
        System.out.println("[SMS] Status of your order has been changed to :  " + orderStatus);
    }
    
}
class InAppNotificationSender implements Observer {

    @Override
    public void updateOrderStatus(String orderStatus) {
        System.out.println("[IN_APP] Status of your order has been changed to :  " + orderStatus);
    }
    
}

public class ObserverDemo {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        Observer email = new EmailNotificationSender();
        Observer sms = new SMSNotificationSender();
        Observer inApp = new InAppNotificationSender();
        // register 2 subscribers
        orderService.registerObserver(sms);
        orderService.registerObserver(email);

        System.out.println("Total Observers count : " + orderService.getObserverCount());

        // regiter one more subscriber 
        orderService.registerObserver(inApp);
        System.out.println("Total Observers count : " + orderService.getObserverCount());

        orderService.updateOrderStatus("PLACED");
        orderService.updateOrderStatus("CONFIRMED");

        // remove inApp subscriber 
        orderService.unRegisterObserver(inApp);
        System.out.println("Total Observers count : " + orderService.getObserverCount());

        orderService.updateOrderStatus("DISPATCHED");

    }
}
