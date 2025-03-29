package Lab_6;

import java.util.*;

class Wheel {


    private double diameter;
    private String brand;
    private int pressure;

    public Wheel(String brand, double diameter, int pressure) {
        this.brand = brand;
        this.diameter = diameter;
        this.pressure = pressure;
    }

    public String toString() {
        String string = "";
        string += brand + "(" + diameter + ") - " + pressure + "bar";
        return string;
    }

    public static Wheel set(Scanner scanner) {
        Wheel object = new Wheel("", 0, 0);

        System.out.print("Введите бренд: ");
        object.brand = scanner.next();

        System.out.print("Введите диаметр: ");
        object.diameter = scanner.nextDouble();

        System.out.print("Введите давление: ");
        object.pressure = scanner.nextInt();

        return object;
    }
//    public void pump(int delta){pressure += delta;}
    public double getDiameter() {
        return diameter;
    }
    public double getPressure() {
        return pressure;
    }
}
