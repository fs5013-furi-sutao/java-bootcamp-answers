public class ArrayElementsPrinter {
    public static void main(String[] args) {

        String[] dogTypes = {
            "Chiwawa",
            "Pomeranian",
            "Bulldog",
            "Akita",
            "Poodle",
        };

        for (int i = 1; i <= dogTypes.length; i++) {
            System.out.printf(
                "dogTypes の %d 番目の犬種は %s です. %n"
                , i, dogTypes[i - 1]
            );
        }
    }
}
