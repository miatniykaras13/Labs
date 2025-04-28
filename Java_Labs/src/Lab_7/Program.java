package Lab_7;
import Lab_7.companies.Company;
import Lab_7.companies.InsuranceCompany;
import Lab_7.companies.Plant;
import Lab_7.companies.ShipbuildingCompany;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Company> companies = new ArrayList<>();
//        int last_id = 0;
        while (true) {
            System.out.println(
                    "Выберете пункт меню:\n" +
                            "0. выход\n" +
                            "1. создать объект\n" +
                            "2. изменить объект\n" +
                            "3. получить информацию по компании\n" +
                            "4. проверить работу компании\n" +
                            ": "
            );
            int choice = scanner.nextInt();
            if (choice == 0)
                break;

            else if(choice == 1)
            {
                System.out.println("Какую компанию вы хотите создать:\n" +
                        "1.Завод. \n" +
                        "2.Судостроительная компания. \n" +
                        "3.Страховая компания. ");
                int comp = scanner.nextInt();
                Company company = null;

                if (comp == 1)
                {
                    Plant plant = new Plant();
                    plant.set(scanner);
                    companies.add(plant);
                    System.out.println("Создан завод с такими данными: " + plant);
                }
                if (comp == 2)
                {
                    ShipbuildingCompany shipbuildingCompany = new ShipbuildingCompany();
                    shipbuildingCompany.set(scanner);
                    companies.add(shipbuildingCompany);
                    System.out.println("Создана судостроительная компания с такими данными: " + shipbuildingCompany);
                }
                if (comp == 3)
                {
                    InsuranceCompany insuranceCompany = new InsuranceCompany();
                    insuranceCompany.set(scanner);
                    companies.add(insuranceCompany);
                    System.out.println("Создана страховая компания с такими данными: " + insuranceCompany);
                }
            }
            else if(choice == 2)
            {
                System.out.println("Введите id компании: ");
                int id = scanner.nextInt();
                System.out.println("Изменение информации о компании с данным id: ");
                if(!(id > companies.size()))
                {
                    companies.get(id - 1).set(scanner);
                }
                else
                {
                    System.out.println("Компания с таким id не найдена.");
                }


            }
            else if(choice == 3)
            {
                System.out.println("Введите id компании: ");
                int id = scanner.nextInt();
                System.out.println("Информация о компании с данным id: ");
                if(!(id > companies.size()))
                {
                    System.out.println(companies.get(id - 1));
                }
                else
                {
                    System.out.println("Компания с таким id не найдена.");
                }
            }
            else if(choice == 4)
            {
                System.out.println("Введите id компании: ");
                int id = scanner.nextInt();
                if(!(id > companies.size()))
                {
                    System.out.println(companies.get(id - 1).work());
                }
                else
                {
                    System.out.println("Компания с таким id не найдена.");
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
