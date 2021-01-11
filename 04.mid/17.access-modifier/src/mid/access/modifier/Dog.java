package mid.access.modifier;

class Dog {
    
    String name;
    int age;
    String dogType;

    Dog(String name, int age, String dogType) {

        this.name = name;
        this.age = age;
        this.dogType = dogType;
    }

    void showDetails() {
        System.out.format("%s の %s は %d 歳です. %n",
                this.dogType, 
                this.name, 
                this.age
            );
    }
}
