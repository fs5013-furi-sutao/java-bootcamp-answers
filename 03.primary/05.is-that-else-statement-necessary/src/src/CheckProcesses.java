public class CheckProcesses {
    public static void main(String[] args) {

        CheckProcesses app = new CheckProcesses();

        boolean isError = false;
        String value = "third";
        app.execute(isError, value);
    }

    public void execute(boolean isError, String value) {
        if (isError) {
            System.out.println("エラーです.");
            return;
        }
        if (!isValid(value)) {
            return;
        }
        
        System.out.println("メイン処理です.");
    }

    private boolean isValid(String value) {
        if (value == null) {
            System.out.println("値が設定されていません.");
            return false;
        }
        if (!value.equals("first")
                && !value.equals("second")) {
                    
            System.out.println("値が不正です.");
            return false;
        }
        return true;
    }
}
