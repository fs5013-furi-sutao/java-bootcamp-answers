package master.throwclause;

public class NullPointerDemo {

    public static void main(String args[]) {

        try {
            generateNullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Recaught: " + e);
        }
    }

    static void generateNullPointerDemo() {
        try {
            throw new NullPointerException("demo");
        } catch (NullPointerException e) {
            System.out.println("generateNullPointerDemo の中でキャッチされた");
            throw e;
        }
    }
}
