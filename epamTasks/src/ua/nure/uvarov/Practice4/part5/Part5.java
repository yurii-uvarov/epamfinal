package ua.nure.uvarov.Practice4.part5;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;


public class Part5 {
    public final static String STOP_COMMAND = "stop";

    public static void main(String[] args) {

        new Part5().l10n();
    }

    public void l10n() {
        Scanner scanner = new Scanner(System.in);
        String word;
        Locale locale;
        ResourceBundle bundle;
        while (true) {
            word = scanner.next();
            if (!STOP_COMMAND.equals(word)) {
                locale = new Locale(scanner.next());
                bundle = ResourceBundle.getBundle("resources", locale);
                System.out.println(bundle.getString(word));
            } else {
                break;
            }
        }
    }
}