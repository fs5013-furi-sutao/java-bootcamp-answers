package advanced.abstracts.employee.entity;

public abstract class Employee {

    private String name;
    private int paymentPerHour;

    protected Employee(String name, int paymentPerHour) {
        this.name = name;
        this.paymentPerHour = paymentPerHour;
    }

    public abstract int calculateSalary();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPaymentPerHour(int paymentPerHour) {
        this.paymentPerHour = paymentPerHour;
    }

    public int getPaymentPerHour() {
        return paymentPerHour;
    }
}
