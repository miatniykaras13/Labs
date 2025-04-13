using Practice_Labs.Labs;
namespace Practice_Labs
{
    class Program
    {
        static void Main(string[] args)
        {
            int n;
            while (true)
            {
                try
                {
                    Console.ForegroundColor = ConsoleColor.White;
                    Console.WriteLine("Введите номер лабораторной(-1 для выхода): ");
                    n = Convert.ToInt32(Console.ReadLine());
                    if (n == -1)
                    {
                        break;
                    }
                    if (n == 1)
                    {
                        Lab_1 l = new();
                    }
                    if (n == 2)
                    {
                        Lab_2 l = new();
                    }
                    if (n == 3)
                    {
                        Lab_3 l = new();
                        
                    }
                }
                catch (Exception e)
                {
                    Console.ForegroundColor = ConsoleColor.Red;
                    Console.WriteLine($"Ошибка. {e.Message}");
                }
            }
        }
    }
}
