interface IScreen {
    public void display();
}

class AnonymousClassWithInterface {
    public void createClass() {

        /* IScreen anonymousObj = new IScreen() {
            public void display() {
                System.out.println("[display()] 匿名クラスです.");
            }
        }; */ 

        // 上記コメントの匿名クラスをラムダ式で書く
        IScreen anonymousObj = () -> System.out.println(
                "[display()] 匿名クラスです."
            );

        anonymousObj.display();
    }
}

class AnonymousClassWithInterfaceDemo {
    public static void main(String[] args) {
        AnonymousClassWithInterface anonymousObj = new AnonymousClassWithInterface();
        anonymousObj.createClass();
    }
}