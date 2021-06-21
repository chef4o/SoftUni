package IteratorsAndComparators.StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int result = p1.name.length() - p2.name.length();
        if (result == 0) {
            result = p1.name.toUpperCase().charAt(0) - p2.name.toUpperCase().charAt(0);
        }
        return  result;
    }
}
