package Lab_6;

import java.util.*;

//класс автомобиль
class Car {
    private Wheel[] wheels; // данные о 4 колесах
    private Engine engine; // данные о двигателе
    private String brand; // марка автомобиля
    private double consumption; // расход топлива
    private double fuelLevel; // текущий уровень топлива

    public Car(String brand, double consumption,
               Engine engine, Wheel wheels[], double fuelLevel) {
        this.brand = brand;
        this.consumption = consumption;
        this.engine = engine;
        this.wheels = wheels;
        this.fuelLevel = fuelLevel;
    }

    public String toString() {
        String string = "";

        string += brand +"; "+ engine.toString() + "; " + consumption + "L/100km { " + fuelLevel + " }; [";
        for (int i = 0; i < 4; ++i) {
            string += wheels[i].toString() + ((i<3)?"; ":"");
        }

        return string + "]";
    }

    public static Car set(Scanner scanner) {
        Car object = new Car("", 0, new Engine(0, 0), new Wheel[4], 0);
        System.out.println("Определим комплектацию автомобиля.");
        System.out.println();

        System.out.print("Введите марку автомобиля: ");
        object.brand = scanner.next();

        System.out.print("Введите расход топлива на 100км: ");
        object.consumption = scanner.nextDouble();

        System.out.print("Введите текущий уровень топлива: ");
        object.fuelLevel = scanner.nextDouble();

        System.out.println("Введите информацию о колесах: ");
        for (int i = 0; i < 4; ++i) {
            System.out.println("колесо #" + (i+1));
            object.wheels[i] = Wheel.set(scanner);
        }

        object.engine = Engine.set(scanner);

        return object;
    }

    public void move() {
        if (fuelLevel <= 0) {
            System.out.println("Нет бензина, машина не может двигаться");
            return;
        }

        for (int i = 1; i < 4; ++i) {
            if (wheels[i].getDiameter() != wheels[i - 1].getDiameter()) {
                System.out.println("Колеса разных диаметров, машина не может двигаться");
                return;
            }
        }

        double distance = fuelLevel / consumption;
        System.out.println("машина проехала " + distance * 100 + "км.");
        fuelLevel = 0;
    }

    public void addFuel(double value) {
        fuelLevel += value;
    }

    public void changeWheel(Scanner scanner) {
        System.out.println("Введите номер колеса [1-4]:");
        int number;
        while (true) {
            number = scanner.nextInt();
            if (number >= 1 && number <= 4)
                break;
            System.out.println("Неправильный номер, повторите ввод");
        }

        wheels[number-1] = Wheel.set(scanner);
    }
}
