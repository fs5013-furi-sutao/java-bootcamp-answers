import java.util.Scanner;

public class UntilTargetNumberLooper {
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        final int TARGET_NUM = 77;
        
        String inputtedStrNumber = null;
        int parsedNumber = 0; 
        int count = 0;

        System.out.printf(
            "%d が入力されたら終了します. %n%n"
            , TARGET_NUM
        );

        while (parsedNumber != TARGET_NUM) {
            
            System.out.printf(
                "%d 回目: 数字を入力してください: "
                , ++count    
            );

            inputtedStrNumber = stdin.nextLine();

            try {
                parsedNumber = Integer.parseInt(inputtedStrNumber);
            } catch (NumberFormatException e) {
                System.out.printf(
                    "  => 数字以外の値（ %s ）が入力されました. %n%n"
                    , inputtedStrNumber
                );
            }
        }

        System.out.printf(
            "%n  => %d が入力されたので終了しました. %n"
            , TARGET_NUM
        );
        stdin.close();
    }
}
