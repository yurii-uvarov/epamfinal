package ua.nure.uvarov.Practice5;

import java.util.Scanner;

public class Spam extends Thread {
    private Thread[] threads;

    public Spam(final int[] waitTimeArrIn, final String[] wordsArrIn) {
        threads = new Thread[waitTimeArrIn.length];
        for (int i = 0; i < waitTimeArrIn.length; i++) {
            threads[i] = new MyWorker(waitTimeArrIn[i], wordsArrIn[i]);
        }
    }

    public void run() {
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }

    public void interrupt() {
        for (int i = 0; i < threads.length; i++) {
            threads[i].interrupt();
        }
    }

    public static void main(String[] args) {
        Spam spam = new Spam(new int[]{1000, 2000, 3000}, new String[]{"One", "Two", "Three"});
        spam.start();
        String temp;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            temp = scanner.nextLine();
            System.err.println(temp);
            if (temp.isEmpty()) {
                spam.interrupt();
                System.out.println("Enter pressed");
                break;
            }
        }

    }

    class MyWorker extends Thread {
        private int time;
        private String word;

        MyWorker(int time, String word) {
            this.time = time;
            this.word = word;
        }

        public void run() {
            try {
                while (!isInterrupted()) {
                    System.out.println(word);
                    sleep(time);
                }
            } catch (InterruptedException e) {

            }
        }

    }
}









