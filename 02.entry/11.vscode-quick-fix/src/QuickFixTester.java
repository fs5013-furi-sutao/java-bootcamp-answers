public class QuickFixTester {
    public static void main(String[] args) {

        rand = new Random();
        myName = "山本一郎";
        boolean isLive = rand.nextBoolean();

        snowMessage(myName, isLive);
    }

    private static void showMessage(String name, boolean isLive) {
        if (isLive) {
            System.out.println("%s は生きてるよ.", name);
        } else {
            System.out.println("%s は死んでるよ.", name);
        }
    }
}
