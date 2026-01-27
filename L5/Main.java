import L5.*;

public class Main {
    void main() {
      PaymentProcessor base = new PaymentProcessor();
      PremiumPaymentProcessor premium = new PremiumPaymentProcessor();
      
      // Runtime binding demo: reference type is parent, object is child
      PaymentProcessor ref = new PremiumPaymentProcessor();
      
      // ----- Static method hiding demo -----
      System.out.println("Type: " + PaymentProcessor.type()); // Type: Base
      System.out.println("Type: " + PremiumPaymentProcessor.type()); // Type: Premium
      System.out.println("Type: " + ref.type()); // Type: Base
      
      // ----- Overloading demo -----
      Transaction t1 = base.pay("Asha", "Shop", 100);
      t1.print(); // Payer: Asha Payee: Shop Amount: 100 Method: CASH Fee: 2 Total: 102 Status: SUCCESS Route: pay(int)
      
      Transaction t2 = base.pay("Asha", "Shop", 100, "CARD");
      t2.print(); // Payer: Asha Payee: Shop Amount: 100 Method: CARD Fee: 2 Total: 102 Status: SUCCESS Route: pay(int,String)
      
      Transaction t3 = base.pay("Asha", "Shop", 5000000);
      t3.print(); // Payer: Asha Payee: Shop Amount: 50 Method: CASH Fee: 1 Total: 51 Status: SUCCESS Route: pay(long)
      
      Transaction t4 = base.pay("Asha", "Shop", 99.6);
      t4.print(); // Payer: Asha Payee: Shop Amount: 100 Method: CASH Fee: 2 Total: 102 Status: SUCCESS Route: pay(double)
      
      // ----- Overriding demo (fee differs for premium) -----
      Transaction t5 = premium.pay("Asha", "Shop", 100, "CARD");
      t5.print(); // Payer: Asha Payee: Shop Amount: 100 Method: CARD Fee: 1 Total: 101 Status: SUCCESS Route: pay(int,String)
      
      // Runtime binding: parent reference but child object -> uses overridden feeFor()
      Transaction t6 = ref.pay("Asha", "Shop", 100, "CARD");
      t6.print(); // Payer: Asha Payee: Shop Amount: 100 Method: CARD Fee: 1 Total: 101 Status: SUCCESS Route: pay(int,String)
      
      // ----- Edge cases (relevant to this lecture) -----
      Transaction t7 = base.pay("Asha", "Shop", 0, "CARD");
      t7.print(); // Payer: Asha Payee: Shop Amount: 0 Method: CARD Fee: 0 Total: 0 Status: FAILED Route: pay(int,String)
      
      Transaction t8 = base.pay("Asha", "Shop", 100, " ");
      t8.print(); // Payer: Asha Payee: Shop Amount: 100 Method: NA Fee: 0 Total: 100 Status: FAILED Route: pay(int,String)
      
      Transaction t9 = base.pay(" ", "Shop", 100);
      t9.print(); // Payer:   Payee: Shop Amount: 0 Method: CASH Fee: 0 Total: 0 Status: FAILED Route: pay(int)
      
      Transaction t10 = base.pay("Asha", "Shop", (long) Integer.MAX_VALUE + 5);
      t10.print(); // Payer: Asha Payee: Shop Amount: 0 Method: CASH Fee: 0 Total: 0 Status: FAILED Route: pay(long)
  }
}

