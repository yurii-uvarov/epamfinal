package ua.nure.uvarov.Practice6.part3;

public class Part3 {
	
	public static void main(String[] args) {
		Parking parking = new Parking(10);
		Object car = new Object();
		parking.parked(5, new Object());
		parking.parked(10,car);
		parking.println();
		System.out.println();
		parking.release(car);
		parking.println();
		}
	}


