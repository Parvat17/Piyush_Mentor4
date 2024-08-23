package com.epam.autotasks.collections;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.TreeSet;

class RangedOpsIntegerSet extends AbstractSet<Integer> {
    private TreeSet<Integer> set = new TreeSet<>();

    // Adds a single value to the set
    @Override
    public boolean add(final Integer integer) {
        return set.add(integer);
    }

    // Removes a single value from the set
    @Override
    public boolean remove(final Object o) {
        if (o instanceof Integer) {
            return set.remove(o);
        }
        return false;
    }

    // Adds a range of values to the set (inclusive of from, exclusive of to)
    public boolean add(int fromInclusive, int toExclusive) {
        boolean changed = false;
        for (int i = fromInclusive; i < toExclusive; i++) {
            if (set.add(i)) {
                changed = true;
            }
        }
        return changed;
    }

    // Removes a range of values from the set (inclusive of from, exclusive of to)
    public boolean remove(int fromInclusive, int toExclusive) {
        boolean changed = false;
        for (int i = fromInclusive; i < toExclusive; i++) {
            if (set.remove(i)) {
                changed = true;
            }
        }
        return changed;
    }

    // Returns an iterator to iterate over elements of the set in natural order
    @Override
    public Iterator<Integer> iterator() {
        return set.iterator();
    }

    // Returns the number of current elements in the set
    @Override
    public int size() {
        return set.size();
    }
}
