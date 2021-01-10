package mid.overload.method;

public class Calculator {
    public static void main(String[] args) {

        int a = 1;
        int b = 2;

        int[] array = {
                1, 5, 9, 2, 55,
            };

        Adder adder = new Adder();
        adder.showResultAdded(a, b);
        adder.showResultAdded(array);
    }
}
