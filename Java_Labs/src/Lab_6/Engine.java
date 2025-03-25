package Lab_6;

import java.util.*;

// класс двигатель
class Engine {
    private int number; // номер двигателя
    private double power; // мощность двигателя

    public Engine(int number, double power) {
        this.number = number;
        this.power = power;
    }

    public String toString() {
        String string = "engine: " + number + ", power: " + power;
        return string;
    }

    public static Engine set(Scanner scanner) {
        Engine object = new Engine(0, 0);

        System.out.print("Введите цифровой код двигателя: ");
        object.number = scanner.nextInt();

        System.out.print("Введите мощность двигателя: ");
        object.power = scanner.nextDouble();
        return object;
    }
}
