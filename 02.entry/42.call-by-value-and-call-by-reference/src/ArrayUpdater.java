public class ArrayUpdater {

    public static void main(String[] args) {

        int[] data = { 1, 2, 3, 4, 5, };

        ArrayUpdater app = new ArrayUpdater();
        app.updateArray(data);

        for (int element : data) {
            System.out.println(element);
        }
    }

    private void updateArray(int[] data) {

        int[] tmp = new int[data.length];

        for (int i = data.length; i > 0; i--) {
            tmp[data.length - i]  = data[i - 1];
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = tmp[i];
        }
    }
}