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
        var dates = new int[n];
        Console.WriteLine("Введите дни рождения всех школьников(через пробел): ");
        dates = Console.ReadLine().Split().Select(int.Parse).ToArray();
        if (dates.Any(x => x > 31 || x < 1))
        {
            throw new Exception("Дни рождения должны быть больше нуля и меньше 32.");
        }
        
        


    }

    public bool A(int[] dates)
    {
        for (int i = 0; i < dates.Length; i++)
        {
            int sum = 0;
            for (int j = i; j < dates.Length; j++)
            {
                sum += dates[j];
            }

            if (dates[i] == sum)
            {
                return true;
            }
        }
        return false;
    }
    
    public bool B(int[] dates)
    {
        for (int i = 0; i < dates.Length; i++)
        {
            int sum = 0;
            for (int j = 0; j < i; j++)
            {
                sum += dates[j];
            }

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
            if (dates[i] == sum/ dates.Length)
            {
                return true;
            }
        }
        return false;
    }
    public bool D(int[] dates)
    {
        int sum = dates.Sum();
        for (int i = 0; i < dates.Length; i++)
        {
            if (dates[i] == (sum - dates[i]) / dates.Length)
            {
                return true;
            }
        }
        return false;
    }
    public bool E(int[] dates)
    {
        int sum = dates.Sum();
        for (int i = 0; i < dates.Length; i++)
        {
            if (dates[i] == (sum - dates[i]) / dates.Length)
            {
                return true;
            }
        }
        return false;
    }
    

}