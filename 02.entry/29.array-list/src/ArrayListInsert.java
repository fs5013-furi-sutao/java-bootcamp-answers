import java.util.List;
import java.util.ArrayList;

public class ArrayListInsert {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();

        list.add(10);
        list.add(25);
        list.add(40);
        
        System.out.println("挿入前の出力");
        System.out.println(list);
        
        list.add(2, 50);
        
        System.out.println("挿入後の出力");
        System.out.println(list);
    }
}
