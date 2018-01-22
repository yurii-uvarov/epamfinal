package ua.nure.uvarov.Practice3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    public static void main(String[] args) {
        System.out.println(convert1(Util.getInput("text.txt")));
        System.out.println(convert2(Util.getInput("text.txt")));
        System.out.println(convert3(Util.getInput("text.txt")));
        System.out.println(convert4(Util.getInput("text.txt")));
    }
    public static String convert1(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("(.[^;]+)(?:[;])(?:.[^;]+)(?:[;])(.[^\\n]+)");
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find()) {
            if (count == 0) {
                count++;
                continue;
            }
            stringBuilder.append(matcher.group(1));
            stringBuilder.append(" ==> ");
            stringBuilder.append(matcher.group(2));
            stringBuilder.append(System.lineSeparator());
            count++;
        }
        return stringBuilder.toString();
    }
    public static String convert2(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("(?mu)^(.+);(\\S+)\\s(\\S+);(\\w+@\\w+.+)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {


            stringBuilder.append(matcher.group(3));
            stringBuilder.append(" ");
            stringBuilder.append(matcher.group(2));
            stringBuilder.append(" (email: ");
            stringBuilder.append(matcher.group(4));
            stringBuilder.append(")");
            stringBuilder.append(System.lineSeparator());

        }
        return stringBuilder.toString();
    }
    public static String convert3(String input) {
        Pattern pattern = Pattern.compile("(?mu)^(\\S+);.+@(.+)");
        Matcher matcher = pattern.matcher(input);
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
       if(list.contains(matcher.group(2))){
            list.set((list.indexOf(matcher.group(2)) + 1),
                    list.get(list.indexOf(matcher.group(2))+1) + ", " + matcher.group(1));
       }
       else {
           list.add(matcher.group(2));
           list.add(" ==> " + matcher.group(1));
       }
        }
        for (int i = 0; i < list.size(); i++) {
            if(i%2 == 0){
                stringBuilder.append(list.get(i));
            }
            else {
                stringBuilder.append(list.get(i)).append(System.lineSeparator());
            }
        }

        return stringBuilder.toString();
    }
    public static String convert4(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("(?mu)^(.+);(.+);(.+)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            if ((matcher.group().compareTo("Login;Name;Email") == 0)) {
                stringBuilder.append(matcher.group());
                stringBuilder.append(";Password");
                stringBuilder.append(System.lineSeparator());
                continue;
            }
            stringBuilder.append(matcher.group());
            stringBuilder.append(";");
            stringBuilder.append((int)(Math.random()*10));
            stringBuilder.append((int)(Math.random()*10));
            stringBuilder.append((int)(Math.random()*10));
            stringBuilder.append((int)(Math.random()*10));
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
}
}