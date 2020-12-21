public class StringCutOut {
    public static void main(String[] args) {

        final int START_INDEX = 2;
        final int END_INDEX = 6;

        String targetString = "investment";

        String resultString = targetString.substring(START_INDEX, END_INDEX);
        System.out.println(resultString);
    }
}
