package advanced.staticmeth.interf;

public interface MyData {
    
    static boolean isEmpty(String str) {
        return isNull(str) || "".equals(str)   ? true : false;
    }

    static boolean isNull(String str) {
        return str == null ? true : false;
    }

    static void showResultValidate(int id, String str) {
        if (isEmpty(str)) {
            System.out.format(
                    "[%d] 値が設定されていません. %n", id
                );
            return;
        }
        System.out.format(
                    "[%d] 値が設定されています. %n", id
                );
    }
}
