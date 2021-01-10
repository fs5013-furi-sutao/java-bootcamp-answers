package mid.classes.method.forfixing;

public class Counter {
    private static int count;

    static {
        count = 0;
    }

    public Counter() {

        // インスタンス変数は this で呼べない
        ++count;

        System.out.printf(
                "Counter インスタンスが生成されました: count=%d %n",
                this.count
            );
    }

    public static void showCounter() {
        // インスタンス変数は this で呼べない
        System.out.printf("counter=%d %n", count);
    }
}
