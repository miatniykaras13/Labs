using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;


namespace Practice_Labs.Labs
{
    class Lab_1
    {
        public Lab_1()
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
            if (n == 3)
            {
                F_3();
            }

        }
        public void F_1()
        {
            int a, b, c;
            Console.WriteLine("Введите длины трёх сторон треугольника через пробел: ");

            List<double> sides = Console.ReadLine().Split().Select(s => Convert.ToDouble(s)).ToList();
            
            for (int i = 0; i < sides.Count(); i++)
            {
                if (sides[i] <= 0 || sides[i] % 1 > 0)
                {
                    throw new Exception();
                }
            }

            List<int> l = sides.Select(s => Convert.ToInt32(s)).ToList();

            a = l[0];
            b = l[1];
            c = l[2];

            if(!isTriangle())
                throw new Exception();

            double p = (a + b + c) / 2;
            double s = Math.Sqrt(p * (p - (double)a) * (p - (double)b) * (p - (double)c));

            Console.WriteLine($"\nПериметр треугольника равен: {p * 2}");
            Console.WriteLine($"\nПлощадь треугольника равна: {s}");
            Console.WriteLine($"\nДлины высот треугольника равны: {2*s/a}; {2 * s / b}; {2 * s / c}");
            Console.WriteLine($"\nДлины биссектрис треугольника равны: " +
                $"{Math.Sqrt((double)(b * c) * (1.0 - (double)(a * a) / (double)(Math.Pow(b + c, 2)))):F2}; " +
                $"{Math.Sqrt((double)(a * c) * (1.0 - (double)(b * b) / (double)(Math.Pow(a + c, 2)))):F2}; " +
                $"{Math.Sqrt((double)(b * a) * (1.0 - (double)(c * c) / (double)(Math.Pow(b + a, 2)))):F2}");

            Console.WriteLine($"\nУглы треугольника равны:" +
                $" {Math.Acos((double)(b * b + c * c - a * a) / (double)(2 * b * c)) * (180 / Math.PI):F3};" +
                $" {Math.Acos((double)(-b * b + c * c + a * a) / (double)(2 * a * c)) * (180 / Math.PI):F3};" +
                $" {Math.Acos((double)(b * b - c * c + a * a) / (double)(2 * b * a)) * (180 / Math.PI):F3}\n"
                );

            bool isTriangle()
            {
                return a + b > c && a + c > b && b + c > a;
            }


        }
        public void F_2()
        {
            Console.WriteLine();
            for (int i = 1; i < 6; i++)
            {
                for (int j = i; j < 6; j++)
                {
                    Console.Write(1 + " ");
                }
                Console.WriteLine();
            }
        }
        public void F_3()
        {
            
        }
    }
}
