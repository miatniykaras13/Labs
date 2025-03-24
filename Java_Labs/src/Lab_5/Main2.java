package Lab_5;


import java.util.Objects;
import java.util.Scanner;

class DateTime
{
    private int _day;
    private int _month;
    private int _year;

    public DateTime()
    {
        _day = 0;
        _month = 0;
        _year = 0;
    }
    public DateTime(int day, int month, int year)
    {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public void setDay(int day)
    {
        if(day <= 0 || day > 31)
        {
            System.out.println("Invalid day");
            return;
        }
        _day = day;
    }
    public int getDay()
    {
        return _day;
    }


    public void setMonth(int month)
    {
        if(month <= 0 || month > 12)
        {
            System.out.println("Invalid month");
            return;
        }
        _month = month;
    }
    public int getMonth()
    {
        return _month;
    }


    public int getYear()
    {
        return _year;
    }
    public void setYear(int year)
    {
        if(year < 0)
        {
            System.out.println("Invalid year");
        }
        _year = year;
    }

    public boolean isLeapYear()
    {
        return _year % 4 == 0;
    }

    public void increaseDateOnFive()
    {
        if(_day + 5 > 31)
        {
            _day = _day + 5 - 31;
            if(_month + 1 > 12)
            {
                _month = _month + 1 - 12;
                _year++;
            }
            else
            {
                _month++;
            }
        }
        else
        {
            _day += 5;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DateTime dateTime = (DateTime) o;
        return _day == dateTime._day && _month == dateTime._month && _year == dateTime._year;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(_day, _month, _year);
//    }
//    public boolean equals(DateTime d)
//    {
//        return d.getDay() == _day && d.getMonth() == _month && d.getYear() == _year;
//    }

    public String toString()
    {
        return "День: " + getDay() + " Месяц: " + getMonth() + " Год: " + getYear();
    }
}

public class Main2
{
    public static void outputDate(DateTime[] d)
    {
        for(int i = 0; i < d.length; i++)
        {
            System.out.println("dateTimes[" + i + "] = " + d[i].toString());
        }
    }

    public static void main(String[] args)
    {

        DateTime[] dateTimes = new DateTime[4];
        Scanner sc = new Scanner(System.in);
        dateTimes[0] = new DateTime();
        dateTimes[0].setDay(30);
        dateTimes[0].setMonth(12);
        dateTimes[0].setYear(2002);
        dateTimes[1] = new DateTime(30, 12, 2002);
        dateTimes[2] = new DateTime(21, 10, 2010);
        dateTimes[3] = new DateTime(26, 1, 2100);

        System.out.println("Создан массив объектов класса DateTime со следующим содержимым: ");
        outputDate(dateTimes);
        System.out.println("Сколько объектов вы бы хотели изменить?(-1, если не нужно)");
        int choice = sc.nextInt();
        for(int i = 0; i < choice; i++)
        {
            System.out.println("Какой объект вы бы хотели изменить?(-1, если не нужно)");
            int c = sc.nextInt();
            if (c != -1) {
                System.out.println("Введите день объекта: ");
                int day = sc.nextInt();
                dateTimes[c - 1].setDay(day);
                System.out.println("Введите месяц объекта: ");
                int m = sc.nextInt();
                dateTimes[c - 1].setMonth(m);
                System.out.println("Введите год объекта: ");
                int y = sc.nextInt();
                dateTimes[c - 1].setYear(y);
            }
        }
        System.out.println("Содержимое списка после изменения: ");
        outputDate(dateTimes);
        System.out.println("Дни скольких объектов DateTime вы хотите уменьшить на 5?(введите число объектов)");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            System.out.println("Дни какого объекта DateTime вы хотите уменьшить на 5?(введите номер в списке)");
            int m = sc.nextInt();
            System.out.printf("Уменьшение дней объекта dateTimes[%d] на 5.\n", m-1);
            dateTimes[i].increaseDateOnFive();
            System.out.printf("Объект dateTimes[%d] после изменения: ", m-1);
            System.out.print(dateTimes[m-1].toString() + "\n");
        }
        System.out.println("Сколько раз вы хотите сравнивать объекты dateTimes?");
        int m = sc.nextInt();
        for(int i = 0; i < m; i++)
        {
            System.out.println("Какие объекты списка dateTimes вы хотите сравнить?(введите номера в списке)");
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.printf("Объект dateTimes[%d] равен dateTimes[%d]: ", a, b);
            System.out.print(dateTimes[a-1].equals(dateTimes[b-1]) + "\n");
        }
        System.out.println("Год какого объекта dateTimes вы хотите проверить на високосность?");
        int v = sc.nextInt();
        System.out.printf("Год объекта dateTimes[%d] - високосный: ", v-1);
        System.out.print(dateTimes[v-1].isLeapYear());

    }
}
