import java.util.Scanner;

public class SquarePrinter {

    private static Scanner stdin = new Scanner(System.in);
    private static final int MAX_WIDTH = 9;

    public static void main(String[] args) {

        String strCharInput = "";

        while (!isInputOneChar(strCharInput)) {

            strCharInput = inputLine(
                    "一文字入力してください: "
                );

            showNotInputOneChar(strCharInput);
            System.out.println();
        }

        char charToDraw = strCharInput.charAt(0);

        String strWidthInput = "";

        while (!isWidthValid(strWidthInput, MAX_WIDTH)) {
            System.out.printf(
                "幅（1 ～ %d）を入力してください: ",
                MAX_WIDTH
            );
            strWidthInput = inputLine("");

            showNotWidthValid(strWidthInput, MAX_WIDTH);
            System.out.println();
        }

        printSquare(
            charToDraw, Integer.parseInt(strWidthInput)
        );

        stdin.close();
    }

    private static String inputLine(String string) {
        System.out.print(string);
        return stdin.nextLine();
    }

    private static boolean isInputOneChar(String s) {
        return s.length() == 1;
    }

    private static void showNotInputOneChar(String input) {

        if (!isInputOneChar(input)) {
            System.out.println(
                " => 一文字ではありません."
            );
        }
    }

    private static boolean isWidthValid(
            String strWidth, int maxWidth) {

        int intWidth = 0;
        try {
            intWidth = Integer.parseInt(strWidth);
        } catch (NumberFormatException e) {
            return false;
        }
        return intWidth > 0 && intWidth <= maxWidth;
    }

    private static void showNotWidthValid(
                String input, int maxWidth
            ) {

        if (!isWidthValid(input, maxWidth)) {
            System.out.println(" => 値が不正です.");
        }
    }

    static void printSquare(char c, int width) {

        for (int i = 0; i < width; i++) {

            for (int j = 0; j < width; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}