package ua.nure.uvarov.Practice2;

import java.util.Iterator;

public class Demo {

    public static void main(String[] args) {

        MyList list = new MyListImpl();

        list.add("A");
        list.add("A2");
        System.out.println(list);

        list.clear();
        System.out.println(list);

        list.add("A");
        list.add("A2");
        list.add("A3");
        list.remove("A2");
        System.out.println(list);

        for (Object el : list.toArray()) {
            System.out.print(el);
        }
        System.out.println();

        System.out.println(list.size());

        System.out.println(list.contains("B"));

        System.out.println(list.contains("A3"));
        list.add("A2");

        MyList anotherList = new MyListImpl();
        anotherList.add("A");
        anotherList.add("A2");
        System.out.println(list.containsAll(anotherList));

        anotherList.add("B");
        System.out.println(list.containsAll(anotherList));

        list.add("B");
        System.out.println(list.containsAll(anotherList));


        list = new MyListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        it = list.iterator();
        it.next();
        it.next();
        it.remove();
        System.out.println(list);

        System.out.println(it.next());

        it.remove();
        System.out.println(list);

        try {
            it.remove();
        } catch (IllegalStateException ex) {
            System.out.println(ex.getClass());
        }

        list = new MyListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        ListIterator lit = ((ListIterable) list).listIterator();
        while (lit.hasNext()) {
            System.out.print(lit.next() + " ");
        }
        System.out.println();
        while (lit.hasPrevious()) {
            System.out.print(lit.previous() + " ");
        }
        System.out.println();

        list = new MyListImpl();
        lit = ((ListIterable) list).listIterator();

        System.out.println(lit.hasNext());

        System.out.println(lit.hasPrevious());

        list.add("Element");
        System.out.println(lit.next());

        System.out.println(lit.hasNext());

        System.out.println(lit.hasPrevious());
    }
}