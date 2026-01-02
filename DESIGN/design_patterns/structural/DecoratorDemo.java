interface Price{
    double getPrice();
}

class BasePrice implements Price {
    private final double amount;
    BasePrice(double amount) {
        this.amount = amount;
    }
    @Override
    public double getPrice() {
        return amount;
    }
}
abstract class PaymentDecorator implements Price {
    protected Price price;
    public PaymentDecorator(Price price) {
        this.price = price;
    }
}
class GSTPriceDecorator extends PaymentDecorator {

    public GSTPriceDecorator(Price price) {
        super(price);
    }

    @Override
    public double getPrice() {
        double basePrice = price.getPrice();
        return basePrice + (double)(basePrice * 0.10);
    }
    
}
class PlatformFeePriceDecorator extends PaymentDecorator {

    public PlatformFeePriceDecorator(Price price) {
        super(price);
    }

    @Override
    public double getPrice() {
        double basePrice = price.getPrice();
        return basePrice + 11;
    }
    
}
class RainSurgePriceDecorator extends PaymentDecorator {

    public RainSurgePriceDecorator(Price price) {
        super(price);
    }

    @Override
    public double getPrice() {
        double basePrice = price.getPrice();
        return basePrice + 15;
    }
    
}
public class DecoratorDemo {
    public static void main(String[] args) {
        Price price = new BasePrice(500);
        price = new GSTPriceDecorator(price);
        price = new PlatformFeePriceDecorator(price);
        boolean isRaining = true;

        if(isRaining) {
            price = new RainSurgePriceDecorator(price);
        }

        System.out.println("Final Payable Amount: ₹" + price.getPrice());

    }
}
