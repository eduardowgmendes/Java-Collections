package set;

import set.demo.Month;

import java.util.TreeSet;

public class TreeSetMonthDemo {

    public static void main(String[] args) {
        TreeSet<Month> months = new TreeSet<>();

        months.add(new Month("December", 12));
        months.add(new Month("September", 9));
        months.add(new Month("January", 1));
        months.add(new Month("August", 8));
        months.add(new Month("May", 5));

        // If the custom object class doesn't implement Comparable interface the TreeSet will fail at runtime with a ClassCastException
        System.out.println("Contents of months: " + months); // class Month cannot be cast to class java.lang.Comparable

        // The TreeSet can be build with a custom comparator that's implement java.util.Comparator
        TreeSet<Month> monthsReversed = new TreeSet<>(new ReverseComparator());// ReverseComparator that's replace the natural order of the months by reverse order
        monthsReversed.add(new Month("December", 12));
        monthsReversed.add(new Month("September", 9));
        monthsReversed.add(new Month("January", 1));
        monthsReversed.add(new Month("August", 8));
        monthsReversed.add(new Month("May", 5));

        System.out.println("Contents of months: " + monthsReversed);

    }
}
