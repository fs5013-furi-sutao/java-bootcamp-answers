package advanced.enumcon;

import advanced.enumcon.entity.Animal;
import advanced.enumcon.entity.Barkable;
import advanced.enumcon.entity.Cat;
import advanced.enumcon.entity.Rabbit;

public class PetShop {

    public static void main(String[] args) {
        
        Animal[] pets = {
                new Rabbit(
                    "スキウサギ", 
                        Animal.Gender.WOMAN
                    ),

                new Cat(
                    "どらねこ", 
                        Animal.Gender.MAN
                    ),
            };

        for (Animal pet : pets) {
            System.out.println(pet.toString());
            pet.eat();
            pet.bark();
            System.out.println();
        }

        pets[0].changeName("ツキウサギ");
        System.out.println(pets[0].toString());
        pets[0].eat();

        Barkable rabbit = pets[0];
        rabbit.bark();
    }
}
