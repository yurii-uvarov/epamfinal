package ua.nure.uvarov.Practice2;

import java.util.Arrays;
import java.util.Iterator;

public class MyListImpl implements MyList, ListIterable {
    private Object[] array = new Object[0];
   int count = 0;
   boolean del = true;

    @Override
    public void add(Object e) {
        int count = array.length;
        array = Arrays.copyOf(array, array.length + 1);
        array[count] = e;
    }

    @Override
    public void clear() {
        array = new Object[0];
    }

    @Override
    public boolean remove(Object o) {
        if (o != null) {
            for (int i = 0; i < array.length; i++) {
                if (o.equals(array[i])) {

                    for (int j = i; j < array.length - 1; j++) {
                        array[j] = array[j + 1];
                    }
                    array = Arrays.copyOf(array, array.length - 1);
                    return true;
                }
            }
            return false;
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    for (int j = i; j < array.length - 1; j++) {
                        array[j] = array[j + 1];

                    }
                    array = Arrays.copyOfRange(array, 1, array.length);

                    return true;
                }

            }
            return false;
        }
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean contains(Object o) {
        if (o != null) {
            for (int i = 0; i < array.length; i++) {
                if (o.equals(array[i])) {
                    return true;
                }
            }
            return false;
        } else {
            for (int i = 0; i < array.length; i++) {
                if (null == (array[i])) {
                    return true;
                }
            }
            return false;

        }
    }

    @Override
    public boolean containsAll(MyList c) {
        for (int i = 0; i < c.size(); i++) {
            if (!contains(c.toArray()[i])) {
                return false;
            }
        }


        return true;
    }


    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("[");
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != null) {
                buffer.append(array[i]).append(", ");
            } else {
                buffer.append("null, ");
            }
        }
        if (array.length > 0 && array[array.length - 1] != null) {
            buffer.append(array[array.length - 1]).append("]");
        } else {
            buffer.append("null]");
        }
        return buffer.toString();
    }

    public Iterator<Object> iterator() {

        return new IteratorImpl();
    }


    public ListIterator listIterator() {
        return new ListIteratorImpl();
    }




    private class IteratorImpl implements Iterator<Object> {
        int count = 0;
        boolean del = true;

        // returns true if the iteration has more elements
        public boolean hasNext() {
            return count <= array.length - 1;
        }

        // returns the next element in the iteration
        public Object next() {
            if (hasNext()) {
                del = true;
                return array[count++];

            } else {
                throw new IllegalStateException();
            }
        }

        // removes from the underlying collection the last element
        //returned by this iterator
        public void remove() {
            if (del) {
                for (int i = --count; i < array.length -1; i++) {
                    array[i] = array[i + 1];
                }
                array = Arrays.copyOf(array, array.length - 1);
                del = false;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private class ListIteratorImpl extends IteratorImpl implements ListIterator { ;

        @Override
        public boolean hasPrevious() {
            return count > 0 && count <= array.length;
        }

        @Override
        public Object previous() {
            if (hasPrevious()) {
                del = true;
                return array[--count];

            } else {
                throw new IllegalStateException();
            }
        }

        @Override
        public void set(Object e) {
            array[count] = e;

        }

    }
}



