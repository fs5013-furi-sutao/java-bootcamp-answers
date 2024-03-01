import java.util.List;
import java.util.ArrayList;

public class ArrayListOutput {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();

        list.add(10);
        list.add(25);
        list.add(40);

        System.out.printf("添え字を指定して要素を出力: %d \n", list.get(1));

        System.out.println("全ての要素を取得");
        System.out.println(list);
    }
}
