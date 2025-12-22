
// ===== STRATEGY [ABSTRACT] =====

interface PaymentStrategy {
    void pay(int amount);
}

// ===== CONCRETE STRATEGIES =====
class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("CARD_PAYMENT for amount : " + amount);
    }
    
}
class UPIPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("UPI_PAYMENT for amount : " + amount);
    }
    
}
class WalletPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("WALLET_PAYMENT for amount : " + amount);
    }
    
}

// ===== CONTEXT=====
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public void pay(int amount) {
        paymentStrategy.pay(amount);
    }
}

// ===== CLIENT =====
public class StrategyDemo {
    public static void main(String[] args) {
        PaymentStrategy cardPayment = new CardPaymentStrategy();
        PaymentStrategy upiPayment = new UPIPaymentStrategy();
        PaymentStrategy walletPayment = new WalletPaymentStrategy();

        PaymentContext context = new PaymentContext();
        context.setStrategy(cardPayment);
        context.pay(500);

        context.setStrategy(upiPayment);
        context.pay(1000);

        context.setStrategy(walletPayment);
        context.pay(5000);
    }
}
