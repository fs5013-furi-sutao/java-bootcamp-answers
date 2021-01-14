package advanced.abstracts.interf;

interface SuperInterface {
    void a();

    void b();

    void c();

    void d();
}

// The abstract class can also be used to provide some implementation of the interface. 
//In such case, the end user may not be forced to override all the methods of the interface.
abstract class AbstractClassImplementsInterface 
        implements SuperInterface {

    public void a() {
        System.out.println("I am a");
    }
}

class ConcreteClass 
        extends AbstractClassImplementsInterface {

    public void b() {
        System.out.println("I am b");
    }

    public void c() {
        System.out.println("I am c");
    }

    public void d() {
        System.out.println("I am d");
    }
}

public class AbstractImplementsInterfaceDemo {
    
    public static void main(String args[]) {

        final SuperInterface concrete = 
            new ConcreteClass();
        
        concrete.a();
        concrete.b();
        concrete.c();
        concrete.d();
    } 
}