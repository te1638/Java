public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;

    }

    public boolean decreaseFood(int n) {

        if (n > food) {
            System.out.printf("\nВ тарелке не хватает '%s' еды, коту нужно заполнить тарелку до %s", n - food, n);
            return false;
        }

        food -= n;
        return true;


    }

    public void info() {
        System.out.printf("\nВ тарелке '%s' еды\n", food);
    }

    public void setFood(int fill){
        this.food = food+fill;
    }
}
