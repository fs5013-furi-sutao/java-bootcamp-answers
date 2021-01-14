package advanced.inheritance.entity;

public class Dog extends Animal {

    public void display() {
        System.out.format(
                "[Dog] 名前は %s です. %n", 
                getName()
            );
    }
}
