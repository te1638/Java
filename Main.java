package ru.geekbrains;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int number = 9;
        byte numberTry = 3;
        System.out.println("Ваша задача угадать число.");
        GuessNumber(number, numberTry);
        scanner.close();
    }

    public static void GuessNumber(int range, byte tryNumber) {
        int number = (int) (Math.random() * range);
        int i;
        for (i = 0; i <= tryNumber; i++) {
            System.out.println("Угадайте число от 0 до " + range +"\nПопытка №"+ (i+1));
            int inputNumber = scanner.nextInt();
            if (inputNumber == number) {
                System.out.println("Вы угадали.");
                question(range, tryNumber);
                return;
            } else if (tryNumber - 1 == i) {
                System.out.println("Попытки закончились");
                question(range, tryNumber);
                return;
            } else if (inputNumber > number) {
                System.out.println("Загаданное число меньше");
            } else {
                System.out.println("Загаданное число больше");

            }
        }
    }

    public static void question(int number, byte numberTry) {


        System.out.println("Eсли хотите сыграть еще раз, введите 1.\n" + "Если хотите выйти, введите 0.");
        int var = scanner.nextInt();
            if (var == 0) {
                return;
            } else if (var == 1) {
                GuessNumber(number, numberTry);
            } else {
                System.out.println("Необходимо ввести 0 или 1");
                question(number, numberTry);
                return;
            }


        }
    }