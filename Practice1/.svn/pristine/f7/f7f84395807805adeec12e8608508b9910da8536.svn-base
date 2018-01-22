package ua.nure.uvarov.Practice1.part5;

public class Part5 {
    public static void main(String[] args) {
        String[] mas = new String[]{"A", "B", "Z", "AA", "AZ", "BA", "ZZ", "AAA"};
        for (String el : mas) {
            System.out.print(el + " ==> ");
            System.out.print(chars2digits(el) + " ==> ");
            System.out.println(digits2chars(chars2digits(el)));
        }
    }
    public static int chars2digits(String letters) {
        int result = 0;
        for (int j = 0, i = letters.length() - 1; j <= letters.length() - 1; j++, i--) {

            result += ((int) Math.pow(26, i) * (letters.charAt(j) - 64));

        }

        return result;
    }
    public static String digits2chars(int number) {
        StringBuilder buffer = new StringBuilder();
        while (number > 0) {
            if (number % 26 == 0) {
                buffer.append('Z');
                number = (number - 26) / 26;
            } else {
                buffer.append((char) (number % 26 + 64));
                number = (number - (number % 26)) / 26;
            }
        }
        return buffer.reverse().toString();
    }
    public static String rightColumn(int number) {
        return digits2chars(number + 1);
    }
}

