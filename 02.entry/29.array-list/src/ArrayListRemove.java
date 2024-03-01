import java.util.List;
import java.util.ArrayList;

public class ArrayListRemove {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();

        list.add(10);
        list.add(25);
        list.add(40);

        System.out.println("削除前の出力");
        System.out.println(list);

        list.remove(1);

        System.out.println("削除後の出力");
        System.out.println(list);
    }
}
