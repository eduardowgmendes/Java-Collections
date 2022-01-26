package set;

import set.demo.Month;

import java.util.Comparator;

public class ReverseComparator implements Comparator<Month> {
    @Override
    public int compare(Month month, Month otherMonth) {
        return -month.compareTo(otherMonth);
    }
}
