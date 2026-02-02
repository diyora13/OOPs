package L10;
import java.util.Objects;

// ---------- Mutable class to show what can go wrong in hash collections ----------
public class MutableItem {
    private String name;
    private int price;
    private String category;

    public MutableItem(String name, int price, String category) {
        this.name = name; this.price = price; this.category = category;
    }

    public void setName(String n)      { this.name = n; }
    public void setPrice(int p)        { this.price = p; }
    public void setCategory(String c)  { this.category = c; }

    @Override
    public String toString() {
        return "Name: " + name + " Price: " + price + " Category: " + category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MutableItem m)) return false;
        return this.price == m.price
                && Objects.equals(this.name, m.name)
                && Objects.equals(this.category, m.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, category);
    }
}

