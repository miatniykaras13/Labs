namespace Practice_Labs.Labs;

public class Lab_3
{
    public Lab_3()
    {
        F();
    }

    public void F()
    {
        Console.WriteLine("Введите количество школьников: ");
        var n = Convert.ToInt32(Console.ReadLine());
        if (n < 1)
        {
            throw new Exception("Количество школьников должно быть больше 0.");
        }

        var dates = new int[n];
        Console.WriteLine("Введите дни рождения всех школьников(через пробел): ");
        dates = Console.ReadLine().Split().Select(int.Parse).ToArray();
        if (dates.Any(x => x > 31 || x < 1))
        {
            throw new Exception("Дни рождения должны быть больше нуля и меньше 32.");
        }
        Console.WriteLine($"Среди школьников " + (!A(dates)? "нету школьника" : "есть школьник") + ", удовлетворяющего условию а).");
        Console.WriteLine($"Среди школьников " + (!B(dates)? "нету школьника" : "есть школьник") + ", удовлетворяющего условию б).");
        Console.WriteLine($"Среди школьников " + (!C(dates)? "нету школьника" : "есть школьник") + ", удовлетворяющего условию в).");
        Console.WriteLine($"Среди школьников " + (!D(dates)? "нету школьника" : "есть школьник") + ", удовлетворяющего условию г).");
        Console.WriteLine($"Среди школьников " + (!E(dates)? "нету школьника" : "есть школьник") + ", удовлетворяющего условию д).");
        Console.WriteLine($"Среди школьников " + (!F(dates)? "нету школьника" : "есть школьник") + ", удовлетворяющего условию е).");
        


    }

    public bool A(int[] dates)
    {
        int sum = dates.Sum();
        for (int i = 0; i < dates.Length; i++)
        {
            sum -= dates[i];
            if (dates[i] == sum)
            {
                return true;
            }
        }
        return false;
    }
    
    public bool B(int[] dates)
    {
        int sum = 0;
        for (int i = 1; i < dates.Length; i++)
        {
            sum += dates[i-1];

            if (dates[i] == sum / i)
            {
                return true;
            }
        }
        return false;
    }
    
    public bool C(int[] dates)
    {
        int sum = dates.Sum();
        for (int i = 0; i < dates.Length; i++)
        {
            if ((double)dates[i] == (double)sum / dates.Length)
            {
                return true;
            }
        }
        return false;
    }
    public bool D(int[] dates)
    {
        if (dates.Length < 2)
        {
            return false;
        }

        int sum = dates.Sum();
        for (int i = 0; i < dates.Length; i++)
        {
            if (dates[i] == (sum - dates[i]) / (dates.Length - 1))
            {
                return true;
            }
        }
        return false;
    }
    public bool E(int[] dates)
    {
        if (dates.Length < 3)
        {
            return false;
        }
        for (int i = 1; i < dates.Length - 1; i++)
        {
            if (dates[i] == Nod(dates[i - 1], dates[i + 1]))
            {
                return true;
            }
        }

        return false;
    }
    public bool F(int[] dates)
    {
        if (dates.Length < 3)
        {
            return false;
        }

        for (int i = 2; i < dates.Length; i++)
        {
            if (dates[i] == Nok(dates[i - 1], dates[i - 2]))
            {
                return true;
            }
        }

        return false;
    }

    public int Nod(int a, int b)
    {
        while (b != 0)
        {
            int с = b;
            b = a % b;
            a = с;
        }
        return a;
    }

    public int Nok(int a, int b)
    {
        return a / Nod(a, b) * b;
    }


}