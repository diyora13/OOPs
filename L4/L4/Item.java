package L4;

public class Item {

    private String name;
    private int price;
    protected String category; // protected: child can access directly

    // Parent has ONLY parameterized constructor => child must call super(...)
    public Item(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // private fields cannot be accessed directly by child, so we provide getters
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    // Method reuse: child inherits this method as-is
    public void applyDiscount(int percent) {
        int discount = (price * percent) / 100;
        price = price - discount;
    }

    // protected helper: child can safely update parent's private price
    protected void addToPrice(int amount) {
        price += amount;
    }

    // Used by both parent and child for printing (super keyword use)
    protected String info() {
        return "Name: " + name + " Price: " + price + " Category: " + category;
    }

    // final method: child cannot override this
    public final void print() {
        System.out.println(info());
    }
}
