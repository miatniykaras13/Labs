package Lab_6;

import java.util.*;

// класс колесо
class Wheel {

    // перечисление определяющее тип резины колес
    public enum Type { Winter, Summer }

    private double diameter; // диаметр колеса
    private String brand; // марка
    private Type type; // тип резины: летняя, зимняя

    public Wheel(String brand, double diameter, Type type) {
        this.brand = brand;
        this.diameter = diameter;
        this.type = type;
    }

    public String toString() {
        String string = "";

        string += brand + "(" + diameter + ") - ";
        if (type == Type.Winter)
            string += "Winter";
        else
            string += "Summer";

        return string;
    }

    public static Wheel set(Scanner scanner) {
        Wheel object = new Wheel("", 0, Type.Winter);

        System.out.print("Введите бренд: ");
        object.brand = scanner.next();

        System.out.print("Введите диаметр: ");
        object.diameter = scanner.nextDouble();

        System.out.print("Введите тип (1) - зимние, (2) - летние: ");
        while (true) {
            int value = scanner.nextInt();
            if (value == 1) {
                object.type = Type.Winter;
                break;
            }
            if (value == 2) {
                object.type = Type.Summer;
                break;
            }
            System.out.print("Введено неправильное значение, повторите ввод.");
        }
        return object;
    }

    public double getDiameter() {
        return diameter;
    }
}
