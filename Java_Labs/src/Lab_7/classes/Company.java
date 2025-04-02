package Lab_7.classes;

import java.util.Objects;

public abstract class Company
{
    private String _name;
    private int _income;
    private static int _id;

    public Company(String name, int income)
    {
        setName(name);
        setIncome(income);
        _id++;
    }

    public Company()
    {
        _name = "";
        _income = 0;
        _id++;
    }

    public void setIncome(int income)
    {
        if(income < 0)
        {
            System.out.println("Invalid income");
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
        return "Компания{" +
                "Название='" + _name + '\'' +
                ", Доход=" + _income +
                '}';
    }
}
