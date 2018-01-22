package ua.nure.uvarov.Practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
public class Part2 {
	public static void remove(List list, int k){//в одном варианте использовать геттер, во втором - нет;
		int temp = 0;
		for (int i = 0; i <= list.size(); i++) {
			if(list.size() == 1){
				break;
			}
			if(i == list.size()){i = 0;}
			if(temp == k){
				list.remove(i);
				temp = -1;
			}
			temp++;
		}

	}
	public static void remove2(List list, int k){
		int temp = 0;
		Iterator iterator = list.iterator();
		while (list.size() != 1){

			if(!iterator.hasNext()){
				System.err.println("here");
				 iterator = list.listIterator();
			}
			else {
				iterator.next();
				if(temp == k){
					iterator.remove();
					temp = 0;
				}

			}
			temp++;
		}
	}
	public static void main(String[] args) {
		LinkedList<Object> linked = new LinkedList<>();
		ArrayList<Object> array = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			array.add(i);
			linked.add(i);
		}
		long start = System.currentTimeMillis();
		remove(linked, 4);
		long end = System.currentTimeMillis();
		System.out.println("Linked time: " + (end - start));

		long start2 = System.currentTimeMillis();
		remove(array, 4);
		long end2 = System.currentTimeMillis();
		System.out.println("Array time: " + (end2 - start2));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		long start3 = System.currentTimeMillis();
		remove2(linked, 4);
		long end3 = System.currentTimeMillis();
		System.out.println("Linked time + Iterator: " + (end3 - start3));

		long start4 = System.currentTimeMillis();
		remove2(array, 4);
		long end4 = System.currentTimeMillis();
		System.out.println("Array time + Iterator: " + (end4 - start4));

	}

}
