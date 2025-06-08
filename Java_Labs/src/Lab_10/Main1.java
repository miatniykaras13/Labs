package Lab_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("\nМеню:");
            System.out.println("1. Инициализировать файл(очистить содержимое и заполнить работниками)");
            System.out.println("2. Показать всех работников");
            System.out.println("3. Добавить работника");
            System.out.println("4. Рассчитать среднюю зарплату слесарей");
            System.out.println("5. Выход");
            System.out.print("Выберите пункт меню: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1 -> FileService.initializeFile();

                case 2 -> FileService.showAllWorkers();
                case 3 -> {
                    System.out.print("Введите имя работника: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите должность: ");
                    String position = scanner.nextLine();
                    System.out.print("Введите зарплату: ");
                    double salary = scanner.nextDouble();
                    Worker worker = new Worker(name, position, salary);
                    FileService.addWorker(worker);
                }
                case 4 -> FileService.calculateLocksmithSalary();
                case 5 ->
                {
                    System.out.println("Выход из программы.");
                    return;
                }
                default -> System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }
}

