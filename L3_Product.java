// ----------------- src/store/Product.java file -------------------- //
package store;

public class Product {

    private String name;
    private int price;
    private String category;
    private int stock;

    public Product() {
        this.name = "Unknown";
        this.price = 0;
        this.category = "General";
        this.stock = 0;
    }

    public Product(String name, int price, String category) {
        this(); // start with safe defaults
        setName(name);
        setPrice(price);
        setCategory(category);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    public void setName(String name) {
        if (!Rules.validName(name)) {
            System.out.println("Name not updated");
            return;
        }
        this.name = name;
    }

    public void setPrice(int price) {
        if (!Rules.validPrice(price)) {
            System.out.println("Price not updated");
            return;
        }
        this.price = price;
    }

    public void setCategory(String category) {
        if (!Rules.validCategory(category)) {
            System.out.println("Category not updated");
            return;
        }
        this.category = category;
    }

    public void applyDiscount(int percent) {
        if (!Rules.validDiscount(percent)) {
            System.out.println("Discount not applied");
            return;
        }
        int discount = (this.price * percent) / 100;
        this.price = this.price - discount;
    }

    public void addStock(int amount) {
        if (!Rules.validStockChange(amount)) {
            System.out.println("Stock not updated");
            return;
        }
        this.stock += amount;
    }

    public void buy(int quantity) {
        if (quantity <= 0) {
            System.out.println("Purchase not applied");
            return;
        }
        if (quantity > this.stock) {
            System.out.println("Purchase not applied");
            return;
        }
        this.stock -= quantity;
    }

    public void print() {
        System.out.println(
                "Name: " + name +
                        " Price: " + price +
                        " Category: " + category +
                        " Stock: " + stock
        );
    }
}



// ----------------- src/store/Rules.java file -------------------- //
package store;

class Rules {

    static boolean validName(String name) {
        return name != null && !name.isBlank();
    }

    static boolean validPrice(int price) {
        return price >= 0;
    }

    static boolean validCategory(String category) {
        return category != null && !category.isBlank();
    }

    static boolean validDiscount(int percent) {
        return percent > 0 && percent <= 100;
    }

    static boolean validStockChange(int amount) {
        return amount > 0;
    }
}



// ----------------- Main.java file -------------------- //
import store.Product;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Product p = new Product("Pen", 10, "Stationery");
    p.print();

    // setName (valid + invalid)
    p.setName("Blue Pen");
    p.print();

    p.setName(" ");
    p.print();

    p.setName(null);
    p.print();

    // setPrice (valid + invalid)
    p.setPrice(25);
    p.print();

    p.setPrice(-5);
    p.print();

    // setCategory (valid + invalid)
    p.setCategory("Office");
    p.print();

    p.setCategory("");
    p.print();

    p.setCategory(null);
    p.print();

    // applyDiscount (valid + edge cases)
    p.applyDiscount(10);
    p.print();

    p.applyDiscount(0);
    p.print();

    p.applyDiscount(150);
    p.print();

    // stock operations (valid + edge cases)
    p.addStock(5);
    p.print();

    p.addStock(0);
    p.print();

    p.addStock(-2);
    p.print();

    // buying (valid + edge cases)
    p.buy(3);
    p.print();

    p.buy(0);
    p.print();

    p.buy(-1);
    p.print();

    p.buy(10);
    p.print();
}
