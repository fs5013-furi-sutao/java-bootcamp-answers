public class Initializer {

    private static int staticCounter;
    private int instanceCounter;
    private int id;
    private String name;

    static {
        showStaticInitializerAction();
    }

    {
        incrementStaticCounter();
        incrementInstanceCounter();
        assignId();
    }

    public Initializer(String name) {
        this.name = name;
    }

    private void assignId() {
        this.id = staticCounter;
    }

    private static void incrementStaticCounter() {
        staticCounter++;
    }

    private void incrementInstanceCounter() {
        instanceCounter++;
    }

    private static void showStaticInitializerAction() {
        System.out.println("Static 初期化ブロックが実行されました");
    }

    public void showCounterValue() {
        System.out.format(
                "[id] %d, [name] %s, [staticCounter] %d, [instanceCounter] %d %n",
                this.id, this.name, staticCounter, this.instanceCounter
            );
    }
}