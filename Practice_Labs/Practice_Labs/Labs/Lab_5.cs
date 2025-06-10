using System.Text;

namespace Practice_Labs.Labs
{
    public class Lab_5
    {
        public Lab_5()
        {
            Console.WriteLine("Введите номер функции: ");
            int n = Convert.ToInt32(Console.ReadLine());
            if (n == 1)
            {
                F_1();
            }
            if (n == 2)
            {
                F_2();
            }
        }

        public void F_2()
        {
            Console.WriteLine("Введите символ: ");
            char c = Char.Parse(Console.ReadLine()!);
            Console.WriteLine("Введите строку: ");
            string s = Console.ReadLine()!;
            Console.WriteLine("Введите строку для вставки: ");
            string s0 = Console.ReadLine()!;

            string s2 = string.Empty;
            for (int i = 0; i < s.Length; i++)
            {
                s2 += s[i];
                if (s[i] != c)
                {
                    continue; 
                }
                s2 += s0;
            }
            Console.WriteLine($"Новая строка: \n{s2}");
        }

        public void F_1()
        {
            Console.WriteLine("Введите текст: ");
            string str = Console.ReadLine()!;
            int largest = str.Split().MaxBy(s => s.Length)!.Length;
            int smallest = str.Split().MinBy(s => s.Length)!.Length;
            Console.WriteLine($"Наибольшая длина слова в тексте: {largest}, наименьшая: {smallest}");
        }
    }
}