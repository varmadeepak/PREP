import java.util.ArrayList;
import java.util.List;

// ===== COMPONENT =====
interface OrderComponent {
    double getPrice();
    void print();
}

// ===== LEAF =====
class Product implements OrderComponent {

    private final String name;
    private final double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.println("Product: " + name + " | Price: ₹" + price);
    }
}

// ===== COMPOSITE =====
class ProductBundle implements OrderComponent {

    private final String bundleName;
    private final List<OrderComponent> components = new ArrayList<>();

    ProductBundle(String bundleName) {
        this.bundleName = bundleName;
    }

    public void add(OrderComponent component) {
        components.add(component);
    }

    public void remove(OrderComponent component) {
        components.remove(component);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (OrderComponent component : components) {
            total += component.getPrice();
        }
        return total;
    }

    @Override
    public void print() {
        System.out.println("\nBundle: " + bundleName);
        System.out.println("--------------------");
        for (OrderComponent component : components) {
            component.print();
        }
        System.out.println("Bundle Total: ₹" + getPrice());
    }
}

// ===== CLIENT =====
public class CompositeDemo {

    public static void main(String[] args) {

        // Individual products
        Product phone = new Product("IPHONE 17", 82000);
        Product charger = new Product("FAST CHARGER", 5000);
        Product earphones = new Product("AIRPODS", 3000);

        // Phone combo
        ProductBundle phoneCombo = new ProductBundle("PHONE COMBO");
        phoneCombo.add(phone);
        phoneCombo.add(charger);
        phoneCombo.print();

        // Mega combo (bundle inside bundle)
        ProductBundle megaCombo = new ProductBundle("MEGA COMBO");
        megaCombo.add(phoneCombo);
        megaCombo.add(earphones);

        // Client treats everything uniformly
        megaCombo.print();
    }
}