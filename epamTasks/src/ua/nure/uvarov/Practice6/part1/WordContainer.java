package ua.nure.uvarov.Practice6.part1;
import java.util.ArrayList;
import java.util.Scanner;

// you can extend this class from one of the core container
// or aggregate it inside of class 
public class WordContainer {
    ArrayList<Word> list = new ArrayList<>();

    public void add(Word word) {
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (word.equals(list.get(i))) {
                list.get(i).setFrequency(list.get(i).getFrequency() + 1);
                flag = true;
            }
        }
        if (!flag) {
            list.add(word);
        }
    }
    public void sort() {
        Word temp;
        for (int j = list.size() - 1; j > 0; j--) {
            for (int i = list.size() - 1; i > 0; i--) {
                if (list.get(i).compareTo(list.get(i - 1)) > 0) {
                    temp = list.get(i - 1);
                    list.set(i - 1, list.get(i));
                    list.set(i, temp);
                }
                if (list.get(i).compareTo(list.get(i - 1)) == 0) {
                    if (list.get(i).getWord().compareTo(list.get(i - 1).getWord()) < 0) {
                        temp = list.get(i - 1);
                        list.set(i - 1, list.get(i));
                        list.set(i, temp);
                    }
                }
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i).getWord());
            stringBuilder.append(" : ");
            stringBuilder.append(list.get(i).getFrequency());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordContainer container = new WordContainer();
        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        while (scanner.hasNext()) {
            temp = scanner.next();
            if(temp.equals("stop")){break;}
            stringBuilder.append(temp).append(System.lineSeparator());
        }
        String[] string = stringBuilder.toString().split(System.lineSeparator());
        for (int i = 0; i < string.length; i++) {
            container.add(new Word(string[i]));
        }
        container.sort();
        System.out.print(container.toString());
    }
}

