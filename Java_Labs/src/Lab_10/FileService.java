package Lab_10;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static final String FILE_NAME = "workers.dat";

    public static void initializeFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_NAME))))
        {
            List<Worker> workers = new ArrayList<>();

            workers.add(new Worker("Виталий", "Слесарь", 3100));
            workers.add(new Worker("Славик", "Сварщик", 4100));
            workers.add(new Worker("Дмитрий", "Начальник", 3200));
            workers.add(new Worker("Владислав", "Инженер", 4000));
            workers.add(new Worker("Федор", "Слесарь", 3500));
            workers.add(new Worker("Владимир", "Дворник", 1100));
            workers.add(new Worker("Виталик", "Слесарь", 5150));

            for(Worker w : workers)
            {
                oos.writeObject(w);
            }
            System.out.println("Файл успешно инициализирован и записано 7 рабочих.");

        }
        catch (IOException e)
        {
            System.err.println("Ошибка при инициализации файла: " + e.getMessage());
        }

    }



    public static void addWorker(Worker worker) {
        try (ObjectOutputStream oos = new CustomObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_NAME, true)))) {

            oos.writeObject(worker);
            System.out.println("Работник успешно добавлен.");

        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public static void showAllWorkers()
    {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FILE_NAME))))
        {

            while (true)
            {
                try
                {
                    Worker worker = (Worker) ois.readObject();
                    System.out.println(worker);
                }
                catch (EOFException | ClassNotFoundException  e)
                {
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    public static void calculateLocksmithSalary()
    {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FILE_NAME))))
        {
            double totalSalary = 0;
            int count = 0;

            while (true) {
                try {
                    Worker worker = (Worker) ois.readObject();
                    if ("Слесарь".equals(worker.getPosition()))
                    {
                        totalSalary += worker.getSalary();
                        count++;
                    }
                } catch (EOFException e) {
                    break;
                }
            }
            System.out.println("Средняя зарплата слесарей: " + (count == 0 ? 0 : totalSalary / count));
            System.out.println("Количество слесарей: " + count);
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.err.println("Ошибка анализа данных: " + e.getMessage());
        }
    }
}
