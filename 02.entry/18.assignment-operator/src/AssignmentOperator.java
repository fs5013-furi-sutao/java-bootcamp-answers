public class AssignmentOperator {
    public static void main(String[] args) {

        // 変数宣言 declare variables
        int a = 4;
        int target;

        // 値の代入に「=」を使う assign value using =
        target = a;
        System.out.printf("target = a: %d %n", target);

        // 値の代入に「=+」を使う assign value using +=
        target += a;
        System.out.printf("target += a: %d %n", target);

        // 値の代入に「=*」を使う assign value using *=
        target *= a;
        System.out.printf("target *= a: %d %n", target);
    }
}
