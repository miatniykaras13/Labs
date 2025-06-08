package Lab_9;

import java.util.Scanner;

public class Worker
{
    private String _lastName;
    private String _department;
    private double _salary;

    public Worker()
    {

    }

    public Worker(String lastName, String department, double salary)
    {
        set_salary(salary);
        set_lastName(lastName);
        set_department(department);
    }

    public String get_lastName() {
        return _lastName;
    }

    public void set_lastName(String _lastName) {
        this._lastName = _lastName;
    }

    public String get_department() {
        return _department;
    }

    public void set_department(String _department) {
        this._department = _department;
    }

    public double get_salary() {
        return _salary;
    }

    public void set_salary(double _salary) {
        this._salary = _salary;
    }


    public void set(Scanner scanner)
    {
        System.out.println("Введите фамилию: ");
        this.set_lastName(scanner.next());

        System.out.println("Введите отдел: ");
        this.set_department(scanner.next());

        System.out.println("Введите зарплату: ");
        this.set_salary(scanner.nextInt());
    }

    @Override
    public String toString() {
        return "Сотрудник {" +
                "Фамилия = '" + _lastName + '\'' +
                ", Отдел = '" + _department + '\'' +
                ", Зарплата = " + _salary +
                '}';
    }
}
