package Lab_7.companies;

import java.util.Scanner;

public class Plant extends Company
{
    private int _numberOfProducts;
    private int _numberOfWorkers;

    public Plant()
    {
        super();
        _numberOfProducts = 0;
        _numberOfWorkers = 0;
        this.setId(Company.getNumberOfCompanies());
    }
    public Plant(String name, int income)
    {
        super(name, income);
        _numberOfProducts = 0;
        _numberOfWorkers = 0;
        this.setId(Company.getNumberOfCompanies());
    }
    public Plant(String name, int income, int numberOfProducts, int numberOfWorkers)
    {
        super(name, income);
        _numberOfProducts = numberOfProducts;
        _numberOfWorkers = numberOfWorkers;
        this.setId(Company.getNumberOfCompanies());
    }

    public int getNumberOfProducts() {
        return _numberOfProducts;
    }
    public void setNumberOfProducts(int numberOfProducts){
        if (numberOfProducts < 0)
        {
            System.out.println("Количество продукции не должно быть меньше 0.");
            return;
        }
        _numberOfProducts = numberOfProducts;
    }
    public int getNumberOfWorkers() {
        return _numberOfWorkers;
    }
    public void setNumberOfWorkers(int numberOfWorkers){
        if (numberOfWorkers < 0)
        {
            System.out.println("Количество рабочих не должно быть меньше 0.");
            return;
        }
        _numberOfWorkers = numberOfWorkers;
    }
    public static Plant update(Scanner scanner, Plant plant){
        System.out.println("Введите название завода: ");
        String name = scanner.next();
        plant.setName(name);

        System.out.println("Введите доход завода: ");
        int income = scanner.nextInt();
        plant.setIncome(income);

        System.out.println("Введите количество производимых продуктов завода: ");
        int prod = scanner.nextInt();
        plant.setNumberOfProducts(prod);

        System.out.println("Введите количество рабочих на заводе: ");
        int workers = scanner.nextInt();
        plant.setNumberOfWorkers(workers);

        return plant;
    }

    public static Plant set(Scanner scanner){
        Plant plant = new Plant();

        System.out.println("Введите название завода: ");
        String name = scanner.next();
        plant.setName(name);

        System.out.println("Введите доход завода: ");
        int income = scanner.nextInt();
        plant.setIncome(income);

        System.out.println("Введите количество производимых продуктов завода: ");
        int prod = scanner.nextInt();
        plant.setNumberOfProducts(prod);

        System.out.println("Введите количество рабочих на заводе: ");
        int workers = scanner.nextInt();
        plant.setNumberOfWorkers(workers);

        return plant;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        if (!this.equals(o)) return false;
        Plant plant = (Plant) o;
        return _numberOfProducts == plant._numberOfProducts && _numberOfWorkers == plant._numberOfWorkers;
    }

    @Override
    public String toString() {
        return "Завод {" +
                "Id = "  + this.getId() +
                ", Название = '" + this.getName() + '\'' +
                ", Доход = " + this.getIncome() +
                ", Количество продукции = " + _numberOfProducts +
                ", Количество рабочих = " + _numberOfWorkers +
                '}';
    }
}
