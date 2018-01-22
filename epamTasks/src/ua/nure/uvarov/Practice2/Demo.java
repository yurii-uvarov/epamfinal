package ua.nure.uvarov.Practice2;

public class Demo {
    public static void main(String[] args) {
        MyList list = new MyListImpl();
        System.out.println("Part 3");
        list = new MyListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //1234
        ListIterator lit = ((ListIterable)list).listiterator();
        while ((lit.hasNext())){
            System.out.print(lit.next() + " ");
        }
        System.out.println();
        //4321
        while (lit.hasPrevious()){
            System.out.print(lit.previous() + " ");
        }
        System.out.println();

        list = new MyListImpl();
        lit = ((ListIterable) list).listiterator();
        //false
        System.out.println(lit.hasNext());
        //false
        System.out.println(lit.hasPrevious());
        //Element
        System.out.println(lit.next());
        //false
        System.out.println(lit.hasNext());
        //true
        System.out.println(lit.hasPrevious());
    }
}

