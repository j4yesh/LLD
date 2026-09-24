
interface PaymentStrategy {

    public void processPayment();
}

class CreditCardPayment implements PaymentStrategy {

    public void processPayment() {
        System.out.println(" Processing payment with credit card");
    }
}

class CryptoPayment implements PaymentStrategy {

    public void processPayment() {
        System.out.println(" Processing payment with crypto");
    }
}

class PaymentProcessor {

    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void process() {
        strategy.processPayment();
    }
}

class Strategy {

    public static void main(String[] jayesh) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.setStrategy(new CreditCardPayment());
        processor.process();

        processor.setStrategy(new CryptoPayment());
        processor.process();
    }
}
