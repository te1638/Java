public class Robot implements Participant {
    protected int number;
    protected int jumpHeight;
    protected int runLength;

    public Robot(int number, int jumpHeight, int runLength) {
        this.number = number;
        this.jumpHeight = jumpHeight;
        this.runLength = runLength;
    }


    @Override
    public void run() {

        System.out.println(String.format("Robot [%s] try runing", number));


    }


    public void jump() {
        System.out.println(String.format("Robot [%s] try jumping", number));

    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public int getRunLength() {
        return runLength;
    }

    public void win() {
        System.out.format("Участник Robot %s завершил полосу препятствий\n", number);
    }

}
