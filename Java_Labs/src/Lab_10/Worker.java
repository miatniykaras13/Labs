package Lab_10;

import java.io.Serializable;

public class Worker implements Serializable
{
    private String _name;
    private String _position;
    private double _salary;

    public Worker(String name, String position, double salary)
    {
        setName(name);
        setPosition(position);
        setSalary(salary);
    }

    public String getPosition()
    {
        return _position;
    }

    public double getSalary()
    {
        return _salary;
    }

    public void setName(String _name)
    {
        this._name = _name;
    }

    public void setPosition(String _position)
    {
        this._position = _position;
    }

    public void setSalary(double _salary)
    {
        this._salary = _salary;
    }

    @Override
    public String toString()
    {
        return "Рабочий: {Имя = '" + _name + "', Должность = '" + _position + "', Зарплата=" + _salary + "}";
    }
}

