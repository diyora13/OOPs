import L11.*;

import java.util.HashSet;
import java.util.Set;

public class Main {
    void main() {
        Wallet a = new Wallet("Asha", 100);

        // Baseline
        a.print(); // Owner: Asha Balance: 100

        // ===== Unchecked exception demo: deposit invalid amount =====
        try {
            a.deposit(0); // invalid -> IllegalArgumentException
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage()); // Error: Amount must be > 0
        } finally {
            a.print(); // Owner: Asha Balance: 100
        }

        // Valid deposit
        try {
            a.deposit(40);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            a.print(); // Owner: Asha Balance: 140
        }

        // ===== Checked vs Unchecked in withdraw =====
        // Case 1: Unchecked (invalid argument)
        try {
            a.withdraw(0); // invalid -> IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // Error: Amount must be > 0
        } catch (InsufficientFundsException e) {
            System.out.println("FundsError: " + e.getMessage());
        } finally {
            a.print(); // Owner: Asha Balance: 140
        }

        // Case 2: Checked (insufficient funds)
        try {
            a.withdraw(999); // too much -> InsufficientFundsException
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("FundsError: " + e.getMessage()); // FundsError: Not enough balance
        } finally {
            a.print(); // Owner: Asha Balance: 140
        }

        // Valid withdraw
        try {
            a.withdraw(20);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            a.print(); // Owner: Asha Balance: 120
        }

        // ===== Unchecked NumberFormatException demo =====
        try {
            int amt = Wallet.parseAmount("15");
            a.deposit(amt);
        } catch (NumberFormatException e) {
            System.out.println("ParseError: bad number");
        } finally {
            a.print(); // Owner: Asha Balance: 135
        }

        try {
            int amt = Wallet.parseAmount("abc"); // throws NumberFormatException
            a.deposit(amt);
        } catch (NumberFormatException e) {
            System.out.println("ParseError: bad number"); // ParseError: bad number
        } finally {
            a.print(); // Owner: Asha Balance: 135
        }

        // ===== Custom checked exception + throw vs throws =====
        try {
            a.runAudit(); // throws AuditException
            System.out.println("Audit OK");
        } catch (AuditException e) {
            System.out.println("AuditError: " + e.getMessage()); // AuditError: Audit failed for Asha
        } finally {
            a.print(); // Owner: Asha Balance: 135
        }
    }
}
