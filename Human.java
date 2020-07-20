public class Human implements Participant {

    protected String name;
    protected int jumpHeight;
    protected int runLength;

    public Human(String name, int jumpHeight, int runLength) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.runLength = runLength;
    }


    public void run() {
        System.out.println(String.format("Human [%s] try runing", name));


    }


    public void jump() {
        System.out.println(String.format("Human [%s] try jumping", name));

    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public int getRunLength() {
        return runLength;
    }

    public void win() {
        System.out.format("Участник %s завершил полосу препятствий\n", name);
    }

}
