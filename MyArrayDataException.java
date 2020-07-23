import java.io.IOException;

public class MyArrayDataException extends IOException {
    public MyArrayDataException(int i, int j, String[][] arr) throws MyArrayDataException {
        arr[i][j] = "0";
        throw new MyArrayDataException("Возникла проблема с переводом строки в число в элементе массива[" + (i + 1) + "][" + (j + 1) + "]\nДанная строка была изменена на '0'");
    }

    public MyArrayDataException(String message) {
        super(message);
    }
}