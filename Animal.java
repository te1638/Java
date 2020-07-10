public abstract class Animal {
    protected String name;
    protected int runLength;
    protected double jumpLength;
    protected int swimLength;

    public Animal(String name, int runLength, double jumpLength, int swimLength) {
        this.name = name;
        this.runLength = runLength;
        this.jumpLength = jumpLength;
        this.swimLength = swimLength;
    }

    public boolean resultRun(int lengthObstruction) {

        if (lengthObstruction < runLength) {
            return true;
        } else {
            return false;
        }
    }

    public boolean resultJump(double lengthObstruction) {

        if (lengthObstruction < jumpLength) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean resultSwim(int lengthObstruction) {

        if (lengthObstruction < swimLength) {
            return true;
        } else {
            return false;
        }
    }

}

