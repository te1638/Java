import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        Object[] arr = {1,2,3, "test4","test5"};
        swap(arr,1,4);


        String[] arrayOfStrings = {"A", "B", "C", "D"};
        asList(arrayOfStrings);

        Box<Orange> orangeBox = new Box<>();

        Box<Apple> appleBox = new Box<>();


        appleBox.addFruit(new Apple(),15);
        orangeBox.addFruit(new Orange(),10);
        System.out.println(orangeBox.compare(appleBox));


    }
    public static void swap(Object[] arr, int i, int j){
        System.out.println(Arrays.toString(arr));
        Object s1 = arr[j];
        arr[j] = arr[i];
        arr[i] = s1;
        System.out.println(Arrays.toString(arr));
    }
    public static <T> void asList(T[]arr){

        ArrayList<T> alt = new ArrayList<>(Arrays.asList(arr));
        System.out.println(alt);
    }
}