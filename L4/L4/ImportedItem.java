package L4;

public class ImportedItem extends Item{

    private String country;
    private int dutyPercent;

    public ImportedItem(String name, int price, String category, String country, int dutyPercent) {
        super(name, price, category); // super(...) mandatory (no default parent constructor)
        this.country = country;
        this.dutyPercent = dutyPercent;
    }

    // Extension (not overriding): new behavior added in child
    public void applyDuty() {
        int extra = (getPrice() * dutyPercent) / 100; // uses parent's getter
        addToPrice(extra);                            // uses parent's protected method
    }

    // Inherited member demo: access protected field directly
    public void makeCategoryUpper() {
        category = category.toUpperCase();
    }

    // Child-specific print (not overriding print())
    public void printDetailed() {
        System.out.println(super.info() + " Country: " + country + " Duty: " + dutyPercent);
    }

    // If you try to override parent's final method, it will be compile error:
    // @Override
    // public void print() { } // ❌ not allowed because Item.print() is final

}
