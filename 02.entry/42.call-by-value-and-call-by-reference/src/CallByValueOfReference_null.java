class CallByValueOfReference_null {
    public static void main(String[] args) {

        Obj foo = new Obj();
        foo.num = 128;

        deliver(foo);

        System.out.printf(" foo.num => %d %n", foo.num);
    }

    private static void deliver(Obj bar) {
        bar = null;
        System.out.printf(" bar => %d %n", bar);
    }
}