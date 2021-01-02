public class RefactoringRent {
    public static void main(String[] args) {

        RefactoringRent app = new RefactoringRent();

        RefactoringRentalInfo yamamotoInfo = new RefactoringRentalInfo(
                "山本一郎", "aa", "bb", "10", "2000"
            );

        RefactoringRentalInfo yamadaInfo = new RefactoringRentalInfo(
                "山田太郎", "aa", "bb", "80", "2000"
            );

        RefactoringRentalInfo yamaguchiInfo = new RefactoringRentalInfo(
                "山口次郎", "aa", "bb", "15", "500"
            );

        app.doRegistration(yamamotoInfo);
        app.doRegistration(yamadaInfo);
        app.doRegistration(yamaguchiInfo);
    }

    private void doRegistration(RefactoringRentalInfo info) {

        System.out.println("-----");
        System.out.printf(
            "%s さんの登録審査をします. %n", info.name
        );

        if (isValid(info)) {
            info.registerRentalProperty();
        } else {
            System.out.println(
                "賃貸情報を登録できませんでした."
            );
        }

        System.out.println();
    }

    public boolean isValid(RefactoringRentalInfo info) {

        // 沿線未入力チェック
        if (info.wayside == null) {
            System.out.println("沿線が未入力です.");
            return false;
        }
        // 最寄駅未入力チェック
        if (info.nearestStation == null) {
            System.out.println("最寄駅が未入力です.");
            return false;
        }

        // 徒歩（分）未入力チェック
        if (info.onFootMinutes == null) {
            System.out.println("徒歩が未入力です.");
            return false;
        } else if (!isNumeric(info.onFootMinutes)) {
            System.out.println("徒歩には数値を入力してください.");
            return false;
        } else if (!isNumericRange(info.onFootMinutes, 0, 60)) {
            System.out.println(
                "徒歩は0分以上60分以下を入力してください."
            );
            return false;
        }

        // 賃料未入力チェック
        if (info.monthlyRent == null) {
            System.out.println("賃料が未入力です.");
            return false;
        } else if (!isNumeric(info.monthlyRent)) {
            System.out.println("徒歩には数値を入力してください.");
            return false;
        } else if (!isNumericRange(info.monthlyRent, 1000, 200000)) {
            System.out.println(
                "徒歩は1,000円以上200,000円以下を入力してください."
            );
            return false;
        }

        return true;
    }

    public boolean isNumeric(String target) {
        String regexNumeric = "[+-]?\\d*(\\.\\d+)?";
        boolean isNumeric = target.matches(regexNumeric);
        return isNumeric;
    }

    public boolean isNumericRange(
            String target, int from, int to
        ) {

        int intTarget = Integer.parseInt(target);
        return intTarget >= from && intTarget <= to;
    }
}

class RefactoringRentalInfo {
    public String name = "";
    public String wayside = "";
    public String nearestStation = "";
    public String onFootMinutes = "";
    public String monthlyRent = "";

    public RefactoringRentalInfo(
            String name, String wayside, 
            String nearestStation, String onFootMinutes, 
            String monthlyRent
        ) {

        this.name = name;
        this.wayside = wayside;
        this.nearestStation = nearestStation;
        this.onFootMinutes = onFootMinutes;
        this.monthlyRent = monthlyRent;
    }

    public void registerRentalProperty() {
        System.out.println("賃貸情報を登録しました.");
    }

}
