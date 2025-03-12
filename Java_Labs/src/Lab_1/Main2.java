package Lab_1;
import java.util.Scanner;
import java.lang.Math;

public class Main2
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число x: ");

        double x = in.nextDouble();

        double b = -1.6, m = 0.9, n = -1.4;
        System.out.printf("Значение функции при b = %.1f, m = %.1f, n = %.1f: ", b, m, n);
        if(Math.abs(b*m) > x*x)
        {
            System.out.print(Math.sin(b*m + Math.cos(n*x)));
        }
        else if(Math.abs(b*m) < x*x)
        {
            System.out.print(Math.cos(b*m + Math.sin(x)));
        }
        else
        {
            System.out.print(Math.sqrt(Math.exp(Math.abs(Math.cos(x))) + Math.sqrt(Math.abs(b * m * x))));
        }

        b = 4.5; m = -2; n = 2.2;
        System.out.printf("\nЗначение функции при b = %.1f, m = %.1f, n = %.1f: ", b, m, n);

        if(Math.abs(b*m) > Math.pow(x, 2))
        {
            System.out.print(Math.sin(b*m + Math.cos(n*x)));
        }
        else if(Math.abs(b*m) < Math.pow(x, 2))
        {
            System.out.print(Math.cos(b*m + Math.sin(x)));
        }
        else
        {
            System.out.print(Math.sqrt(Math.exp(Math.abs(Math.cos(x))) + Math.sqrt(Math.abs(b * m * x))));
        }

        b = -4.5; m = 0.5; n = -1.5;
        System.out.printf("\nЗначение функции при b = %.1f, m = %.1f, n = %.1f: ", b, m, n);

        if(Math.abs(b*m) > Math.pow(x, 2))
        {
            System.out.print(Math.sin(b*m + Math.cos(n*x)));
        }
        else if(Math.abs(b*m) < Math.pow(x, 2))
        {
            System.out.print(Math.cos(b*m + Math.sin(x)));
        }
        else
        {
            System.out.print(Math.sqrt(Math.exp(Math.abs(Math.cos(x))) + Math.sqrt(Math.abs(b * m * x))));
        }







    }
}
