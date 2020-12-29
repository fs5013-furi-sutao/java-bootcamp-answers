public class NumberAdder {
    public static void main(String[] args) {

        int orangeQuantity = 25;
        int appleQuantity = 15;
        System.out.printf("みかん: %d 個 %n", orangeQuantity);
        System.out.printf("りんご: %d 個 %n", appleQuantity);

        NumberAdder adder = new NumberAdder();

        int adderResult = 
            adder.addNumbers(orangeQuantity, appleQuantity);
        
        System.out.printf("合計: %d 個 %n", adderResult);
    }

    public int addNumbers(int a, int b) {
        return a + b;
    }
}
