package ua.nure.uvarov.Practice6.part7;

import java.util.Iterator;

public class Range implements Iterable {
    int n;
    int m;
    boolean reverse;

    public Range(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public Range(int n, int m, boolean reverse) {
        this(n, m);
        this.reverse = reverse;
    }

    @Override
    public Iterator iterator() {

        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Integer> {
        int tempN = n;
        int tempM = m;

        @Override
        public boolean hasNext() {
            if(!reverse){
            return (tempN<=m);}
            else {
                return (tempM >= n);
            }
        }

        @Override
        public Integer next() {
            if(!reverse) {
                return tempN++;
            }
            else return tempM--;
        }
    }
}


