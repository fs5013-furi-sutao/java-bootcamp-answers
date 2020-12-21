public class StringConcatter {
    public static void main(String[] args) {

        String familyName = "山本";
        String firstName = "一郎";

        String fullName = familyName.concat(firstName);
        System.out.printf("ぼくのフルネームは %s です.%n", fullName);
    }
}
