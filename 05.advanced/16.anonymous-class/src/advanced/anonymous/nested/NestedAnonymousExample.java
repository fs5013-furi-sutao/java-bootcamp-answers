package advanced.anonymous.nested;

public class NestedAnonymousExample {

    public static Hello nestedAnonymousObj = new Hello() {

        @Override
        public void sayHello() {
            System.out.println("こんにちはネストした匿名クラス");
        }
    };

    public static void main(String[] args) {

        /* Hello anonymousObj = new Hello() {

            @Override
            public void sayHello() {
                System.out.println("こんにちは匿名クラス");
            }
        }; */

        // 上記コメントの匿名クラスをラムダ式で書く
        Hello anonymousObj = () -> System.out.println("こんにちは匿名クラス");

        anonymousObj.sayHello();
        NestedAnonymousExample.nestedAnonymousObj.sayHello();
    }

}
