package set.demo;

import java.util.Objects;

public class Month implements Comparable<Month> {

    private String name;
    private int index;

    public Month(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return index == month.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

    @Override
    public int compareTo(Month month) {
        if (this.index < month.index) {
            return -1;
        } else if (this.index > month.index) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%d - %s", index, name);
    }
}
