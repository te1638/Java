package ru.geekbrains;

import java.util.Random;
import java.util.Scanner;
public class Main {
    public static int size = 3;
    public static final char emptySymbol = '☐';
    public static final char humanSymbol = 'X';
    public static final char computerSymbol = 'O';
    public static char[][] field;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {

    playGame();
    }


    public static void playGame (){
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(humanSymbol)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(computerSymbol)) {
                System.out.println("Победил PC");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }
    public static boolean checkWin(char symb) {

        int i;
        if (field[0][0] == symb && field[1][1] == symb && field[2][2] == symb) {
            return true;
        }else if (field[2][0] == symb && field[1][1] == symb && field[0][2] == symb) {
            return true;
        }
        for (i=0; i<3; i++){
            if (field[i][0] == symb && field[i][1] == symb && field[i][2] == symb) {
                return true;
            } else if (field[0][i] == symb && field[1][i] == symb && field[2][i] == symb) {
                return true;
            }
        }
        return false;
    }
    public static boolean isMapFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j] == emptySymbol) return false;
            }
        }
        return true;
    }
    public static void aiTurn() {
        int i, j;
        do {
            i = rand.nextInt(size);
            j = rand.nextInt(size);
        } while (!isCellValid(i, j));
        System.out.println("Компьютер походил в точку [" + (i + 1) + "][" + (j + 1) +"]");
        field[j][i] = computerSymbol;
    }
    public static void humanTurn() {
        int i, j;
        do {
            System.out.println("Введите координаты в формате [X][Y]");
            i = sc.nextInt() - 1;
            j = sc.nextInt() - 1;
            if (field[i][j] != emptySymbol){
                System.out.println("Эти координаты уже заняты [X][Y]");
            }
        } while (!isCellValid(i, j));
        field[j][i] = humanSymbol;
    }
    public static boolean isCellValid(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) return false;
        if (field[j][i] == emptySymbol) return true;
        return false;
    }
    public static void initMap() {
        field = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = emptySymbol;
            }
        }
    }
    public static void printMap() {
        for (int i = 0; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}