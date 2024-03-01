public class IfElseifSample {
    public static void main(String[] args){
        int[] numbers = {10, 50, 5, 9, 15};

        for(int i = 0;i < numbers.length;i++) {
            if(numbers[i] > 10) {
                System.out.printf("%2d は 10 より大きい \n", numbers[i]);
            } else if(numbers[i] < 10) {
                System.out.printf("%2d は 10 より小さい \n", numbers[i]);
            }
        }
    }
}
