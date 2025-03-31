package Lab_6;

/*
Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.
*/

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Bicycle bicycle = Bicycle.set(scanner);
        while (true) {
            System.out.println(
                    "Выберете пункт меню:\n" +
                            "0. выход\n" +
                            "1. ехать\n" +
                            "2. тормозить\n" +
                            "3. сломать\n" +
                            "4. накачать колёса\n" +
                            "5. заменить колесо\n" +
                            "6. вывести информацию о велосипеде (марку тоже)\n" +
                            ": "
            );
            int choice = scanner.nextInt();
            if (choice == 0)
                break;

            switch (choice) {
                case 1:
                    bicycle.move();
                    break;
                case 2:
                    bicycle.stop();
                    break;
                case 3:
                    bicycle.destroy();
                    break;
                case 4:
                    System.out.println("Какое колесо накачать(введите номер):");
                    int x = scanner.nextInt();
                    bicycle.pumpWheel(scanner, x);
                    break;
                case 5:
                    System.out.println("Какое колесо заменить(введите номер):");
                    int n = scanner.nextInt();
                    bicycle.changeWheel(scanner, n);
                    break;
                case 6:
                    System.out.println("Информация о велосипеде: " + bicycle.toString());
                    break;
                default:
                    System.out.println("Выбран неправильный пункт меню, повторите ввод.");
            }
        }
        scanner.close();
    }
}