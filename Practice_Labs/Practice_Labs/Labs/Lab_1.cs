using System;
using System.Collections.Generic;
using System.Linq;
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
            int p = (a + b + c) / 2;
            double s = Math.Sqrt(p * (p - a) * (p - b) * (p - c));
            Console.WriteLine($"Периметр треугольника равен: {p * 2}");
            Console.WriteLine($"Площадь треугольника равна: {s}");
            Console.WriteLine($"Длины высот треугольника равны: {2*s/a}, {2 * s / b}, {2 * s / c}");
            Console.WriteLine($"Углы треугольника равны:" +
                $" {Math.Acos(Math.Cos((b * b + c * c - a * a) / (2 * b * c)))}," +
                $" {Math.Acos(Math.Cos((-b * b + c * c + a * a) / (2 * a * c)))}," +
                $" {Math.Acos(Math.Cos((b * b - c * c + a * a) / (2 * b * a)))}"
                );


        }
        public void F_2()
        {
            
        }
        public void F_3()
        {
            
        }
    }
}
