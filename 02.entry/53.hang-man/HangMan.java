import java.util.Random;
import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        String[] words = {
            "APPLE","BOOK","FRIEND","GARDEN","HOUSE",
            "FLOWER","JUMP","LION","MOUSE","ORANGE",
            "PENCIL","QUEEN","RABBIT","SCHOOL","TREE",
            "OCEAN","WATCH","GUITAR","YELLOW","BALL",
            "DESK","FISH","GOAT","LAMP","MONKEY",
            "NOSE","OCTOPUS","SNAKE","TABLE","VIOLIN"
        };

        // 正解をランダムで決定
        int answerIndex = random.nextInt(words.length);
        String answer = words[answerIndex];
        
        char[] splitedAnswer = answer.toCharArray();

        boolean[] guessedLetter = new boolean[splitedAnswer.length];

        for(int i = 0;i < guessedLetter.length;i++) {
            guessedLetter[i] = false;
        }

        boolean isRightAnswer = false;

        System.out.println("英単語を当てよう！");

        while(!isRightAnswer){
            for(int j = 0;j < splitedAnswer.length;j++) {
                if(guessedLetter[j]) {
                    System.out.print(splitedAnswer[j]);
                } else {
                    System.out.print("*");
                }
            }

            System.out.print("\n\n");

            System.out.print("文字を入力：");
            String input = scanner.next();

            if(input.length() != 1) {
                System.out.println("アルファベット小文字1文字で入力してください。");
                continue;
            }

            char inputChar = input.charAt(0);

            for(int j = 0;j < splitedAnswer.length;j++) {
                if(splitedAnswer[j] == inputChar) {
                    guessedLetter[j] = true;
                }
            }

            int rightCount = 0;
            for(int j = 0;j < guessedLetter.length;j++) {
                if(guessedLetter[j]) {
                    rightCount++;
                }
            }

            if(rightCount == guessedLetter.length) {
                isRightAnswer = true;
            }
        }
        
        System.out.printf("正解！答えは %s でした。\n", answer);

        scanner.close();
    }
}
