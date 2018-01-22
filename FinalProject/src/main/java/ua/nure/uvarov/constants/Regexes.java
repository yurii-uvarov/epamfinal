package ua.nure.uvarov.constants;

import java.util.regex.Pattern;

public class Regexes {

    //validates pattern
    public static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z]{2,30}$");
    public static final Pattern PASSWORD = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9]{6,12})$");
    public static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");


}
