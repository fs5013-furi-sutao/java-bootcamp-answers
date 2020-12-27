import java.util.Scanner;

public class TestResultNotifier {
    public static void main(String[] args) {

        final int PASS_SCORE_MIN = 70;
        Scanner stdin = new Scanner(System.in);

        System.out.println("100点満点中、何点だったか回答してください. ");
        System.out.print("数学のテストの得点は？: ");
        double mathTestScore = stdin.nextDouble();

        String mathTestResult = (mathTestScore >= PASS_SCORE_MIN) ? "合格" : "不合格";

        System.out.printf("数学のテストは %s です.", mathTestResult);
        stdin.close();
    }
}
