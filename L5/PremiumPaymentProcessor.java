package L5;

public class PremiumPaymentProcessor extends PaymentProcessor {

    // Static method hiding (not overriding)
    static public String type() {
        return "Premium";
    }

    //  Overriding (runtime polymorphism)
    @Override
    int feeFor(int amount) {
        return (amount * 1) / 100; // 1% fee
    }

}
