import java.util.List;
import java.util.ArrayList;

public class ArrayListOverwrite {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();

        list.add(10);
        list.add(25);
        list.add(40);

        System.out.println("上書き前の出力");
        System.out.println(list);

        list.set(1, 50);

        System.out.println("上書き後の出力");
        System.out.println(list);
    }
}
