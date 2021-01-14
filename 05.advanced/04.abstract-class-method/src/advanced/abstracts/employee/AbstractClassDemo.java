package advanced.abstracts.employee;

import advanced.abstracts.employee.entity.Contractor;
import advanced.abstracts.employee.entity.Employee;
import advanced.abstracts.employee.entity.FullTimeEmployee;

public class AbstractClassDemo {

    public static void main(String[] args) {

        Employee[] employees = {
                new Contractor("契約社員の山本一郎", 1000, 10),
                new FullTimeEmployee("正社員の山田太郎", 800),
        };

        for (Employee employee : employees) {

            System.out.format(
                    "[%s] 給料: %d 円 %n",
                    employee.getName(),
                    employee.calculateSalary()
                );
        }
    }
}
