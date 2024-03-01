import java.util.List;
import java.util.ArrayList;

public class ArrayListSearch {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();

        list.add(10);
        list.add(25);
        list.add(40);
        list.add(20);
        list.add(25);

        System.out.printf("25が最初に一致したのは %d 番目の要素 \n", list.indexOf(25));
        System.out.printf("25が最後に一致したのは %d 番目の要素 \n", list.lastIndexOf(25));
    }
}
