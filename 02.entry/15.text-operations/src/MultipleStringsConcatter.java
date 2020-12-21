public class MultipleStringsConcatter {
    public static void main(String[] args) {

        final String HALF_WIDTH_SPACE = " ";

        StringBuilder sb = new StringBuilder();
        String familyName = "山本";
        String firstName = "一郎";

        sb.append(familyName);
        sb.append(HALF_WIDTH_SPACE);
        sb.append(firstName);
        
        System.out.println(sb);
    }
}
