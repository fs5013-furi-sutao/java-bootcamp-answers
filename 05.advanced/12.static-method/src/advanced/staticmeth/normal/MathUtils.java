package advanced.staticmeth.normal;

public class MathUtils {

    private MathUtils() {
        throw new IllegalStateException(
                "ユーティリティクラスをインスタンス化しないでください."
            );
      }

    public static long addLong(long i, long j) {
        return i + j;
    }

    public static int addInts(int i, int... intArgs) {
        
        int sum = i;
        for (int element : intArgs) {
            sum += element;
        }
        return sum;
    }
}
