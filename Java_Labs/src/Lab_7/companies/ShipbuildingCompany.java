package Lab_7.companies;

import java.util.Objects;
import java.util.Scanner;

public class ShipbuildingCompany extends Company
{
    private int _capacity;
    private String _country;

    public ShipbuildingCompany() {
        super();
        _capacity = 0;
        _country = "";
        this.setId(Company.getNumberOfCompanies());
    }

    public ShipbuildingCompany(String name, int income) {
        super(name, income);
        this.setId(Company.getNumberOfCompanies());
    }

    public ShipbuildingCompany(String name, int income, int capacity, String country) {
        super(name, income);
        _capacity = capacity;
        this.setId(Company.getNumberOfCompanies());
    }

    public int getCapacity() {
        return _capacity;
    }

    public void setCapacity(int capacity){
        if(capacity < 0)
        {
            System.out.println("Вместимость не может быть меньше 0.");
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

    public static ShipbuildingCompany update(Scanner scanner, ShipbuildingCompany ship){
        System.out.println("Введите название судостроительной компании: ");
        String name = scanner.next();
        ship.setName(name);

        System.out.println("Введите доход судостроительной компании: ");
        int income = scanner.nextInt();
        ship.setIncome(income);

        System.out.println("Введите страну судостроительной компании: ");
        String country = scanner.next();
        ship.setCountry(country);

        System.out.println("Введите вместимость: ");
        int capacity = scanner.nextInt();
        ship.setCapacity(capacity);

        return ship;
    }
    public static ShipbuildingCompany set(Scanner scanner){
        ShipbuildingCompany ship = new ShipbuildingCompany();

        System.out.println("Введите название судостроительной компании: ");
        String name = scanner.next();
        ship.setName(name);

        System.out.println("Введите доход судостроительной компании: ");
        int income = scanner.nextInt();
        ship.setIncome(income);

        System.out.println("Введите страну судостроительной компании: ");
        String country = scanner.next();
        ship.setCountry(country);

        System.out.println("Введите вместимость: ");
        int capacity = scanner.nextInt();
        ship.setCapacity(capacity);

        return ship;
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
                "Id = "  + this.getId() +
                ", Название = '" + this.getName() + '\'' +
                ", Доход = " + this.getIncome() +
                ", Вместимость = " + _capacity +
                ", Страна производства = " + _country +
                '}';
    }
}
