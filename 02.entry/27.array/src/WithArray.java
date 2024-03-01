public class WithArray {
    public static void main(String[] args){
        String[] names = {"山田", "鈴木", "佐藤"};
        int[] ages = {20, 25, 30};
        
        System.out.printf("%s さんは %d 歳です.\n", names[0], ages[0]);
        System.out.printf("%s さんは %d 歳です.\n", names[1], ages[1]);
        System.out.printf("%s さんは %d 歳です.\n", names[2], ages[2]);
    }
}