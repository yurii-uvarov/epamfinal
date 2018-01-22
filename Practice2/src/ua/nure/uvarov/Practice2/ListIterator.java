package ua.nure.uvarov.Practice2;

interface ListIterator extends java.util.Iterator<Object> {
    boolean hasPrevious();
    Object previous();
    void set (Object e);
    void remove();
}
