import java.util.ArrayList;
import java.util.List;

public class ArrayListManager {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        boolean isListEmpty = list.isEmpty();
        System.out.printf("list の要素が空かどうか => %b %n", isListEmpty);

        list.add("000");
        list.add("111");
        list.add("222");

        int listSize = list.size();
        System.out.printf("list の要素数 => %d %n", listSize);

        String keyword = "111";
        boolean hasKeyWord = list.contains(keyword);
        System.out.printf(
            "list の要素に %s があるかどうか => %b %n"
            , keyword, hasKeyWord
        );

        int targetIndex = 2;
        String target = list.get(targetIndex);
        System.out.printf(
            "list の %d 番目にある要素 => %s %n"
            , targetIndex, target
        );

        target = "000";
        targetIndex = list.indexOf(target);
        System.out.printf(
            "list の要素「%s」があるのは => %d 番目 %n%n"
            , target, targetIndex
        );

        list.set(2, "UPDATE");
        list.remove(0);

        for (int i = 0; i < list.size(); i++) {
            System.out.printf(
                "list の %d 番目の要素 => %s %n"
                , i, list.get(i));
        }
    }
}
