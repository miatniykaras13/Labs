package Lab_7.companies;

import java.util.Objects;
import java.util.Scanner;

public abstract class Company
{
    private String _name;
    private int _income;
    private static int _companies;
    private int _id;



    public Company()
    {
        _companies++;
        setId(_companies);
    }

    public void setIncome(int income)
    {
        if(income < 0)
        {
            System.out.println("Доход не должен быть меньше 0. Установлено значение 0.");
            return;
        }
        this._income = income;
    }

    public void setName(String name)
    {
        this._name = name;
    }

    public String getName()
    {
        return _name;
    }

    public int getIncome()
    {
        return _income;
    }
    public static int getNumberOfCompanies()
    {
        return _companies;
    }
    public void setId(int id)
    {
        this._id = id;
    }
    public int getId()
    {
        return _id;
    }

    public String work()
    {
        return "Компания работает";
    }

    public void set(Scanner scanner)
    {
        System.out.println("Введите название компании: ");
        String name = scanner.next();
        this.setName(name);

        System.out.println("Введите доход компании: ");
        int income = scanner.nextInt();
        this.setIncome(income);
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return _income == company._income && Objects.equals(_name, company._name);
    }

    @Override
    public String toString()
    {
        return "Id = "  + _id +
                ", Название = '" + _name + '\'' +
                ", Доход = " + _income;
    }
}
