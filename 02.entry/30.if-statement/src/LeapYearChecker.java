public class LeapYearChecker {
    public static void main(String[] args) {

        int[] targetYears = {
                -45, 356, 1700, 2300, 2596,
        };

        for (int year : targetYears) {

            boolean isLeap = isLeapYear(year);
            System.out.printf("西暦 %4d 年は、うるう年か？ => %b %n", year, isLeap);
        }

    }

    private static boolean isLeapYear(int year) {

        if (year % 4 == 0) {

            if (year % 100 == 0) {

                if (year % 400 == 0) return true;
                
                return false;
            }

            return  true;
        }

        return false;
    }

}
