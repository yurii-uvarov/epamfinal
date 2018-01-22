package ua.nure.uvarov.Practice5.part3;

public class Part3 {
    public int x;
    public int y;

    public static void main(String[] args) {
        Part3 test = new Part3();
        Part3 test2 = new Part3();
        for (int i = 0; i < 2; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 10; j++) {

                        {
                            try {
                                System.out.println("x = y - " + (test.x == test.y));
                                test.x++;
                                sleep(10);
                                test.y++;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
            }.start();
        }


        for (int i = 0; i < 2; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        {
                            synchronized ("monitor2") {
                                try {
                                    System.out.println("");
                                    System.out.println("synchronized = y - " + (test2.x == test2.y));
                                    test2.x++;
                                    sleep(10);
                                    test2.y++;
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }.start();
        }
    }
}
