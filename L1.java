public class BankAccount {
    // -------- Static members (shared by all accounts) --------
    static String bankName = "MiniBank";
    static int nextAccountNumber = 1001;

    // -------- Instance members (each object has its own copy) --------
    private final int accountNumber = nextAccountNumber++;
    public String owner;
    public double balance;

    // Methods = behavior
    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit failed: amount must be > 0");
            return;
        }
        this.balance += amount;
        System.out.println(this.owner + " deposited " + amount);
    }

    boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw failed: amount must be > 0");
            return false;
        }
        if (amount > this.balance) {
            System.out.println("Withdraw failed: insufficient balance for " + this.owner);
            return false;
        }
        this.balance -= amount;
        System.out.println(this.owner + " withdrew " + amount);
        return true;
    }

    boolean transferTo(BankAccount other, double amount) {
        if (other == null) {
            System.out.println("Transfer failed: other account is null");
            return false;
        }
        System.out.println("Transfer attempt: " + this.owner + " -> " + other.owner + " : " + amount);

        // Withdraw from this account first
        if (this.withdraw(amount)) {
            // Deposit into other account
            other.deposit(amount);
            System.out.println("Transfer successful!");
            return true;
        }
        System.out.println("Transfer failed!");
        return false;
    }

    double getBalance() {
        return this.balance;
    }

    void printSummary() {
        System.out.println("[" + bankName + "] Account #" + this.accountNumber
                + " | Owner: " + this.owner
                + " | Balance: " + this.balance);
    }

    static void printBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Next Account Number: " + nextAccountNumber);
    }
}

public class Main {
    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        // Object creation using 'new'
        BankAccount a1 = new BankAccount();
        a1.owner = "Asha";  a1.balance = 500;
        BankAccount a2 = new BankAccount();
        a2.owner = "Ravi";  a2.balance = 300;

        // Fields are private, so we use methods to work with them
        a1.printSummary();
        a2.printSummary();

        // Deposit & withdraw
        a1.deposit(200);
        a2.withdraw(50);

        // Transfer money between objects
        a1.transferTo(a2, 400);

        // Show summaries again
        a1.printSummary();
        a2.printSummary();

        // Static method (called using class name)
        BankAccount.printBankInfo();

    }
}
