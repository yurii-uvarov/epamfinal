package ua.nure.uvarov.Practice6.part6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part6 {

    public static void frequency(String input) {
        Scanner scanner;
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> frequency = new ArrayList<>();
        try {
            scanner = new Scanner(new File(input));
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (words.contains(word)) {
                    frequency.set(words.indexOf(word), frequency.get(words.indexOf(word)) + 1);
                } else {
                    words.add(word);
                    frequency.add(1);
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = i; j < words.size() - 1; j++) {
                    if (frequency.get(i) < frequency.get(j)) {
                        words.add(i, words.get(j));
                        frequency.add(i, frequency.get(j));
                        words.remove(j + 1);
                        frequency.remove(j + 1);
                    }
                }

            }
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (words.get(j).compareTo(words.get(j + 1)) < 0) {
                        words.add(j, words.get(j + 1));
                        frequency.add(j, frequency.get(j + 1));
                        words.remove(j + 2);
                        frequency.remove(j + 2);
                    }
                }
            }
            for (int j = 0; j < 3; j++) {
                System.out.println(words.get(j) + " ==> " + frequency.get(j));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void length(String input) {
        Scanner scanner;
        ArrayList<String> words = new ArrayList<>();
        try {
            scanner = new Scanner(new File(input));
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (!words.contains(word)) {
                    words.add(word);
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = i; j < words.size() - 1; j++) {
                    if (words.get(i).length() < words.get(j).length()) {
                        words.add(i, words.get(j));
                        words.remove(j + 1);
                    }
                }

            }
            for (int j = 0; j < 3; j++) {
                System.out.println(words.get(j) + " ==> " + words.get(j).length());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void duplicate(String input) {
        StringBuilder res = new StringBuilder();
        Scanner scanner;
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> frequency = new ArrayList<>();
        try {
            scanner = new Scanner(new File(input));
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (!words.contains(word)) {
                    words.add(word);
                    frequency.add(1);
                } else {
                    frequency.set(words.indexOf(word), frequency.get(words.indexOf(word)) + 1);
                }
            }
            String[] mas = new String[3];
            for (int i = 0, count = 0; i < words.size() && count < 3; i++) {
                if(frequency.get(i) > 1){
                    mas[count] = words.get(i);
                    count++;
                }
            }
            for (int i = 2; i >= 0; i--) {
                res.append(mas[i]).append(System.lineSeparator());
            }
            System.out.println(res.reverse().toString().toUpperCase());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        if (args[2].equals("--input") || args[2].equals("-i")) {
            String temp = args[3];
            args[3] = args[1];
            args[1] = temp;
        }
        if (args[3].equals("frequency")) {
            frequency(args[1]);
        }
        if (args[3].equals("length")) {
            length(args[1]);
        }
        if (args[3].equals("length")) {
            duplicate(args[1]);
        }

    }

}
