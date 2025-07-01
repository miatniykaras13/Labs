namespace Practice_Labs.Labs;


public static class ListExtensions
{
    public static IEnumerable<Employee> DeleteById(this IEnumerable<Employee> employees, int id)
    {
        for (int i = 0; i < employees.Count(); i++)
        {
            if (i == id)
            {
                employees.ToList().Remove(employees.ElementAt(i));
            }
        }
        return employees;
    }
}

public record Employee(string Surname, string Adress);

public class Lab_6
{
    public Lab_6()
    {
        F_1();
    }
    

    private void Print(List<Employee> employees)
    {
        for (int i = 0; i < employees.Count; i++)
        {
            Console.WriteLine($"ID: {i}, фамилия: {employees[i].Surname}, адрес: {employees[i].Adress}");
        }
    }
    
    

    private void F_1()
    {
        var r = new Random(DateTime.Now.Millisecond);
        
        List<string> surnamesPattern = ["Кузин", "Куравлев", "Кудин", "Кульков", "Кубиков"];
        List<string> surnames = ["Видук", "Шмигеро", "Курьян", "Аплевич", "Орлюк"];
        surnames = surnames.Concat(surnamesPattern).ToList();
        
        List<string> cities = ["Гродно", "Волковыск", "Путришки", "Обухово", "Минск"];
        bool empty = false;
        
        var employees = new List<Employee>();
        for (int i = 0; i < 30; i++)
        {
            employees.Add(new(surnames[r.Next(0, 10)], cities[r.Next(0, 5)]));
        }

        Console.WriteLine("Исходный список работников: ");
        Print(employees);
        
        Console.WriteLine("Полученный список работников: ");
        List<Employee> newEmployees = employees.Where(e=>surnamesPattern.Contains(e.Surname)).ToList();

        if (newEmployees.Count == 0)
        {
            empty = true;
            Console.WriteLine("Работников с такими фамилиями нет");
        }
        else
        {
            Print(newEmployees);
        }
    }
}