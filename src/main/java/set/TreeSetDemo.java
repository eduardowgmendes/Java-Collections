package set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {

        char[] chars = {'V', 'J', 'L', 'E', 'T', 'Q', 'C', 'P'};

        Set<Character> hashSet = new HashSet<>();
        TreeSet<Character> treeSet = new TreeSet<>();

        System.out.print("Contents of chars: ");
        for (char c : chars)
            System.out.print(c + ", ");
        System.out.println();

        for (char c : chars)
            hashSet.add(c);
        System.out.println("Contents of hashSet: " + hashSet);

        for (char c : chars)
            treeSet.add(c);
        System.out.println("Contents of treeSet: " + treeSet);

        System.out.print("Subset of C e P from treeSet: ");
        System.out.println(treeSet.subSet('C', 'P')); // subSet returns a SortedSet<Character>
    }
}
