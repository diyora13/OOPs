public class Product {

    // ----- static members (shared for all products) -----
    private static String storeName = "MiniStore";
    private static int nextId = 1001;
    private static int totalProduct = 0;

    // ----- instance members (each product has its own copy) -----
    private final int id;     // final field: set exactly once
    private String name;
    private int price;

    // 1) no-arg constructor
    Product() {
        this("Unknown", 0); // constructor chaining
    }

    // 2) 1-arg constructor
    Product(String name) {
        this(name, 0); // constructor chaining
    }

    // 3) 2-arg constructor (main constructor)
    Product(String name, int price) {
        this.id = nextId++;        // final field initialization
        this.name = name;
        this.price = price;
        totalProduct++;
    }

    // ----- methods (behavior) -----
    void rename(String name) {
        this.name = name;          // this keyword
    }

    void setPrice(int price) {
        if (price < 0) {
            System.out.println("Price not updated");
            return;
        }
        this.price = price;
    }

    void increasePrice(int amount) {
        if (amount <= 0) {
            System.out.println("Increase not applied");
            return;
        }
        this.price += amount;
    }

    void applyDiscount(int percent) {
        if (percent <= 0 || percent > 100) {
            System.out.println("Discount not applied");
            return;
        }
        int discount = (this.price * percent) / 100;
        this.price -= discount;
    }

    void print() {
        System.out.println("Product id: " + id + " name: " + name + " price: " + price);
    }

    // ----- static methods -----
    static void printStoreInfo() {
        System.out.println("Store name: " + storeName + " Next product id: " + nextId + " Total products: " + totalProduct);
    }
}


public class Main {
    void main() {
        Product.printStoreInfo();
        // Object creation using 'new'
        // Object creation using all constructors
        Product p1 = new Product();
        p1.print();

        Product p2 = new Product("Notebook");
        p2.print();

        Product p3 = new Product("Pen", 10);
        p3.print();

        // Call all instance methods (normal flows)
        p1.rename("Bottle");
        p1.setPrice(50);
        p1.print();

        p2.setPrice(100);
        p2.increasePrice(20);
        p2.applyDiscount(10);
        p2.print();

        // Edge cases (should print error messages)
        p2.applyDiscount(150);   // Discount not applied
        p2.applyDiscount(0);     // Discount not applied
        p2.setPrice(-5);         // Price not updated
        p2.increasePrice(0);     // Increase not applied
        p2.increasePrice(-10);   // Increase not applied

        // Reference behavior (two references pointing to same object)
        Product p4 = p3;
        p4.rename("Blue Pen");
        p3.print();
        p4.print();

        // Static method (class-level info)
        Product.printStoreInfo();
    }
}
