import java.util.Random;

public class SurvivorChecker {
    public static void main(String[] args) {

        Random rand = new Random();
        String myName = "山本一郎";
        boolean isLive = rand.nextBoolean();

        if (isLive) {
            System.out.printf("%s は生きてるよ.", myName);
        } else {
            System.out.printf("%s は死んでるよ.", myName);
        }
    }
}
