package Lab_5;



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

    public boolean equals(DateTime d)
    {
        return d.getDay() == _day && d.getMonth() == _month && d.getYear() == _year;
    }

    public String toString()
    {
        return "День: " + getDay() + " Месяц: " + getMonth() + " Год: " + getYear();
    }
}

public class Main2
{
    public static void outputDate(DateTime d, int i)
    {
        System.out.printf("Объект dateTimes[%d]: ", i);
        System.out.println(d.toString() + '\n');
    }

    public static void main(String[] args)
    {

        DateTime[] dateTimes = new DateTime[4];
        dateTimes[0] = new DateTime();
        dateTimes[0].setDay(30);
        dateTimes[0].setMonth(12);
        dateTimes[0].setYear(2002);
        dateTimes[1] = new DateTime(30, 12, 2002);
        dateTimes[2] = new DateTime(21, 10, 2010);
        dateTimes[3] = new DateTime(26, 1, 2100);

        for(int i=0; i<dateTimes.length; i++)
        {
            outputDate(dateTimes[i], i);
        }

        System.out.println("Объект dateTimes[0] равен dateTimes[1]: " + dateTimes[0].equals(dateTimes[1]));
        dateTimes[0].increaseDateOnFive();
        System.out.println("Объект dateTime[0] после увеличения числа дней на 5: " + dateTimes[0].toString());
        System.out.println("Год в dateTimes[0] - високосный: " + dateTimes[0].isLeapYear());


    }
}
