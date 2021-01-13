class Screen {
    public void display() {
       System.out.println("Inside the Polygon class");
    }
 }

class AnonymousClassWithClass {
    public void createClass() {

        Screen anonymousObj = new Screen() {
            
            @Override
            public void display() {
                System.out.println("[display()] 匿名クラスです.");
            }
        };
        anonymousObj.display();
    }
}

class AnonymousClassWithClassDemo {
    public static void main(String[] args) {
        AnonymousClassWithClass anonymousObj = new AnonymousClassWithClass();
        anonymousObj.createClass();
    }
}