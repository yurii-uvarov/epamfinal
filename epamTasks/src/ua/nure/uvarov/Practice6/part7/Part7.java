package ua.nure.uvarov.Practice6.part7;

public class Part7 {
	
	public static void main(String[] args) {
		Range range = new Range(3, 10);
		for(Object el: range){
			System.out.print(el + " ");
		}
		System.out.println();
range = new Range(3, 10, true);
		for(Object el: range){
			System.out.print(el + " ");
		}
	}

}
