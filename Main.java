
public class Main {

    public static void main(String args[]) {

        int i = 4;

        String[][] arr = new String[i][i];
        arr[0] = new String[]{"2", "44", "4", "4"};
        arr[1] = new String[]{"2", "s", "3", "2"};
        arr[2] = new String[]{"+", "41", "2", "2"};
        arr[3] = new String[]{"2", "4", "q", "2"};


        checkOutOfBounds(arr, i, i);
        sumArrayData(arr);

    }

    public static void checkOutOfBounds(String[][] arr, int i, int j) {
        try {
            if (i != 4) {
                System.out.println(arr[i][-1]);
            } else if (j != 4) {
                System.out.println(arr[j][-1]);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new MyArraySizeException("Неверный размер массива, для работы программы необходим массив размером [4][4]");
        }
    }

    public static void sumArrayData(String[][] arr) {
        int v = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                try {
                    v = Integer.parseInt(arr[i][j]);
                } catch (Exception e) {
                    v = 0;
                    try {
                        new MyArrayDataException(i, j, arr);
                    } catch (MyArrayDataException myArrayDataException) {
                        myArrayDataException.printStackTrace();
                    }
                } finally {
                    System.out.println(sum + "+" + arr[i][j] + "=" + (sum += v));
                }
            }
        }
        System.out.println("Сумма чисел массива = " + sum);
    }
}


