package ua.nure.uvarov.Practice5.part2;
import ua.nure.uvarov.Practice5.Spam;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;


public class Part2 {
    public static final InputStream STDIN = System.in;
    public static final String ENCODING = "UTF-8";
    public static void main(String[] args) throws UnsupportedEncodingException {
            System.setIn(new ByteArrayInputStream(System.lineSeparator().getBytes(ENCODING)));
            Spam.main(null);
            System.setIn(STDIN);
    }
}