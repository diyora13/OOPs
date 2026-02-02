import L10.*;

import java.util.HashSet;
import java.util.Set;

public class Main {
    void main() {
        // ===== 1) Identity vs Equality =====
        Item i1 = new Item("Pen", 10, "Stationery");
        Item i2 = new Item("Pen", 10, "Stationery"); // same values, different object
        Item i3 = new Item("Notebook", 50, "Stationery");

        System.out.println(i1); // Name: Pen Price: 10 Category: Stationery
        System.out.println(i2); // Name: Pen Price: 10 Category: Stationery
        System.out.println(i3); // Name: Notebook Price: 50 Category: Stationery

        // == (identity) should be false for i1/i2
        boolean idSame = (i1 == i2);
        System.out.println("IdentityEqual: " + idSame); // IdentityEqual: false

        // equals (value) should be true for i1/i2 after overriding equals
        boolean eqSame = i1.equals(i2);
        System.out.println("ValueEqual: " + eqSame); // ValueEqual: true

        // equals with null and different type should be false (and safe)
        System.out.println("EqualsNull: " + i1.equals(null)); // EqualsNull: false
        System.out.println("EqualsOtherType: " + i1.equals("Pen")); // EqualsOtherType: false

        // Print again to keep our verification line after interactions
        System.out.println(i1); // Name: Pen Price: 10 Category: Stationery

        // ===== 2) toString() clean output =====
        // (Already verified above; every System.out.println(iX) uses toString.)
        System.out.println(i3); // Name: Notebook Price: 50 Category: Stationery

        // ===== 3) hashCode() contract with HashSet =====
        Set<Item> set = new HashSet<>();
        set.add(i1);
        // After adding i2 (equal by value), set should still contain only one logical item
        set.add(i2);

        // Print contents (order not guaranteed). Expect one "Pen" item due to equals+hashCode pairing.
        for (Item it : set) {
            System.out.println(it); // Name: Pen Price: 10 Category: Stationery
        }

        // Add different item
        set.add(i3);
        for (Item it : set) {
            System.out.println(it); // One "Pen" + one "Notebook" line (2 items total)
        }

        // ===== 4) Why immutability matters (hash collections pitfall) =====
        // Demonstrate with a mutable object that changing fields after adding to a HashSet breaks lookups.
        MutableItem m1 = new MutableItem("Marker", 30, "Stationery");
        MutableItem m2 = new MutableItem("Marker", 30, "Stationery"); // equal by value

        Set<MutableItem> mset = new HashSet<>();
        mset.add(m1);
        mset.add(m2); // should collapse to 1 because equals+hashCode say they are equal initially

        for (MutableItem it : mset) {
            System.out.println(it); // Name: Marker Price: 30 Category: Stationery  (only one line expected)
        }

        // Mutate m1 AFTER it is inside the set — dangerous!
        m1.setName("Highlighter"); // changes fields that drive equals/hashCode

        // Now the set holds an entry with a hash based on old fields; contents look odd
        for (MutableItem it : mset) {
            System.out.println(it);
            // One line will now print: Name: Highlighter Price: 30 Category: Stationery
            // This shows why mutating keys in hash structures is risky.
        }

        // Trying to remove by an equal(“new value”) object will likely fail:
        boolean removed = mset.remove(new MutableItem("Highlighter", 30, "Stationery"));
        System.out.println("RemovedAfterMutation: " + removed); // Often false due to hash mismatch

        // Safer practice: Use IMMUTABLE keys (like Item), not MutableItem, in hash collections.
        // Verify immutable set remains stable:
        System.out.println(i1); // Name: Pen Price: 10 Category: Stationery
        System.out.println(i2); // Name: Pen Price: 10 Category: Stationery
        System.out.println("ImmutableSetSize: " + set.size()); // ImmutableSetSize: 2
    }
}
