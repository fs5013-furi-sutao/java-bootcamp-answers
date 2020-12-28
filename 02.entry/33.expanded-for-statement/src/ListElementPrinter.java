import java.util.ArrayList;
import java.util.List;

public class ListElementPrinter {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("000");
        list.add("111");
        list.add("222");

        for (String element : list) {
            System.out.printf(
                "%d 番目の要素 => %s %n"
                , list.indexOf(element), element
            );
        }
    }
}
