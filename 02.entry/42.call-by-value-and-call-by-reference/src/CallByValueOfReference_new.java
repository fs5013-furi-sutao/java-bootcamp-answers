class CallByValueOfReference_new {
    public static void main(String[] args) {

        Obj foo = new Obj();
        foo.num = 128;

        deliver(foo);

        System.out.printf(" foo.num => %d %n", foo.num);
    }

    private static void deliver(Obj bar) {
        bar = new Obj();
        bar.num = 256;
        System.out.printf(" bar.num => %d %n", bar.num);
    }
}