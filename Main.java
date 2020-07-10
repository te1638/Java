public class Main {
    public static void main(String[] args) {

        Dog bob = new Dog("Bobby");
        Dog strongBob = new Dog("Сильный Bob");
        strongBob.setRunLength(700);
        strongBob.setJumpLength(2.0);
        strongBob.setSwimLength(30);
        Cat barsic = new Cat("Barsic");
        Cat floatingBarsic = new Cat("Плавающий Barsic");
        floatingBarsic.setSwimLength(5);
        establishObstruction(bob, strongBob, barsic, floatingBarsic);

    }


    public static void establishObstruction(Dog bob, Dog superBob, Cat barsic, Cat superBarsic) {

        int runObstruction = 378;
        double jumpObstruction = 0.9;
        int swimObstruction = 3;


        resultsDogRun(bob, runObstruction);
        resultsDogJump(bob, jumpObstruction);
        resultsDogSwim(bob, swimObstruction);
        resultsDogRun(superBob, runObstruction);
        resultsDogJump(superBob, jumpObstruction);
        resultsDogSwim(superBob, swimObstruction);
        resultsCatRun(barsic, runObstruction);
        resultsCatJump(barsic, jumpObstruction);
        resultsCatSwim(barsic, swimObstruction);
        resultsCatRun(superBarsic, runObstruction);
        resultsCatJump(superBarsic, jumpObstruction);
        resultsCatSwim(superBarsic, swimObstruction);


    }

    public static void resultsDogRun(Dog name, int obstruction) {
        name.dogRun(obstruction);
    }

    public static void resultsDogJump(Dog name, double obstruction) {
        name.dogJump(obstruction);
    }

    public static void resultsDogSwim(Dog name, int obstruction) {
        name.dogSwim(obstruction);
    }


    public static void resultsCatRun(Cat name, int obstruction) {
        name.catRun(obstruction);
    }

    public static void resultsCatJump(Cat name, double obstruction) {
        name.catJump(obstruction);
    }

    public static void resultsCatSwim(Cat name, int obstruction) {
        name.catSwim(obstruction);
    }


}
