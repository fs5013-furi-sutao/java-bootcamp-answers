package mid.date.manipuration;

import java.time.LocalDate;

public class DateModifier {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 3, 20);

        System.out.printf("初期状態:%s\n\n", date);

        LocalDate oneDaysLater = date.plusDays(1);
        LocalDate oneWeeksLater = date.plusWeeks(1);
        LocalDate oneMonthsLater = date.plusMonths(1);
        LocalDate oneYearLater = date.plusYears(1);

        System.out.println("未来の日付");
        System.out.printf("1日後の日時  :%s\n", oneDaysLater);
        System.out.printf("1週間後の日時:%s\n", oneWeeksLater);
        System.out.printf("1か月後の日時:%s\n", oneMonthsLater);
        System.out.printf("1年後の日時  :%s\n\n", oneYearLater);

        LocalDate oneDaysEarlier = date.minusDays(1);
        LocalDate oneWeeksEarlier = date.minusWeeks(1);
        LocalDate oneMonthsEarlier = date.minusMonths(1);
        LocalDate oneYearEarlier = date.minusYears(1);

        System.out.println("過去の日付");
        System.out.printf("1日前の日時  :%s\n", oneDaysEarlier);
        System.out.printf("1週間前の日時:%s\n", oneWeeksEarlier);
        System.out.printf("1か月前の日時:%s\n", oneMonthsEarlier);
        System.out.printf("1年前の日時  :%s\n", oneYearEarlier);
    }
}
