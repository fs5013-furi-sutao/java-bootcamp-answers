import java.util.ArrayList;
import java.util.List;

public class ListPrinter<E> {
    public static void main(String[] args) {

        List<String> dogs = new ArrayList<>();
        dogs.add("Chiwawa");
        dogs.add("Pomeranian");
        dogs.add("Bulldog");
        dogs.add("Akita");
        dogs.add("Poodle");

        ListPrinter<String> printer = new ListPrinter<>();
        printer.printAllElements(dogs);
    }

    public void printAllElements(List<E> list) {
        for (E element : list) {
            System.out.printf(
                "%d => %s %n"
                ,list.indexOf(element), element.toString()
            );
        }
    }
}
