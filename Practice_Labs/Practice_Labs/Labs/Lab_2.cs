using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.AccessControl;
using System.Text;
using System.Threading.Tasks;

namespace Practice_Labs.Labs
{
    class Lab_2
    {
        public Lab_2()
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
        public void F_1()
        {
            int n = 0;
            Console.WriteLine("Введите размерность массива: ");
            n = Convert.ToInt32(Console.ReadLine());
            int[] ar = new int[n];
            Console.WriteLine("Введите элементы массива(через пробел): ");
            ar = Console.ReadLine().Split().Select(c => Convert.ToInt32(c)).ToArray();
            int pos_nums = 0;
            for (int i = 0; i < n; i++)
            {
                if (ar[i] > 0)
                {
                    pos_nums++;
                }
            }
            int[] new_ar = new int[pos_nums];
            int counter = 0;
            for (int i = 0; i < n; i++)
            {
                if (ar[i] > 0)
                {
                    new_ar[counter] = ar[i];
                    counter++;
                }
            }
            Console.WriteLine("Новый массив: ");
            for (int i = 0; i < pos_nums; i++)
            {
                Console.Write($"{new_ar[i]} ");
            }

            Console.WriteLine($"\nРазмер нового массива: {pos_nums}");


        }
        public void F_2()
        {
            Random r = new(DateTime.Now.Millisecond);
            Console.WriteLine("Введите размерность массива: ");
            int n = Convert.ToInt32(Console.ReadLine());
            int[] ar = new int[n];
            for (int i = 0; i < n; i++)
            {
                ar[i] = r.Next();
            }
            Console.WriteLine("Введите левую границу интервала: ");
            int left = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Введите правую границу интервала: ");
            int right = Convert.ToInt32(Console.ReadLine());
            if (left > right)
            {
                throw new Exception();
            }
            int sum = GetSum(ar, left, right);
            Console.WriteLine($"Сумма элементов в интервале [{left}, {right}]: {sum}");

            
              



        }
        public int GetSum(int[] ar, int l, int r)
        {
            int sum = 0;
            for (int i = l; i <= r; i++)
            {
                sum += ar[i];
            }
            return sum;
        }
    }
}
