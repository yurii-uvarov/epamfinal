package ua.nure.uvarov.Practice6.part3;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    List<Object> park = new ArrayList<>();

    Parking(int places){
        for (int i = 0; i < places; i++) {
            park.add(null);
        }
    }
    public boolean parked(int place, Object car){
        for (int i = 0; i < park.size(); i++) {
            if(car.equals(park.get(i))){
                throw new IllegalStateException();
            }
        }
        for (int i = place -1, count = 0; i < park.size() && count < park.size(); i++, count++) {
           if(park.get(i) == null){
               park.set(i, car);
               return true;
           }
            if(i == park.size() -1){
                i=0;
            }
        }
        return false;
        }
        public boolean release(Object car){
            for (int i = 0; i < park.size(); i++) {
                if(car.equals(park.get(i))){
                    park.set(i, null);
                    return true;
                }
            }
            return false;
        }
        public void println(){
            for (int i = 0; i < park.size(); i++) {
                if(park.get(i) == null){
                    System.out.print("[free] ");
                }
                else {
                    System.out.print("[busy] ");
                }
            }
            System.out.println();
        }
    }


