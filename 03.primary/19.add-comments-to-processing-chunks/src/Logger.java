public class Logger {
    private Logger() {
        throw new IllegalStateException(
                "インスタンス化しないでください."
            );
    }

    public static void log(String message) {
        System.out.println(message);
    }
}
