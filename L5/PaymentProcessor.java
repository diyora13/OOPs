package L5;

public class PaymentProcessor {

    // Static method: will be hidden (not overridden)
    static public String type() {
        return "Base";
    }

    // Overriding target: child changes fee calculation
    int feeFor(int amount) {
        return (amount * 2) / 100; // 2% fee
    }

    // ----------- OVERLOADED pay(...) methods -----------

    // 1) Overload: int amount (default method)
    public Transaction pay(String payer, String payee, int amount) {
        return process(payer, payee, amount, "CASH", "pay(int)");
    }

    // 2) Overload: int amount + method
    public Transaction pay(String payer, String payee, int amount, String method) {
        return process(payer, payee, amount, method, "pay(int,String)");
    }

    // 3) Overload: long amount (compile-time choice: 50 vs 50L)
    public Transaction pay(String payer, String payee, long amount) {
        if (amount > Integer.MAX_VALUE) {
            return new Transaction(payer, payee, 0, "CASH", 0, 0, "FAILED", "pay(long)");
        }
        return process(payer, payee, (int) amount, "CASH", "pay(long)");
    }

    // 4) Overload: double amount (rounded)
    public Transaction pay(String payer, String payee, double amount) {
        int rounded = (int) Math.round(amount);
        return process(payer, payee, rounded, "CASH", "pay(double)");
    }

    // ----------- Shared internal processing -----------
    private Transaction process(String payer, String payee, int amount, String method, String route) {
        if (!validName(payer) || !validName(payee)) {
            return new Transaction(payer, payee, 0, safeMethod(method), 0, 0, "FAILED", route);
        }
        if (amount <= 0) {
            return new Transaction(payer, payee, 0, safeMethod(method), 0, 0, "FAILED", route);
        }
        if (!validMethod(method)) {
            return new Transaction(payer, payee, amount, safeMethod(method), 0, amount, "FAILED", route);
        }

        int fee = feeFor(amount); // ✅ overriding happens here at runtime
        int total = amount + fee;
        return new Transaction(payer, payee, amount, method, fee, total, "SUCCESS", route);
    }

    private boolean validName(String s) {
        return s != null && !s.isBlank();
    }

    private boolean validMethod(String method) {
        return method != null && !method.isBlank();
    }

    private String safeMethod(String method) {
        return (method == null || method.isBlank()) ? "NA" : method;
    }

}
