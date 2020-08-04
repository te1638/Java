public class Calculate implements Runnable {
    private float arr[];
    private double number;

    public Calculate(float arr[], double number) {
        this.arr = arr;
        this.number = number;
    }

    @Override
    public void run() {
        {
            long fixTime = System.currentTimeMillis();


                for (int i = 0; i < arr.length; i++) {
                    arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.currentTimeMillis();
            System.out.printf("\nВремя цикла рассчёта для потока №[%s]: %s", number, (System.currentTimeMillis() - fixTime));
            }
        }
    }

