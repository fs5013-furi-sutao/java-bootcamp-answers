public class AutoBoxing {
    public static void main(String[] args) {

        AutoBoxing app = new AutoBoxing();
        final int PRIMITIVE_INT = 12;

        Integer autoboxing = app.autobox(PRIMITIVE_INT);
        System.out.format(
                "オートボクシング後の値: %d %n", autoboxing
            );

        int unboxing = app.unbox(autoboxing);
        System.out.format(
                "アンボクシング後の値: %d %n", unboxing
            );
    }

    public Integer autobox(int primitiveInt) {
        return primitiveInt;
    }

    private int unbox(Integer wrapperInt) {
        return wrapperInt;
    }
}
