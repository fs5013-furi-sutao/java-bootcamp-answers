package advanced.variable;

public class Student {
    
    private static final String COLLEDGE_NAME = "フリスタ大学";
    private static int counterForId;
    public int id;
    public String name;
    public int age;
    
    public Student() {
        incrementId();
        this.id = counterForId;
    }

    public Student name(String name) {
        this.name = name;
        return this;
    }

    public Student age(int age) {
        this.age = age;
        return this;
    }

    private static void incrementId() {
        counterForId++;
    }

    public void showDetails() {
        System.out.format(
                "%s [生徒ID %d] 名前: %s, 年齢: %2d 歳 %n",
                COLLEDGE_NAME, this.id, this.name, this.age
            );
    }
}
