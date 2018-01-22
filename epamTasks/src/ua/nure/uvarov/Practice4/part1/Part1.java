package ua.nure.uvarov.Practice4.part1;

import ua.nure.uvarov.Practice4.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    public static void main(String[] args) {
        System.out.println(new Part1().upperThree(Util.getInput("text.txt")));
    }

    public String upperThree(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("(?mU)(\\w+)(\\W*)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            if (matcher.group(1).length() > 3) {
                stringBuilder.append(matcher.group(1).toUpperCase()).append(matcher.group(2));
            } else {
                stringBuilder.append(matcher.group(1)).append(matcher.group(2));
            }
        }
        return stringBuilder.toString();
    }
}