public class WeightPrintMessageBuilder {
    public static void main(String[] args) {

        int weight = 7777;
        String unit = "キロ";
        String message = String.format("ぼくの体重は %d %sです.", weight, unit);

        System.out.println(message);
    }
}
