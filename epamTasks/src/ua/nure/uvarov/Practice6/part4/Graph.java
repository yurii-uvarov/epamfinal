package ua.nure.uvarov.Practice6.part4;

import java.util.ArrayList;

public class Graph {
    int[] graph;
    ArrayList<String> edges = new ArrayList<>();

    public Graph(int top) {
        graph = new int[top];
    }

    public boolean addEdge(int top1, int top2) {
        String temp1 = "" + top1 + top2;
        String temp2 = "" + top2 + top1;
        if (edges.contains(temp1) || edges.contains(temp2)) {
            return false;
        } else {
            edges.add(temp1);
            edges.add(temp2);
            return true;
        }
    }

    public boolean removeEdge(int top1, int top2) {
        String temp1 = "" + top1 + top2;
        String temp2 = "" + top2 + top1;
        if (edges.contains(temp1) || edges.contains(temp2)) {
            edges.remove(temp1);
            edges.remove(temp2);
            return true;
        } else return false;
    }
}
