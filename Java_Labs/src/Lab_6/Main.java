package Lab_6;

/*
Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.
*/

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car car = Car.set(scanner);

        while (true) {
            System.out.println(
                    "Выберете пункт меню:\n" +
                            "0. выход\n" +
                            "1. ехать\n" +
                            "2. заправляться\n" +
                            "3. менять колесо\n" +
                            "4. вывести информацию об авто (марку тоже)\n" +
                            ": "
            );
            int choice = scanner.nextInt();
            if (choice == 0)
                break; // выход из while

            switch (choice) {
                case 1:
                    car.move();
                    break;  // выход из case, но остаемся в while
                case 2:
                    System.out.println("Введи количество топлива:");
                    double fuel = scanner.nextDouble();
                    car.addFuel(fuel);
                    break;
                case 3:
                    car.changeWheel(scanner);
                    break;
                case 4:
                    System.out.println(car.toString());
                    break;
                default:
                    System.out.println("выбран неправильный пункт меню, повторите ввод.");
            }
        }
        scanner.close();
    }
}