package ua.nure.uvarov.Practice3;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    public static void main(String[] args) {

        System.out.println(convert(Util.getInput("text2.txt")));
    }

    public static String convert(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("(?mu)(\\S+)(\\W?)");
        Pattern patternLine = Pattern.compile("(?mu)^(.+)");
        Matcher matcher;
        Matcher matcherLine = patternLine.matcher(input);
        int position = 0;
        while (matcherLine.find()) {
            matcher = pattern.matcher(matcherLine.group());
            while (matcher.find()) {
                stringBuilder.append(matcher.group(1).substring(position, position + 1).toUpperCase());
                stringBuilder.append(matcher.group(1).substring(position + 1, matcher.group(1).length()));
                stringBuilder.append(matcher.group(2));
            }
            stringBuilder.append(System.lineSeparator());

        }
        return stringBuilder.toString();

    }
}

