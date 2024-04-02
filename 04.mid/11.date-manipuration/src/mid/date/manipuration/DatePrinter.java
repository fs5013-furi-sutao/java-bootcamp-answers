package mid.date.manipuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePrinter {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 3, 18);

        System.out.println("〔日付の分割表示〕");
        System.out.printf("年: %s\n", date.getYear());
        System.out.printf("月: %s\n", date.getMonth());
        System.out.printf("月(数値): %s\n", date.getMonth().getValue());
        System.out.printf("日: %s\n", date.getDayOfMonth());
        System.out.printf("曜日: %s\n", date.getDayOfWeek());
        System.out.printf("曜日(数値): %s\n\n", date.getDayOfWeek().getValue());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日(E)");
        String formatedDate = date.format(formatter);

        System.out.println("〔形式を指定して表示〕");
        System.out.println(formatedDate);
    }
}
