package mid.access.modifier;

public class DogBreeder {
    public static void main(String[] args) {

        Dog[] dogs = {
            new Dog("秋田賢", 7, "秋田犬"),
            new Dog("山本一郎", 1, "プードル"),
            new Dog("山田太朗", 2, "チワワ"),
        };

        for (Dog dog : dogs) {
            dog.showDetails();
        }
    }
}
