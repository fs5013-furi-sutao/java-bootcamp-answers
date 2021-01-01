public class LeapYearChecker {
    public static void main(String[] args) {

        int[] targetYears = {
                -45, 356, 1700, 2300, 2596,
        };

        for (int year : targetYears) {

            boolean isLeapYear = isLeapYear(year);

            if (isLeapYear) {
                System.out.printf(
                    "西暦 %4d 年は、うるう年です. %n", year
                );
                
                continue;
            }

            System.out.printf(
                "西暦 %4d 年は、うるう年ではありません. %n", 
                year
            );
        }
    }

    private static boolean isLeapYear(int year) {
        boolean isFourthYear = ( year % 4) == 0;
        boolean isHundredthYear = (year % 100) == 0;
        boolean isFourHundredthYear = (year % 400) == 0;
        return ((isFourthYear && !isHundredthYear) || isFourHundredthYear);
    }
}
