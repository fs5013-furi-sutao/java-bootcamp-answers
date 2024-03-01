public class NamePrintMessageBuilder {
    public static void main(String[] args) {

        String name = "山本一郎";
        String message = String.format("ぼくの名前は %s です.", name);
        
        System.out.println(message);
    }
}