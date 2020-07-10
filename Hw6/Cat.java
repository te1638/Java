public class Cat extends Animal {

    public Cat(String name) {
        super(name, 200, 2, 0);
    }

    public void catRun(int lengthObstruction) {
        System.out.println("\nРезультат бега " + name + " на " +
                lengthObstruction + " м. : '" + resultRun(lengthObstruction) + "'");
    }

    public void catJump(double lengthObstruction) {
        System.out.println("Результат прыжка " + name + " на " +
                lengthObstruction + " м. : '" + resultJump(lengthObstruction) + "'");
    }

    public void catSwim(int lengthObstruction) {
        System.out.println("Результат плавания " + name + " на " +
                lengthObstruction + " м. : '" + resultSwim(lengthObstruction) + "'\n");
    }

    public void setRunLength(int length) {
        this.runLength = length;
    }

    public void setJumpLength(double length) {
        this.jumpLength = length;
    }

    public void setSwimLength(int length) {
        this.swimLength = length;
    }


}
