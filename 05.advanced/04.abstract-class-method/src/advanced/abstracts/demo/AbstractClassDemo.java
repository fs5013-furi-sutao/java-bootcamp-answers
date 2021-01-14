package advanced.abstracts.demo;

public class AbstractClassDemo {

    public static void main(String[] args) {

        Animal cat = new Cat("ドラネコ");
        cat.eat();
        cat.sound();

        Animal dog = new Dog("ポチ");
        dog.eat();
        dog.sound();
    }
}

abstract class Animal {

    private String name;

    protected Animal(String name) {
        this.name = name;
    }

    // 継承するすべてのクラスが持つ標準のメソッド
    public void eat() {
        System.out.format(
                "%s が食べる .......... %n", this.name
            );
    }

    // 継承するクラスに実装を強制する
    abstract void sound();
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    void sound() {
        System.out.println("にゃあ にゃあ ........");
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    void sound() {
        System.out.println("わん わん ........");
    }
}