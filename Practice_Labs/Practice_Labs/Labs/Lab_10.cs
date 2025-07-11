using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace Practice_Labs.Labs
{
    public class Lab_10
    {


        public async Task F_1()
        {
            bool timer = false;
            var r = new Random(DateTime.Now.Millisecond);
            int a, b, i = 1, remained;
            var incorrect = new List<(int, int, int)>();
            var testEnds = DateTime.Now.AddSeconds(10);

            Console.WriteLine("Выберите тип теста:" +
                            "\n1.Тест на время." +
                            "\n2.Тест без времени.");
            var choice = int.Parse(Console.ReadLine()!);
            if (choice == 1)
                timer = true;
            else if (choice == 2)
                timer = false;
            else
                throw new Exception("Неправильный выбор.");

            if (timer)
            {
                Console.WriteLine("На тест отведено 60 секунд.");
            }
                
            Console.WriteLine("Тест начался.");

            for(; i <= 10; i++)
            {
                remained = (int)(testEnds - DateTime.Now).TotalSeconds;
                a = r.Next(1, 9);
                b = r.Next(1, 9);
                Console.WriteLine($"{i}. Чему равно произведение {a} * {b}? ");

                var readTask = Task.Run(() => int.Parse(Console.ReadLine()!));
                Task completed;

                if (timer)
                {
                    var delayTask = Task.Delay(remained * 1000);

                    completed = await Task.WhenAny(readTask, delayTask);

                    if (completed == delayTask)
                        break;
                } 
                else
                    completed = readTask;

                remained = (int)(testEnds - DateTime.Now).TotalSeconds;
                if (readTask.Result != a * b)
                    incorrect.Add(new(i, a, b));

                if(timer)
                    Console.WriteLine($"Оставшееся время: {remained} секунд.");
            }
            
            Console.WriteLine("Тест завершен.");
            Console.WriteLine($"\nКоличество нерешенных вопросов: {11 - i}");
            Console.WriteLine($"Количество верных ответов: {i - 1 - incorrect.Count}");
            Console.WriteLine($"Количество неверных ответов: {incorrect.Count}");
            foreach (var f in incorrect)
            {
                Console.WriteLine($"Ошибка допущена в вопросе номер {f.Item1}; {f.Item2} * {f.Item3} = {f.Item2 * f.Item3}");
            }
            Console.WriteLine();

        }
    }
}
