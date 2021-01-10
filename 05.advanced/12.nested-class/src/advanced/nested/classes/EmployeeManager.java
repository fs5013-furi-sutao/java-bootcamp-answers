package advanced.nested.classes;

/**
 * static なインナークラスを呼び出すサンプル
 * @param args
 */
public class EmployeeManager {

    public static void main(String[] args) {

        Employee[] employees = {
                new Employee(
                        "01 名前のみ設定 一郎",
                        "",
                        ""),
                new Employee(
                        "02 メルアドなし 次郎",
                        "",
                        "愛知県名古屋市中区伏見 3-4-5"),
                new Employee(
                        "",
                        "03_john_doe@freestyles.jp",
                        "愛知県名古屋市中区伏見 3-4-5"),
                new Employee(
                        "04 住所なし 四郎",
                        "04_no_address@freestyles.jp",
                        ""),
        };
        
        /**
         * static は、
         * インスタンス化しなくてよいクラスメソッドやクラス変数として使われるが、
         * この static インナークラスの場合はインスタンス化する
         * 
         * インスタンス化しないとコンパイルエラーになる
         */
        Employee.Validator validator = new Employee.Validator();

        for (Employee employee : employees) {
            validator.showValidatedResult(employee);
        }
    }

}