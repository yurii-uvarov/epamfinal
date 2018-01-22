package ua.nure.uvarov.Practice5.Part4;

public class Part4 {


    public static void main(String[] args) {
        Matrix m = new Matrix(4,100);
        long start1 = System.currentTimeMillis();
        m.searchWithOutThreads();
        long end1 = System.currentTimeMillis();
        long start2 = System.currentTimeMillis();
        m.searchWithThreads();
        long end2 = System.currentTimeMillis();
        System.out.println("Time without Threads: " + (end1 - start1) + System.lineSeparator() + "Time with Threads: " + (end2 - start2));

    }
}

class Matrix {
     int[][] matrix;
     int M;
     int N;

    public Matrix(final int M, final int N) {
        this.M = M;
        this.N = N;
        matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = (int) (Math.random() * 10000);
            }
        }
    }

    public void searchWithThreads() {
        int[] resArr = new int[M];

        Thread[] threads = new Thread[M];
        for (int i = 0; i < M; i++) {
            threads[i] = new MyWorker(matrix[i], i, resArr);
        }
        for (int i = 0; i < M; i++) {
            threads[i].start();

        }
        for (int i = 0; i < M; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int temp = resArr[0];
        for (int i = 0; i < resArr.length - 1; i++) {
            if (resArr[i] > temp) {
                temp = resArr[i];
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(temp);
    }

    public void searchWithOutThreads() {

        int temp = matrix[0][0];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {

                if (temp < matrix[i][j]) {
                    temp = matrix[i][j];

                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        System.out.println(temp);
    }



    class MyWorker extends Thread {
        int[] arr;
        int line;
        int[] resArr;
        int temp;

        private MyWorker(int[] arr, int line, int[] resArr) {
            this.arr = arr;
            this.line = line;
            this.resArr = resArr;
            temp = arr[0];
        }

        public void run() {
            for (int i = 0; i < arr.length - 1; i++) {
                if (temp < arr[i]) {
                    temp = arr[i];
                }
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            resArr[line] = temp;
            for (int i = 0; i < resArr.length; i++) {
            }

        }

    }
}
