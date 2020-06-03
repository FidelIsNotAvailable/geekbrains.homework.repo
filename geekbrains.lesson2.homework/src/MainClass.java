import java.util.Arrays;
import java.util.spi.AbstractResourceBundleProvider;

public class MainClass {

    public static void main(String[] args)
    {
        /*Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        С помощью цикла и условия заменить 0 на 1, 1 на 0;
        */

        int[] arr1 = {1,0,1,0,1,0,1,0};
        for(int i = 0; i < arr1.length;i++){
            if(arr1[i] == 1) arr1[i] = 0;
            else arr1[i]=1;
        }

//        Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

        int[]arr2 = new int[8];
        for(int i = 0; i < arr2.length;i++) {
            arr2[i] = 3 * i;
        }

//        Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

        int[]arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for(int i = 0; i < arr3.length;i++) {
            if (arr3[i] < 6)
                arr3[i] = arr3[i] * 2;
        }

//        Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
//        и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

        int[][] sqrArr = new int[5][5];
        for(int i = 0; i < sqrArr.length; i++){
                    int j = sqrArr.length;
                    sqrArr[i][i] = 1;
                    sqrArr[i][(sqrArr.length - i - 1)] = 1;
            }

        // метод вывода результата
        printArrayValues(sqrArr);

        //** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);

        int[] arr4 = {2, 5, 7, 1, 9, 8, 3, 0, 4, 6};
        findMinInarr(arr4);

        //** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
        // если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        // граница показана символами ||, эти символы в массив не входят.

        int[] arr5 = {1, 1, 0, 1, 5, 0, -2};
        System.out.println(checkBalance(arr5));

        //**** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
        // или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
        // Для усложнения задачи нельзя пользоваться вспомогательными массивами.


        // Эту задачу решить не смог. Полагаю, что нужна рекурсия, но без гугла я ее не вспомню.
        int[] arr6 = {1, 2, 3};
        int n = 0;

        //shiftArrByN(arr6, n);

        printArrayValues(arr6);
    }

    // Метод для поиска минимального значения в одномерном массиве
    public static void findMinInarr(int[] arr){
        int min = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(min > arr[i])
                min = arr[i];
        }
        System.out.println(min);
    }

    // Метод для шестого задания - сравнение суммы левой и правой части массива.

    public static boolean checkBalance(int[] arr){
        int leftPartSum = 0;
        int rightPartSum = 0;

        for(int i = 0; i < arr.length; i++){
            rightPartSum += arr[i];
        }

        for(int i = 0; i < arr.length; i++){
            if(leftPartSum == rightPartSum){
                return true;
            } else{
                leftPartSum +=arr[i];
                rightPartSum -=arr[i];
            }
        }
        return false;
    }

    // Методы вывода массивов для проверки результата
    public static void printArrayValues(int[] arr){
        String arrToPrint = Arrays.toString(arr);
        System.out.println(arrToPrint);
    }

    public static void printArrayValues(int[][] arr){
        for(int i = 0; i < arr.length; i++) {
            String arrToPrint = Arrays.toString(arr[i]);
            System.out.println(arrToPrint);
        }
    }
}
