package Lab_7;
import java.util.*;
import Lab_7.classes.*;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


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

                    break;  // выход из case, но остаемся в while
                case 2:


                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:
                    System.out.println("выбран неправильный пункт меню, повторите ввод.");
            }
        }
        scanner.close();

    }
}
