package ua.nure.uvarov.Practice3.part5;

public class Part5 {
    public static void main(String[] args) {
        System.out.println(convert2Arabic("X"));
    }

    public static String convert2Roman(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        int temp;
        for (int i = 0; i < ArabicSimbols.length; i++) {
            temp = number / ArabicSimbols[i];
            for (int j = 0; j < temp; j++) {
                stringBuilder.append(RomanSimbols[i]);
            }
            number -= temp * ArabicSimbols[i];
        }
        return stringBuilder.toString();
    }

    public static int convert2Arabic(String word) {
        StringBuilder stringBuilder = new StringBuilder(word);
        int temp = 0;
        int i = 0;
        if (stringBuilder.length() > 0) {
            while (true) {
                do {
                    if (RomanSimbols[i].length() <= stringBuilder.length()) {
                        if (RomanSimbols[i].equals(stringBuilder.substring(0, RomanSimbols[i].length()))) {
                            temp += ArabicSimbols[i];
                            stringBuilder.delete(0, RomanSimbols[i].length());
                            if (stringBuilder.length() == 0)
                                return temp;
                        } else
                            break;
                    } else
                        break;
                } while (stringBuilder.length() != 0);
                i++;
            }
        }

        return 0;

    }

    private static String[] RomanSimbols =
            {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
                    "IX", "V", "IV", "I"};
    private static int[] ArabicSimbols =
            {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
}

