package ru.geekbrains;

public class Main {

    public static void main(String[] args) {
        int[] arr1 = {1, 0, 1, 0, 0, 1, 1, 0, 0, 1};
        int[] arr2 = new int[8];
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] arr4 = new int[4][4];
        int[] arr5 = {15, 6, 13, 1, 2, 4, 5, 0, 4, 8, 9, 13};
        int taskNumber = 1;
        showNumberHomeworkTask(taskNumber);
        overturnArray(arr1);
        showOverturnArray(arr1);
        taskNumber++;
        showNumberHomeworkTask(taskNumber);
        fillingArray(arr2);
        showFillingArray(arr2);
        taskNumber++;
        showNumberHomeworkTask(taskNumber);
        multiplyArray(arr3);
        showMultiplyArray(arr3);
        taskNumber++;
        showNumberHomeworkTask(taskNumber);
        overturnArrayDiagonals(arr4);
        showOverturnArrayDiagonals(arr4);
        taskNumber++;
        showNumberHomeworkTask(taskNumber);
        findAndShowMinAndMax(arr5);


    }

    public static void overturnArray(int[] arr1) {
        //Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 1) {
                arr1[i] -= 1;
            } else {
                arr1[i] += 1;
            }
        }
    }

    public static void showOverturnArray(int[] newArr1) {
        for (int i = 0; i < newArr1.length; i++) {
            System.out.println("[" + i + "] = " + newArr1[i]);
        }
    }

    public static void showNumberHomeworkTask(int taskNumber) {
        System.out.println("Задание " + taskNumber);
    }

    public static void fillingArray(int[] arr2) {
        //Задать пустой целочисленный массив размером 8.
        // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        arr2[0] = 0;
        for (int i = 1; i < arr2.length; i++) {
            arr2[i] = arr2[i - 1] + 3;
        }

    }

    public static void showFillingArray(int[] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("[" + i + "] = " + arr2[i]);
        }
    }

    public static void multiplyArray(int[] arr3) {
        //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
        // и числа меньше 6 умножить на 2;
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
    }

    public static void showMultiplyArray(int[] arr3) {
        for (int i = 0; i < arr3.length; i++) {
            System.out.println("[" + i + "] = " + arr3[i]);
        }
    }

    public static void overturnArrayDiagonals(int[][] arr4) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                if (i == j) {
                    arr4[i][j] = 1;
                }
        }
    }

    public static void showOverturnArrayDiagonals(int[][] arr4) {
        //Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("[" + i + "][" + j + "] =" + arr4[i][j]);
            }
        }
    }

    public static void findAndShowMinAndMax(int[] arr5) {
        //** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int max = arr5[0];
        int min = arr5[0];
        for (int i = 1; i < arr5.length; i++) {

            if (arr5[i] >= max) {
                max = arr5[i];

            }
        }
        for (int i = 1; i < arr5.length; i++) {

            if (arr5[i] <= min) {
                min = arr5[i];

            }
        }
        System.out.println("Max = " + max + "\nMin = " + min);
    }
}

