package L11;

public class Wallet {
    private final String owner;
    private int balance;

    public Wallet(String owner, int opening) {
        this.owner = (owner == null || owner.isBlank()) ? "Unknown" : owner;
        this.balance = Math.max(0, opening);
    }

    public void deposit(int amount) {
        // Unchecked exception: caller is not forced to catch
        if (amount <= 0) throw new IllegalArgumentException("Amount must be > 0");
        balance += amount;
    }

    public void withdraw(int amount) throws InsufficientFundsException {
        // Mixed: unchecked for invalid argument, checked for business failure
        if (amount <= 0) throw new IllegalArgumentException("Amount must be > 0"); // unchecked
        if (amount > balance) throw new InsufficientFundsException("Not enough balance"); // checked
        balance -= amount;
    }

    public static int parseAmount(String txt) {
        // Unchecked NumberFormatException will propagate unless caught
        return Integer.parseInt(txt);
    }

    public void runAudit() throws AuditException {
        // Pretend some verification failed
        throw new AuditException("Audit failed for " + owner);
    }

    public void print() {
        System.out.println("Owner: " + owner + " Balance: " + balance);
    }
}