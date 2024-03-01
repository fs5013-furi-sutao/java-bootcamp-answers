import java.util.Scanner;

public class WithoutLogicalOperator {
    public static void main(String[] main) {
        Scanner stdin = new Scanner(System.in);
        
        int openTime = 10;
        int closeTime = 18;

        System.out.print("来店時間を入力：");
        int visitTime = stdin.nextInt();

        if(visitTime >= openTime){
            if(visitTime <= closeTime){
                System.out.println("営業時間中です.");
            }
        }

        if(visitTime < openTime){
            System.out.println("営業時間外です.");
        }

        if(visitTime > closeTime){
            System.out.println("営業時間外です.");
        }
        stdin.close();
    }
}
