using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Practice_Labs.Labs
{
    public class Lab_10
    {
        public Lab_10()
        {
            F_1();
        }

        private void F_1()
        {
            var r = new Random();
            int a, b, i = 1;
            var incorrect = new List<(int, int, int)>();
            var testEnds = DateTime.Now.AddMinutes(1);
            Console.WriteLine("На тест отведено 60 секунд.");
            Console.WriteLine("Тест начался");

            while (DateTime.Now < testEnds )
            {
                a = r.Next(1, 9);
                b = r.Next(1, 9);
                Console.WriteLine($"{i}. Чему равно произведение {a} * {b}?");

                int c = int.Parse(Console.ReadLine()!);
                if (c != a * b)
                    incorrect.Add(new(i, a, b));
                Console.WriteLine($"Оставшееся время: {testEnds.Second + testEnds.Minute * 60 + testEnds.Hour * 3600
                    - (DateTime.Now.Second + DateTime.Now.Minute * 60 + DateTime.Now.Hour * 3600)} секунд.");
                i++;
            }
            
            Console.WriteLine("Тест завершен.");
            Console.WriteLine($"\nКоличество верных ответов: {10 - incorrect.Count}");
            Console.WriteLine($"Количество неверных ответов: {incorrect.Count}");
            foreach (var f in incorrect)
            {
                Console.WriteLine($"Ошибка допущена в вопросе номер {f.Item1}; {f.Item2} * {f.Item3} = {f.Item2 * f.Item3}");
            }

        }
    }
}
