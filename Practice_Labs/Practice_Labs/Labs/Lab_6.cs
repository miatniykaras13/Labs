using System;
using System.Collections.Generic;
using System.Linq;

namespace Practice_Labs.Labs
{
    public static class ListExtensions
    {
        public static IEnumerable<Employee> DeleteById(this IEnumerable<Employee> employees, int id)
        {
            return employees.Where((e, index) => index != id);
        }
    }

    public record Employee(string Surname, string Adress);

    public class Lab_6
    {
        private readonly List<string> _surnamesPattern = new() { "Кузин", "Куравлев", "Кудин", "Кульков", "Кубиков" };
        private readonly List<string> _surnames = new() { "Видук", "Шмигеро", "Курьян", "Аплевич", "Орлюк" };
        private readonly List<string> _cities = new() { "Гродно", "Волковыск", "Путришки", "Обухово", "Минск" };

        private List<Employee> _employees;
        private List<Employee> _filteredEmployees;

        public Lab_6()
        {
            InitializeEmployees();
            UpdateFiltered();
            MenuLoop();
        }

        private void InitializeEmployees()
        {
            var random = new Random(DateTime.Now.Millisecond);
            var allSurnames = _surnames.Concat(_surnamesPattern).ToList();

            _employees = new List<Employee>();
            for (int i = 0; i < 30; i++)
            {
                string surname = allSurnames[random.Next(allSurnames.Count)];
                string city = _cities[random.Next(_cities.Count)];
                _employees.Add(new Employee(surname, city));
            }
        }

        private void MenuLoop()
        {
            while (true)
            {
                Console.WriteLine("\nМеню:");
                Console.WriteLine("1. Добавить работника");
                Console.WriteLine("2. Удалить работника по ID");
                Console.WriteLine("3. Показать исходных работников");
                Console.WriteLine("4. Показать отфильтрованных работников");
                Console.WriteLine("0. Выход");
                Console.Write("Выберите действие: ");

                switch (Console.ReadLine())
                {
                    case "1":
                        AddEmployee();
                        break;
                    case "2":
                        DeleteEmployee();
                        break;
                    case "3":
                        ShowSource();
                        break;
                    case "4":
                        ShowFiltered();
                        break;
                    case "0":
                        return;
                    default:
                        Console.WriteLine("Некорректный выбор. Попробуйте снова.");
                        break;
                }
            }
        }

        private void AddEmployee()
        {
            Console.Write("Введите фамилию: ");
            string surname = Console.ReadLine()?.Trim() ?? "";
            Console.Write("Введите город: ");
            string city = Console.ReadLine()?.Trim() ?? "";

            if (string.IsNullOrWhiteSpace(surname) || string.IsNullOrWhiteSpace(city))
            {
                Console.WriteLine("Фамилия и город не могут быть пустыми.");
                return;
            }

            _employees.Add(new Employee(surname, city));
            UpdateFiltered();
            Console.WriteLine("Работник добавлен.");
        }

        private void DeleteEmployee()
        {
            if (_employees.Count == 0)
            {
                Console.WriteLine("Список работников пуст.");
                return;
            }

            ShowSource();
            Console.Write("Введите ID работника для удаления: ");
            if (!int.TryParse(Console.ReadLine(), out int id) || id < 0 || id >= _employees.Count)
            {
                Console.WriteLine("Некорректный ID.");
                return;
            }
            
            _employees = _employees.DeleteById(id).ToList();
            UpdateFiltered();
            Console.WriteLine("Работник удалён.");
        }

        private void ShowSource()
        {
            Console.WriteLine("\nИсходный список работников:");
            Print(_employees);
        }

        private void ShowFiltered()
        {
            UpdateFiltered();
            Console.WriteLine("\nОтфильтрованный список работников:");
            if (_filteredEmployees.Count == 0)
            {
                Console.WriteLine("Работников с такими фамилиями нет.");
            }
            else
            {
                Print(_filteredEmployees);
            }
        }

        private void UpdateFiltered()
        {
            _filteredEmployees = _employees
                .Where(e => _surnamesPattern.Contains(e.Surname))
                .ToList();
        }

        private void Print(IEnumerable<Employee> list)
        {
            var employees = list.ToList();
            for (int i = 0; i < employees.Count; i++)
            {
                Console.WriteLine($"ID: {i}, фамилия: {employees[i].Surname}, адрес: {employees[i].Adress}");
            }
        }
        
    }
}
