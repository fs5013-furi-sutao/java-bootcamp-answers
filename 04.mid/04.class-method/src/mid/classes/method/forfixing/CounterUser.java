package mid.classes.method.forfixing;

public class CounterUser {
    
    public static void main(String[] args) {
        
        Counter[] counters = new Counter[5];

        for (Counter counter : counters) {
            counter = new Counter();
        }

        // クラスメソッドは、
        // インスタンスから呼び出すべきではない
        Counter.showCounter();
    }
}
