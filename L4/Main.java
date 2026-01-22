import L4.*;

public class Main {
    void main() {
      // ----- Base class object -----
      Item local = new Item("Pen", 20, "Stationery");
      local.print(); // Name: Pen Price: 20 Category: Stationery
  
      local.applyDiscount(10);
      local.print(); // Name: Pen Price: 18 Category: Stationery
  
      // ----- Child class object -----
      ImportedItem imp = new ImportedItem("Watch", 100, "Accessories", "Japan", 10);
      imp.printDetailed(); // Name: Watch Price: 100 Category: Accessories Country: Japan Duty: 10
  
      // Reuse parent method (no override involved)
      imp.applyDiscount(20);
      imp.printDetailed(); // Name: Watch Price: 80 Category: Accessories Country: Japan Duty: 10
  
      // Child adds extra behavior
      imp.applyDuty();
      imp.printDetailed(); // Name: Watch Price: 88 Category: Accessories Country: Japan Duty: 10
  
      // protected member access from child
      imp.makeCategoryUpper();
      imp.printDetailed(); // Name: Watch Price: 88 Category: ACCESSORIES Country: Japan Duty: 10
  
      // child can still use parent's final print()
      imp.print(); // Name: Watch Price: 88 Category: ACCESSORIES
  
      // final class usage (just to show it exists)
      FixedPolicy policy = new FixedPolicy();
      policy.show(); // Policy active
  }
}
