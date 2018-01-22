package ua.nure.uvarov.Practice6.part5;

import java.util.ArrayList;
import java.util.Collections;

public class Tree<E extends Comparable<E>> {
  /*  private static final String INDENT = "   ";
    private Node<E> root = null;
    private ArrayList<Node<E>> list = new ArrayList<Node<E>>();

    public boolean remove(E element) {
        Node<E> cache = findRoot(element, root);
       if(cache.number != element){
           return false;
       }else {

       }
return false;
    }

    private int[] partTree(Node<E> root){

        if (root.right != null) {
            list.add(root.right);
           partTree(root.right);
        }
        if (root.left != null) {
            list.add(root.left);
            partTree(root.left);
        }
        //Collections.sort(list);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = (int)list.get(i).number;
        }
        return arr;
    }


    private Node<E> findRoot(E element, Node<E> root) {
        if (element.compareTo(root.number) > 0) {
            findRoot(element, root.left);
        }
        if (element.compareTo(root.number) < 0) {
            findRoot(element, root.right);
        }
        return root;
    }


    public boolean add(E e) {
        if (root == null) {
            root = new Node<>(e);
            return true;
        }
        Node<E> cache = root;
        while (true) {
            if (e.equals(root.number)) {
                return false;
            }
            if (e.compareTo(root.number) < 0) {
                if (root.right == null) {
                    root.right = new Node<>(e);
                    root = cache;
                    return true;
                } else {
                    root = root.right;
                }
            } else {
                if (root.left == null) {
                    root.left = new Node<>(e);
                    root = cache;
                    return true;
                } else {
                    root = root.left;
                }
            }
        }

    }

    public void add(E[] elements) {
        for (E el : elements) {
            add(el);
        }
    }


    public void print() {
        if (root.right != null) {
            printTree(root.right);
        }
        System.out.println(root.number);
        if (root.left != null) {
            printTree(root.left);
        }
    }

    private void printTree(Node root) {
        if (root.right != null) {
            System.out.print(INDENT);
            printTree(root.right);
        }
        System.out.println(INDENT + root.number);
        if (root.left != null) {
            System.out.print(INDENT);
            printTree(root.left);
        }
    }


    private static class Node<E> {
        private E number;
        private Node<E> right;
        private Node<E> left;

        Node(E number) {
            this.number = number;
        }
    }*/

}
