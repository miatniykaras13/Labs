package Lab_5;



class Money
{
    private int _denomination;
    private int _amount;

    public Money()
    {
        _denomination = 0;
        _amount = 0;
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
    public static void outputMoney(Money m, int i)
    {
        System.out.printf("Объект money[%d]: ", i);
        System.out.println(m.toString() + '\n');
    }

    public static void main(String[] args)
    {

        Money[] money = new Money[4];
        money[0] = new Money();
        money[0].setDenomination(1);
        money[0].setAmount(20);
        money[1] = new Money(1, 6);
        money[2] = new Money(20, 1);
        money[3] = new Money(1, 20);

        for(int i = 0; i < money.length; i++)
        {
            outputMoney(money[i], i);
        }
        System.out.println("Объект money[0] равен money[1]: " + money[0].equals(money[1]));
        System.out.println("Сумма купюр money[0]: " + money[0].calculate());

    }
}
