public class Casting {
    public static void main(String[] args) {

        double myDouble = 1.9;
        int downToInt = (int) myDouble;

        System.out.println("ダウンキャスト double -> int");
        System.out.printf("%s -> %s %n%n", myDouble, downToInt);

        float upToFloat = downToInt;
        System.out.println("アップキャスト int -> float");
        System.out.printf("%s -> %s %n%n", downToInt, upToFloat);
    }
}
