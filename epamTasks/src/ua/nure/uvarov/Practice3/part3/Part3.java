package ua.nure.uvarov.Practice3.part3;

import ua.nure.uvarov.Practice3.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    public static void main(String[] args) {
        System.out.println(convert6(Util.getInput("text2.txt")));
    }

    public static String convert6(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("(?mu)(\\w+)");
        Matcher matcher = pattern.matcher(input);
        int position = 0;
        while (matcher.find()) {
            stringBuilder.append(matcher.group(1).substring(position, position + 1).toUpperCase());
            stringBuilder.append(matcher.group(1).substring(position + 1, matcher.group(1).length()));
            stringBuilder.append(" ");

        }
        return stringBuilder.toString();
    }
}

