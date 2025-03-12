package Lab_1;

import java.util.Scanner;
//3 variant
public class Main1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите 3 целых числа: ");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        System.out.println("Числа, которые делятся либо на 3, либо на 9: ");

        if(a % 3 == 0)
            System.out.printf("%d ", a);
        if(b % 3 == 0)
            System.out.printf("%d ", b);
        if(c % 3 == 0)
            System.out.printf("%d ", c);

    }
}
