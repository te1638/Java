
public class Main {
    public static void main(String[] args) throws InterruptedException {

        runToArr();
        runTo2Arr();


    }

    public static void runToArr() throws InterruptedException {
        System.out.println("\nРасчёт времени пробега по массиву в одном потоке");
        final int size = 10000000;
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        Thread way1 = new Thread(new Calculate(arr, 1));
        way1.start();
        way1.join();
    }

    public static void runTo2Arr() throws InterruptedException {
        System.out.println("\nРасчёт времени пробега по двум массивам в режиме двух потоков");
        final int size = 10000000;
        final int halfSize = size / 2;
        float[] arr = new float[size];
        float[] secondArr = new float[halfSize];
        float[] firstArr = new float[halfSize];

        long fixTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, firstArr, 0, halfSize);
        System.arraycopy(arr, halfSize, secondArr, 0, halfSize);

        Thread way1 = new Thread(new Calculate(firstArr, 1));
        Thread way2 = new Thread(new Calculate(secondArr, 2));

        way1.start();
        way2.start();


        way1.join();
        way2.join();



        System.arraycopy(firstArr, 0, arr, 0, halfSize);
        System.arraycopy(secondArr, 0, arr, halfSize, halfSize);
        System.currentTimeMillis();
        System.out.println("\nВремя деления массива, просчёта каждого массива, склейки массива для второго метода: " + (System.currentTimeMillis() - fixTime));


    }
}
