package set;

import set.demo.Month;

import java.util.HashSet;
import java.util.Set;

public class HashSetMonthDemo {

    public static void main(String[] args) {

        Set<Month> months = new HashSet<>();

        months.add(new Month("January", 1));
        months.add(new Month("February", 2));
        months.add(new Month("March", 3));
        months.add(new Month("April", 4));

        // Adding the same month to the set. Set doesn't permit duplicates
        months.add(new Month("May", 5)); // If the object doesn't implement equals & hashCode the hashset will fail to check if the set has duplicates

        System.out.println("Contents of months: " + months);

    }
}
