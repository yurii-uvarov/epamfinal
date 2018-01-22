package ua.nure.uvarov.Practice5.part1;

public class Part1 {
    private static final int SLEEP_TIME = 500;

    public static void main(String[] args) {

        new Thread() {
            public void run() {
                for (int i = 0; i < 6; i++) {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(SLEEP_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 6; i++) {

                    try {
                        System.out.println(Thread.currentThread().getName());

                        Thread.sleep(SLEEP_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        ).start();
    }
}
