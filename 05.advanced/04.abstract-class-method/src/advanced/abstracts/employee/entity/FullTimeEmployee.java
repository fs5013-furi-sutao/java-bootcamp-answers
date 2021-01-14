package advanced.abstracts.employee.entity;

public class FullTimeEmployee extends Employee {

    private static final int REGULAR_TIME = 8;

    public FullTimeEmployee(
            String name, int paymentPerHour) {

        super(name, paymentPerHour);
    }

    @Override
    public int calculateSalary() {
        return getPaymentPerHour() * REGULAR_TIME;
    }
}