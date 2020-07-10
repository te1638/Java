public class Dog extends Animal {
    public Dog(String name) {
        super(name, 500, 0.5, 10);


    }

    public void dogRun(int lengthObstruction) {
        System.out.println("\nРезультат бега " + name + " на "
                + lengthObstruction + " м. : '" + resultRun(lengthObstruction) + "'");
    }

    public void dogJump(double lengthObstruction) {
        System.out.println("Результат прыжка " + name + " на "
                + lengthObstruction + " м. : '" + resultJump(lengthObstruction) + "'");
    }

    public void dogSwim(int lengthObstruction) {
        System.out.println("Результат плавания " + name + " на "
                + lengthObstruction + " м. : '" + resultSwim(lengthObstruction) + "'\n");
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




