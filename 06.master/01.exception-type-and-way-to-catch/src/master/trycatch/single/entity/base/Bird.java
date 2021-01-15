package master.trycatch.single.entity.base;

import master.trycatch.single.entity.Pigeon;

public abstract class Bird {

    private String name;

    protected Bird(String name) {
        this.name = name;
    }

    public boolean isEmptyName() {
        return this.name.equals("");
    }

    public void fly() {
        System.out.format(
                "%s が飛んだ. %n", this.name);
    }

    public static Pigeon convertToPigeon(Bird bird) {
        return (Pigeon) bird;
    }
}
