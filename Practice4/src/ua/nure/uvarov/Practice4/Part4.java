package ua.nure.uvarov.Practice4;


import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 implements java.lang.Iterable {
    private int pos = 0;

    public static void main(String[] args) {
        Part4 test = new Part4();
        while (test.iterator().hasNext()) {
            System.out.println(test.iterator().next());
        }
    }
    public Iterator iterator() {
        return new MyIteratorImp();
    }
    private class MyIteratorImp implements Iterator {
        Pattern pattern = Pattern.compile("(?mU)([A-Z\u0410-\u042F].*?[.!?](?=\\s|$))");
        StringBuilder input = new StringBuilder(Util.getInput("text5.txt"));
        Matcher matcher = pattern.matcher(input.toString());
        public boolean hasNext() {
            return matcher.find(pos);
        }
        public Object next() {
            if (hasNext()) {
                pos += matcher.group().length();
                return matcher.group();
            } else throw new UnsupportedOperationException();
        }
    }
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

