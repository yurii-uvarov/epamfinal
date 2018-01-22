package ua.nure.uvarov.Practice4.part3;


import ua.nure.uvarov.Practice4.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {


    public static void main(String[] args) {
         Part3 part3 = new Part3();
         part3.determinate(Util.getInput("part3.txt"));
    }
    public void determinate(String input) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Pattern dPattern = Pattern.compile("(?mU)(\\d*\\.\\d+)");
        Pattern iPattern = Pattern.compile("(?mU)(\\d*\\.?\\d+)");
        Pattern sPattern = Pattern.compile("(?mU)([a-zA-Zà-ÿÀ-ß]{2,})");
        Pattern cPattern = Pattern.compile("(?mU)(\\b[a-zA-Zà-ÿÀ-ß]\\b)");
        while (true) {
            try {
                String temp = bufferedReader.readLine();
                if (temp.equals("!stop")) {
                    break;
                }
                if (temp.toUpperCase().equals("DOUBLE")) {
                    Matcher matcher = dPattern.matcher(input);
                    while (matcher.find()) {
                        System.out.println(matcher.group(1) + " ");
                    }
                }
                if (temp.toUpperCase().equals("STRING")) {
                    Matcher matcher = sPattern.matcher(input);
                    while (matcher.find()) {
                        System.out.println(matcher.group(1) + " ");
                    }
                }
                if (temp.toUpperCase().equals("INT")) {
                    HashSet set = new HashSet();
                    Matcher matcherd = dPattern.matcher(input);
                    Matcher matcher = iPattern.matcher(input);
                    while (matcherd.find()) {
                        set.add(matcherd.group());
                    }
                    while (matcher.find()) {
                       if(!set.contains(matcher.group())){
                           System.out.println(matcher.group());
                       }
                       }
                    }

                if (temp.toUpperCase().equals("CHAR")) {
                    Matcher matcher = cPattern.matcher(input);
                    while (matcher.find()) {
                        System.out.println(matcher.group(1) + " ");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
