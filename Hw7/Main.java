import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(55);
        Cat[] catNumber= new Cat[5];
        catNumber[0] = new Cat("Barsic", 17);
        catNumber[1] = new Cat("Puma", 6);
        catNumber[2] = new Cat("Regis", 40);
        catNumber[3] = new Cat("Mike", 1);
        catNumber[4] = new Cat("Bruk", 9);
        plate.info();
        feedTheCats(catNumber, plate);
        plate.info();
        fillPlate(plate);
        feedTheCats(catNumber, plate);
    }


    public static Scanner sc = new Scanner(System.in);

    public static Cat[] feedTheCats(Cat[] arr, Plate plate){
        arr[0].eat(plate);
        arr[1].eat(plate);
        arr[2].eat(plate);
        arr[3].eat(plate);
        arr[4].eat(plate);
        return arr;

    }
    public static void fillPlate (Plate plateParameter){
        plateParameter.info();
        System.out.println("Вы можете добавить в тарелку 'n' еды и попробовать накормить оставшихся котов\nВведите 'n'");
        int val = sc.nextInt();
        plateParameter.setFood(val);
    }

}
