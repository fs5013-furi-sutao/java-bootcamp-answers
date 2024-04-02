package mid.date.manipuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateInitializer {
    
    public static void main(String[] args) {
        // 本日の日付を取得
        LocalDate currentDate = LocalDate.now();

        // 年・月・日を指定して日付を作成
        LocalDate einsteinBirthdate = LocalDate.of(1879, 3, 14);

        // 文字列から日付を作成
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate newtonBirthdate = LocalDate.parse("1642/12/25", formatter);

        System.out.printf("%s : 今日の日付\n", currentDate);
        System.out.printf("%s : アインシュタインの生年月日\n", einsteinBirthdate);
        System.out.printf("%s : ニュートンの生年月日\n", newtonBirthdate);
    }
}
