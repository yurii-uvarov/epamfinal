package ua.nure.uvarov.Practice4;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
    public static void main(String[] args) {
        Part2 part2 = new Part2();
        part2.addFile("myfile.txt", null);
        System.out.println("input ==> " + Util.getInput("myfile.txt"));
        part2.addFile("myfile2.txt", part2.bubleSort(part2.readFile("myfile.txt")));
        System.out.println("output ==> " + Util.getInput("myfile2.txt"));
    }

    public void addFile(String fileName, int[] buffer) {
        File file = new File(fileName);
        try (FileWriter fw = new FileWriter(file)) {
            file.createNewFile();
            if (buffer == null) {
                for (int i = 0; i < 10; i++) {
                    fw.write(" " + (int) (Math.random() * 50));
                }
            } else {
                for (int i = 0; i < 10; i++) {
                    fw.write(" " + buffer[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] readFile(String fileName) {
        Pattern pattern = Pattern.compile("(?mU)(\\W*)(\\d+)");
        Matcher matcher = pattern.matcher(Util.getInput(fileName));
        int[] array = new int[10];
        int count = 0;
        while (matcher.find()) {
            array[count] = Integer.parseInt(matcher.group(2));
            count++;
        }
        return array;
    }

    public int[] bubleSort(int[] array) {
        int temp;
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < 10 - i; j++) {
                if (array[j] < array[j - 1]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}



