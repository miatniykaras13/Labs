package Lab_4;

import java.util.Arrays;

//12. Удалите строки матрицы, не имеющие ни одного повторяющегося элемента
public class Main1
{
    public static int count(int[] ar, int n)
    {
        int counter = 0;
        for (int j : ar)
        {
            if (j == n)
            {
                counter++;
            }
        }
        return counter;
    }
    public static boolean isValid(int[] ar)
    {
        for (int n : ar)
        {
            if (count(ar, n) > 1)
            {
                return true;
            }
        }
        return false;
    }
    public static int countNumberOfValidRows(int[][] matrix)
    {
        int rows = 0;
        for (int[] ar : matrix)
        {
            if (isValid(ar))
            {
                rows ++;
            }
        }
        return rows;
    }
    public static void main(String[] args)
    {
        int[][] matrix = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 2, 2},
                {1, 2, 3, 4, 6},
                {3, 4, 5, 6, 7},
        };
        int[][] new_matrix = new int[countNumberOfValidRows(matrix)][matrix[0].length];
        int counter = 0;
        for(int i = 0; i < matrix.length; i++)
        {
            if(isValid(matrix[i]))
            {
                new_matrix[counter] = matrix[i].clone();
                counter++;
            }
        }
        for (int[] newMatrix : new_matrix)
        {
            System.out.println(Arrays.toString(newMatrix));
        }
    }
}
