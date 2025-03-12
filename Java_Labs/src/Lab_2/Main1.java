package Lab_2;

import java.util.Scanner;

//variant 28
// Дано натуральное число n. Выведите в порядке возрастания все трехзначные числа,
//сумма цифр которых равна n.
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число n: ");
        int n = sc.nextInt();
        System.out.println("Трехзначные числа, сумма цифр которых равна n: ");
        for(int i = 1; i <= 9; i++)
        {
            for(int j = 0; j <= 9; j++)
            {
                for(int k = 0; k <= 9; k++)
                {
                   if(i + j + k == n)
                   {
                       System.out.print(i*100 + j*10 + k + " ");
                   }
                }
            }
        }
    }
}
