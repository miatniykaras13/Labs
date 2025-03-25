package Lab_4;
//9. В матрице удалить столбцы с максимальным и минимальным элементами матрицы,
//а затем на место первого удаленного столба добавить столбец из произведений элементов
//соответствующих строк оставшихся столбцов.
import java.util.Arrays;

public class Main {

     public static void main(String[] args) {
            int[][] matrix = {
                    {3, 8, 2, 5},
                    {7, 1, 6, 4},
                    {9, 3, 5, 2}
            };
            System.out.println("Исходная матрица: ");
            printMatrix(matrix);
            matrix = processMatrix(matrix);
         System.out.println("\nИзмененная матрица: ");
            printMatrix(matrix);
        }
        public static int[][] processMatrix(int[][] matrix) {
            int str = matrix.length;//кол во строк
            int stol = matrix[0].length; //длина первого массива из матрицы

            // Найти индексы столбцов с максимальным и минимальным элементами
            int min = 0, max = 0;
            int minVal = matrix[0][0], maxVal = matrix[0][0];
            for (int i =0 ; i < stol; i++){
                for(int j = 0;j < str; j++){
                    if (matrix[j][i] < minVal){
                        minVal = matrix[j][i];
                        min = i;
                    }
                    if (matrix[j][i] > maxVal){
                        maxVal = matrix[j][i];
                        max = i;
                    }
                }
            }
            //определение какой столбец удаляем первым
            int firstDeleted = 0;
            if(max>min)
            {
                firstDeleted = min;
            }
            else if(max<min)
            {
                firstDeleted = max;
            }
            else{
                firstDeleted = max;
            }
            int[][] matrix2 = Arrays.copyOf(matrix, str);

            //заполняем первый столбец единицами
            for(int i = 0; i < str; i++){
                matrix2[i][firstDeleted] = 1;
            }

            // Удаляем столбцы
            int newStol = 0;

            for (int j = 0; j < stol; j++) {
                if (j != min && j != max) {
                    for (int i = 0; i < str; i++) {
                        matrix2[i][newStol] = matrix[i][j];
                    }
                    newStol++;
                    if (j == firstDeleted) {
                        newStol++;
                    }
                }
            }

            //определяем есть ли нулевой столбец
            int zeroStolb = 0;
            





            //Создать новый столбец из произведений элементов строк
            for(int i = 0 ; i < str ; i++){
                for(int j = 0 ; j < stol ; j++){
                    if(j!=firstDeleted){
                        matrix2[i][firstDeleted] *= matrix2[i][j];
                    }
                }
            }
            return matrix2;
        }

        public static void printMatrix(int[][] matrix) {
            for (int[] row : matrix) {
                for (int val : row) {
                    if(val!= 0) {
                        System.out.print(val + " ");
                    }
                }
                System.out.print('\n');
            }
        }
    }
