package Lab_5;


import java.util.Scanner;

class Money
{
    private int _denomination;
    private int _amount;

    public Money()
    {
//        _denomination = 0;
//        _amount = 0;
        this(0,0);
    }
    public Money(int denomination, int amount)
    {
        setDenomination(denomination);
        setAmount(amount);
    }

    public void setDenomination(int denomination)
    {
        if(denomination < 0)
        {
            System.out.println("Invalid denomination");
            return;
        }
        _denomination = denomination;
    }
    public int getDenomination()
    {
        return _denomination;
    }

    public void setAmount(int amount)
    {
        if(amount < 0)
        {
            System.out.println("Invalid amount");
            return;
        }
        _amount = amount;
    }
    public int getAmount()
    {
        return _amount;
    }

    public int calculate()
    {
        return _amount * _denomination;
    }

    public boolean equals(Money m)
    {
        return m.getDenomination() == this.getDenomination() && m.getAmount() == this.getAmount();
    }

    public String toString()
    {
        return "Номинал: " + getDenomination() + " Количество купюр: " + getAmount();
    }
}

public class Main1
{
    public static void outputMoney(Money[] money)
    {
        for(int i = 0; i < money.length; i++)
        {
            System.out.println("money[" + i + "] = " + money[i].toString());
        }
    }
    public static void main(String[] args)
    {
        Money[] money = new Money[4];
        Scanner sc = new Scanner(System.in);
        money[0] = new Money();
        money[0].setDenomination(1);
        money[0].setAmount(20);
        money[1] = new Money(1, 6);
        money[2] = new Money(20, 1);
        money[3] = new Money(1, 20);
        System.out.println("Создан массив объектов класса Money со следующим содержимым: ");
        outputMoney(money);
        System.out.println("Сколько объектов вы бы хотели изменить?");
        int choice = sc.nextInt();
        for(int i = 0; i < choice; i++)
        {
            System.out.println("Какой объект вы бы хотели изменить?");
            int c = sc.nextInt();
            if (c > 0) {
                System.out.println("Введите номинал объекта: ");
                int d = sc.nextInt();
                money[c - 1].setDenomination(d);
                System.out.println("Введите количество купюр объекта: ");
                int a = sc.nextInt();
                money[c - 1].setAmount(a);
            }
        }
        System.out.println("Содержимое списка после изменения: ");
        outputMoney(money);
        System.out.println("Сумму купюр скольких объектов money вы хотите знать?(введите число объектов)");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            System.out.println("Сумму купюр какого объекта money вы хотите знать?(введите номер в списке)");
            int m = sc.nextInt();
            System.out.printf("Сумма купюр money[%d]: ", m-1);
            System.out.println(money[m-1].calculate());
        }
        System.out.println("Сколько раз вы хотите сравнивать объекты money?");
        int m = sc.nextInt();
        for(int i = 0; i < m; i++)
        {
            System.out.println("Какие объекты списка money вы хотите сравнить?(введите номера в списке)");
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.printf("Объект money[%d] равен money[%d]: ", a, b);
            System.out.print(money[a-1].equals(money[b-1]));
        }

    }
}
