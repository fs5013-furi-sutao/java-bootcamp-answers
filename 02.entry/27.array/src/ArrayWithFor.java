public class ArrayWithFor {
    public static void main(String[] args){
        String[] names = {"山田", "鈴木", "佐藤", "高橋", "山本"};
        int[] ages = {20, 25, 30, 28, 34};
        
        for(int i = 0;i < names.length;i++){
            System.out.printf("%s さんは %d 歳です.\n", names[i], ages[i]);
        }
    }
}