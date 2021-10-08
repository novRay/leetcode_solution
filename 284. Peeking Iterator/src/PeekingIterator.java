// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iter;
    private Integer nextNum;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iter = iterator;
        if (iter.hasNext()) nextNum = iter.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextNum;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int ans = nextNum;
        nextNum = iter.hasNext() ? iter.next() : null;
        return ans;
    }

    @Override
    public boolean hasNext() {
        return nextNum != null;
    }
}