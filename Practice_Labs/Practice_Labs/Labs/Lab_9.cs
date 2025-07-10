using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Practice_Labs.Labs
{
    public class Lab_9
    {
        public Lab_9()
        {
            Console.WriteLine("Введите номер функции: ");
            int n = Convert.ToInt32(Console.ReadLine());
            if (n == 1)
            {
                F_1();
            }
            else if (n == 2)
            {
                F_2();
            }
        }

        private void F_1()
        {
            var r = new Random(DateTime.Now.Millisecond);

            int a, b, c, d;

            a = r.Next(1, 8);
            b = r.Next(1, 7);
            if(a == 1)
                c = r.Next(1, a + 1);
            else if(a == 8)
                c = r.Next(a - 1, 8);
            else
                c = r.Next(a - 1, a + 1);
            d = b + 1;

            Console.WriteLine($"Начальные координаты белой пешки: ({a}, {b}), конечные: ({c}, {d})");

        }
        private void F_2()
        {
            var r = new Random(DateTime.Now.Millisecond);

            int a, b, c, d;

            a = r.Next(1, 8);
            b = r.Next(2, 8);
            if (a == 1)
                c = r.Next(1, a + 1);
            else if (a == 8)
                c = r.Next(a - 1, 8);
            else
                c = r.Next(a - 1, a + 1);
            d = b - 1;

            Console.WriteLine($"Начальные координаты черной пешки: ({a}, {b}), конечные: ({c}, {d})");
        }
    }
}

// 1 2 3 4 5 6 7 8
//8
//7
//6
//5
//4
//3
//2
//1

