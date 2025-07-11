using System;
using System.IO;
using System.Text.RegularExpressions;
using System.Numerics;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace Practice_Labs.Labs
{
    public class Lab_8
    {
        public Lab_8()
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
            else if (n == 3)
            {
                F_3();
            }
        }


        private void F_1()
        {
            string path = "C:\\Users\\Admin\\source\\repos\\miatniykaras13\\Labs\\Practice_Labs\\Practice_Labs\\equation.txt";
            if (!File.Exists(path))
            {
                Console.WriteLine("Файл не найден.");
                return;
            }

            string equation = File.ReadAllText(path).Replace(" ", "").Replace("=0", "");
            Console.WriteLine($"Уравнение из файла: {equation} = 0");

            double a = 0, b = 0, c = 0;


            var matchA = Regex.Match(equation, @"([+-]?[\d\.]*)x\^2");
            var matchB = Regex.Match(equation, @"([+-]?[\d\.]*)x(?!\^)");
            string upd = Regex.Replace(equation, @"[+-]?[\d\.]*x\^2", "");
            upd = Regex.Replace(upd, @"[+-]?[\d\.]*x(?!\^)", "");

            var matchC = Regex.Match(upd, @"([+-]?[\d\.]+)");


            a = Parse(matchA.Groups[1].Value, defaultValue: 0);
            b = Parse(matchB.Groups[1].Value, defaultValue: 0);
            c = Parse(matchC.Groups[1].Value, defaultValue: 0);

            Console.WriteLine($"Коэффициенты: a = {a}, b = {b}, c = {c}");

            Solve(a, b, c);
        }
           

        private double Parse(string input, double defaultValue)
        {
            if (string.IsNullOrEmpty(input)) return defaultValue;
            if (input == "+") return 1;
            if (input == "-") return -1;
            return double.Parse(input);
        }

        private void Solve(double a, double b, double c)
        {
            if (a == 0)
            {
                Console.WriteLine("Это не квадратное уравнение.");
                if (b != 0)
                    Console.WriteLine($"Одно решение: x = {-c / b}");
                else
                    Console.WriteLine(c == 0 ? "Бесконечно много решений." : "Решений нет.");
                return;
            }

            double d = b * b - 4 * a * c;

            if (d > 0)
            {
                double x1 = (-b + Math.Sqrt(d)) / (2 * a);
                double x2 = (-b - Math.Sqrt(d)) / (2 * a);
                Console.WriteLine($"Два действительных корня: x1 = {x1}, x2 = {x2}");
            }
            else if (d == 0)
            {
                double x = (-b / (2 * a)) == 0 ? 0 : -b / (2 * a);
                Console.WriteLine($"Один действительный корень: x = {x}");
            }
            else
            {
                Complex sqrtD = Complex.Sqrt(new Complex(d, 0));
                Complex x1 = (-b + sqrtD) / (2 * a);
                Complex x2 = (-b - sqrtD) / (2 * a);
                Console.WriteLine($"Комплексные корни: x1 = {x1.Real} + {x1.Imaginary}i, x2 = {x2.Real} + {x2.Imaginary}i");
            }
        }


        private void F_2()
        {
            var input = "C:\\Users\\Admin\\source\\repos\\miatniykaras13\\Labs\\Practice_Labs\\Practice_Labs\\in.txt";
            var output = "C:\\Users\\Admin\\source\\repos\\miatniykaras13\\Labs\\Practice_Labs\\Practice_Labs\\out.txt";

            if (!File.Exists(input))
            {
                Console.WriteLine($"Файл не найден: {input}");
                return;
            }

            var lines = File.ReadAllLines(input);
            int maxWidth = lines.Max(l => l.Trim().Length);

            var justified = lines.Select(line =>
            {
                var trimmed = line.Trim();
                if (trimmed.Length == 0)
                    return string.Empty;

                var words = trimmed
                    .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

                if (words.Length == 1)
                    return words[0].PadRight(maxWidth);

                int extraSpaces = maxWidth - trimmed.Length;
                int gaps = words.Length - 1;
                int baseSpace = extraSpaces / gaps;
                int remainder = extraSpaces % gaps;

                var result = words[0];
                for (int i = 1; i < words.Length; i++)
                {
                    int spacesToInsert = baseSpace + (i <= remainder ? 1 : 0);
                    result += new string(' ', spacesToInsert + 1)  // +1 — стандартный пробел
                              + words[i];
                }

                return result;
            });

            File.WriteAllLines(output, justified);
            Console.WriteLine("Текст выровнен и записан в файл.");
        }

        private void F_3()
        {
            var input1 = "C:\\Users\\Admin\\source\\repos\\miatniykaras13\\Labs\\Practice_Labs\\Practice_Labs\\in1.txt";
            var input2 = "C:\\Users\\Admin\\source\\repos\\miatniykaras13\\Labs\\Practice_Labs\\Practice_Labs\\in2.txt";
            var output = "C:\\Users\\Admin\\source\\repos\\miatniykaras13\\Labs\\Practice_Labs\\Practice_Labs\\output.txt";

            if (!File.Exists(input1) || !File.Exists(input2))
            {
                Console.WriteLine($"Файл не найден");
                return;
            }

            var text1 = File.ReadAllText(input1);
            var text2 = File.ReadAllText(input2);

            var numsMatches1 = Regex.Matches(text1, @"-?\d+");
            var numsMatches2 = Regex.Matches(text2, @"-?\d+");

            var result = new List<string>();

            AddValues(numsMatches1, result);
            AddValues(numsMatches2, result);

            File.WriteAllText(output, string.Join(" ", result));
        }

        private void AddValues(MatchCollection matchCollection, List<string> list)
        {
            foreach (Match m in matchCollection)
            {
                list.Add(m.Value);
            }
        }

        
    }

}
