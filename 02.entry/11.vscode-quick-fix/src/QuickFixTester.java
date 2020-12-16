import java.util.Random;

public class QuickFixTester {
    public static void main(String[] args) {

        Random rand = new Random();
        String myName = "山本一郎";
        boolean isLive = rand.nextBoolean();

        showMessage(myName, isLive);
    }

    private static void showMessage(String name, boolean isLive) {
        if (isLive) {
            System.out.printf("%s は生きてるよ.", name);
        } else {
            System.out.printf("%s は死んでるよ.", name);
        }
    }
}
