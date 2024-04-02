public class NumberPrinter {

    public static void main(String[] args) {

        int[] ages = {15, 17, 20, 25, 30};
        int[] scores = {65, 70, 90, 98, 85};

        System.out.println("配列ages");

        printNumberArray(ages);

        System.out.println();
        System.out.println("配列scores");

        printNumberArray(scores);
    }

    private static void printNumberArray(int[] array) {
        System.out.print("[");
        for(int i = 0;i < array.length;i++) {
            System.out.print(array[i]);
            
            boolean isLastElement = (i == array.length - 1);
            if(!isLastElement) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    } 
}
