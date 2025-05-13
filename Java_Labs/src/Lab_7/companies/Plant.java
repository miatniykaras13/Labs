package Lab_7.companies;

import java.util.Scanner;

public class Plant extends Company
{
    private int _numberOfProducts;
    private int _numberOfWorkers;

    public Plant()
    {
        super();
    }


    public int getNumberOfProducts() {
        return _numberOfProducts;
    }
    public void setNumberOfProducts(int numberOfProducts){
        if (numberOfProducts < 0)
        {
            System.out.println("Количество продукции не должно быть меньше 0. Установлено значение 0.");
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
            System.out.println("Количество рабочих не должно быть меньше 0. Установлено значение 0.");
            return;
        }
        _numberOfWorkers = numberOfWorkers;
    }

    @Override
    public String work()
    {
        return "Завод работает.";
    }

    public void set(Scanner scanner){

        super.set(scanner);

        System.out.println("Введите количество производимых продуктов завода: ");
        int prod = scanner.nextInt();
        this.setNumberOfProducts(prod);

        System.out.println("Введите количество рабочих на заводе: ");
        int workers = scanner.nextInt();
        this.setNumberOfWorkers(workers);
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
                super.toString() +
                ", Количество продукции = " + _numberOfProducts +
                ", Количество рабочих = " + _numberOfWorkers +
                '}';
    }
}
