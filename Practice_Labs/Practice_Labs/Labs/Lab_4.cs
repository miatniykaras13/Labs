using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Practice_Labs.Labs;

public class Lab_4
{
    public Lab_4()
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
        Console.Write("Введите размер матрицы n: ");
        int n = int.Parse(Console.ReadLine());
        List<List<double>> matrix = new();

        Console.WriteLine("Введите матрицу(построчно, каждый символ через пробел):");
        for (int i = 0; i < n; i++)
        {
            matrix.Add(Console.ReadLine().Split().Select(e => double.Parse(e)).ToList());
        }

        

        Console.WriteLine("Наибольший элемент в заштрихованной области: " + MaxElement(matrix, n));


    }

    public double MaxElement(List<List<double>> matrix, int n)
    {
        double maxElement = 0;
        int center = n / 2;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (Math.Abs(i - center) + Math.Abs(j - center) <= center)
                {
                    maxElement = Math.Max(maxElement, matrix[i][j]);
                }
            }
        }
        return maxElement;
    }

    public void F_1()
    {
        Random random = new Random();
        int[,] array = new int[12, 12];

        for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < 12; j++)
            {
                array[i, j] = random.Next(0, 100);
            }
        }

        Console.WriteLine("Исходный массив:");
        PrintArray(array);

        int[,] invertedArray = new int[12, 12];
        for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < 12; j++)
            {
                invertedArray[i, j] = (int)Math.Pow(array[i, j], 3);
            }
        }
        Console.WriteLine("Инвертированный массив:");
        PrintArray(invertedArray);
    }

    public void PrintArray(int[,] arr)
    {
        for (int i = 0; i < arr.GetLength(0); i++)
        {
            for (int j = 0; j < arr.GetLength(1); j++)
            {
                Console.Write(arr[i, j] + "\t");
            }
            Console.WriteLine();
        }
        Console.WriteLine();
    }
}



