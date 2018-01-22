package ua.nure.uvarov.Practice6.part1;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Part1 {
    final public static InputStream STDIN = System.in;
    public static void main(String[] args) {
        String data = "asd asdf asd asdf asdf 43 asdsf 43 43 434 stop";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
       WordContainer.main(null);
       System.setIn(STDIN);
    }
}
