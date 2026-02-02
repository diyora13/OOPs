package L10;
import java.util.Objects;

// ---------- Immutable value class with proper Object contracts ----------
public final class Item {
    private final String name;
    private final int price;
    private final String category;

    public Item(String name, int price, String category) {
        this.name = (name == null || name.isBlank()) ? "Unknown" : name;
        this.price = price;
        this.category = (category == null || category.isBlank()) ? "General" : category;
    }

    // Clean, human-friendly line
    @Override
    public String toString() {
        return "Name: " + name + " Price: " + price + " Category: " + category;
    }

    // Equality by value (name, price, category)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item other)) return false; // Java 16+ pattern matching
        return this.price == other.price
                && Objects.equals(this.name, other.name)
                && Objects.equals(this.category, other.category);
    }

    // Must align with equals()
    @Override
    public int hashCode() {
        return Objects.hash(name, price, category);
    }
}

