package ua.nure.uvarov.Practice3.part2;



import ua.nure.uvarov.Practice3.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
    public static void main(String[] args) {
        System.out.println(convert5(Util.getInput("text2.txt")));
    }

    public static String convert5(String input) {
        StringBuilder minStringBuilder = new StringBuilder();
        StringBuilder maxStringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("(?mu)([a-zA-Z]+)");
        Matcher matcher = pattern.matcher(input);
        int mintemp = input.length();
        int maxtemp = 0;
        while (matcher.find()) {
            if (matcher.group().length() < mintemp) {
                mintemp = matcher.group().length();
                minStringBuilder.delete(0, minStringBuilder.length());
                minStringBuilder.append("Min: ");
                minStringBuilder.append(matcher.group());

            }
            if (matcher.group().length() == mintemp) {
                if(!minStringBuilder.toString().contains(matcher.group())){
                minStringBuilder.append(", ").append(matcher.group());
            }
            }
            if (matcher.group().length() > maxtemp) {
                maxtemp = matcher.group().length();
                maxStringBuilder.delete(0, maxStringBuilder.length());
                maxStringBuilder.append("Max: ");
                maxStringBuilder.append(matcher.group());

            }
            if (matcher.group().length() == maxtemp) {
                if(!maxStringBuilder.toString().contains(matcher.group())){
                    maxStringBuilder.append(", ").append(matcher.group());
                }}

        }
        minStringBuilder.append(System.lineSeparator());

        return minStringBuilder.append(maxStringBuilder.toString()).toString();
    }
}