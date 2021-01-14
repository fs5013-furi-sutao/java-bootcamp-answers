package advanced.enumcon.entity;

public class Rabbit extends Animal {

    public Rabbit(
            String name, Gender gender) {
        
        super(name, gender, Animal.FeedingType.HERBI);
    }

    @Override
    public void bark() {
        System.out.println("みゅー みゅー ........");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("草を食べた ........");
    }
}
