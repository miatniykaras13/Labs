package Lab_9;


import java.util.*;

public class Main1
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Queue<Worker> workers = new LinkedList<Worker>();
        workers.add(new Worker("Иванов", "Бухгалтерия", 1000));
        workers.add(new Worker("Петров", "IT", 1500));
        workers.add(new Worker("Сидоров", "Бухгалтерия", 1200));
        workers.add(new Worker("Кузнецов", "Маркетинг", 1300));
        workers.add(new Worker("Смирнов", "Бухгалтерия", 1100));
        workers.add(new Worker("Васильев", "Бухгалтерия", 1400));
        workers.add(new Worker("Михайлов", "HR", 1250));
        workers.add(new Worker("Фёдоров", "Бухгалтерия", 1150));
        workers.add(new Worker("Сергеев", "IT", 1600));
        workers.add(new Worker("Николаев", "Бухгалтерия", 1050));
        while (true) {
            System.out.println(
                    "Выберете пункт меню:\n" +
                            "0. выход\n" +
                            "1. вывести список сотрудников\n" +
                            "2. удалить сотрудника\n" +
                            "3. выполнить сортировку\n" +
                            "4. добавить сотрудника в очередь\n" +
                            "5. обновить данные сотрудника\n" +
                            "6. удалить первого в очереди сотрудника\n" +
                            ": "
            );
            int choice = scanner.nextInt();
            if (choice == 0)
                break;

            else if(choice == 1)
            {
                System.out.println("\nСписок сотрудников:");
                if (workers.isEmpty())
                {
                    System.out.println("Список сотрудников пуст.");
                }
                else
                {
                    int count = 0;
                    for (Worker worker : workers)
                    {
                        System.out.println(count + ": " + worker);
                        count++;
                    }
                }
            }
            else if(choice == 2)
            {
                System.out.print("Введите индекс сотрудника для удаления: ");
                int delIndex = scanner.nextInt();
                if (delIndex < 0 || delIndex >= workers.size())
                {
                    System.out.println("Неверный индекс.");
                    break;
                }

                int currentIndex = 0;
                Iterator<Worker> iter = workers.iterator();
                while (iter.hasNext())
                {
                    Worker current = iter.next();
                    if (currentIndex == delIndex)
                    {
                        iter.remove();
                        System.out.println("Сотрудник удален: " + current);
                        break;
                    }
                    currentIndex++;
                }
            }
            else if(choice == 3)
            {
                List<Worker> accountants = new ArrayList<>();
                for (Worker emp : workers) {
                    if (emp.get_department().equalsIgnoreCase("Бухгалтерия")) {
                        accountants.add(emp);
                    }
                }
                if (accountants.isEmpty())
                {
                    System.out.println("В очереди нет сотрудников бухгалтерии.");
                }
                else
                {
                    accountants.sort((e1, e2) -> e1.get_lastName().compareToIgnoreCase(e2.get_lastName()));
                    System.out.println("\nСписок сотрудников бухгалтерии (отсортирован по фамилии):");
                    int count = 0;
                    for (Worker worker : accountants)
                    {
                        System.out.println(count + ": " + worker);
                        count++;
                    }

                    double totalSalary = 0;
                    for (Worker worker : accountants) {
                        totalSalary += worker.get_salary();
                    }
                    System.out.println("Суммарная зарплата сотрудников бухгалтерии: " + totalSalary);
                }
            }
            else if(choice == 4)
            {
                Worker worker = new Worker();
                worker.set(scanner);
                workers.add(worker);
                System.out.println("Сотрудник добавлен: " + worker);
            }
            else if(choice == 5)
            {
                System.out.print("Введите индекс сотрудника для обновления: ");
                int updIndex = scanner.nextInt();
                if (updIndex < 0 || updIndex >= workers.size())
                {
                    System.out.println("Неверный индекс.");
                    break;
                }
                int currentIndex = 0;
                Iterator<Worker> iter = workers.iterator();
                while (iter.hasNext())
                {
                    Worker current = iter.next();
                    if (currentIndex == updIndex)
                    {
                        current.set(scanner);
                        System.out.println("Сотрудник обновлен: " + current);
                        break;
                    }
                    currentIndex++;
                }
            }
            else if(choice == 6)
            {
                if (!workers.isEmpty())
                {
                    workers.remove();
                    System.out.println("Первый сотрудник удален");
                }
                else
                {
                    System.out.println("Очередь пуста");
                }

            }
            else
            {
                System.out.println("выбран неправильный пункт меню, повторите ввод.");
            }
        }

        scanner.close();
    }
}
