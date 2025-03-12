package Lab_3;

import javax.swing.text.DefaultStyledDocument;
import java.util.Arrays;
import java.util.Scanner;

public class Main1
{
    //variant 5
    //В массиве найти все нулевые элементы и заменить их вместе с соседними элементами на 3.
    public static void main(String[] args)
    {
        int[] arr = {0, 0, 0, 2,2,1,0,0};
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Введите количество элементов в массиве: ");
        int n = arr.length;
        System.out.println("Исходный массив: ");
        for(int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
//        System.out.println("Введите элементы массива: ");

//        for(int i = 0; i < n; i++)
//        {
//            arr[i] = sc.nextInt();
//        }
        
        for(int i = 0; i < n; i++)
        {
            if(arr[i] == 0)
            {
                if(i != 0 && i != n-1)
                {
                    if(arr[i+1] != 0)
                    {
                        arr[i] = 3;
                        arr[i+1] = 3;
                        arr[i-1] = 3;
                    }
                    else
                    {
                        arr[i] = 3;
                        arr[i-1] = 3;
                    }
                }
                else
                {
                    if(i == 0)
                    {
                        if(arr[i+1] == 0)
                        {
                            arr[i] = 3;
                        }
                        else
                        {
                            arr[i] = 3;
                            arr[i+1] = 3;
                        }
                    }
                    else
                    {
                        arr[i] = 3;
                        arr[i-1] = 3;
                    }
                }

            }
        }

        System.out.println("\nПреобразованный массив: ");
        System.out.println(Arrays.toString(arr));
//        for(int i = 0; i < n; i++)
//        {
//            System.out.print(arr[i] + " ");
//        }

    }
}
