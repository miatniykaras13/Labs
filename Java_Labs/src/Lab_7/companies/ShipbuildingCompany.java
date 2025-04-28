package Lab_7.companies;

import java.util.Objects;
import java.util.Scanner;

public class ShipbuildingCompany extends Company
{
    private int _capacity;
    private String _country;

    public ShipbuildingCompany() {
        super();
    }


    public int getCapacity() {
        return _capacity;
    }

    public void setCapacity(int capacity){
        if(capacity < 0)
        {
            System.out.println("Вместимость не может быть меньше 0. Установлено значение 0.");
            return;
        }
        _capacity = capacity;
    }

    public String getCountry() {
        return _country;
    }

    public void setCountry(String _country) {
        this._country = _country;
    }

    @Override
    public String work()
    {
        return "Судостроительная компания компания";
    }
    public void set(Scanner scanner){

        super.set(scanner);

        System.out.println("Введите страну судостроительной компании: ");
        String country = scanner.next();
        this.setCountry(country);

        System.out.println("Введите вместимость: ");
        int capacity = scanner.nextInt();
        this.setCapacity(capacity);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShipbuildingCompany that = (ShipbuildingCompany) o;
        return _capacity == that._capacity && Objects.equals(_country, that._country);
    }

    @Override
    public String toString() {
        return "Судостроительная компания{" +
                super.toString() +
                ", Вместимость = " + _capacity +
                ", Страна производства = " + _country +
                '}';
    }
}
