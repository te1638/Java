public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        fullness = false;
    }

    public void eat(Plate p) {
        if (fullness == false) {
            System.out.printf("\nПопытка кота '%s' поесть", name);
            setFullness(p.decreaseFood(appetite));
            System.out.printf("\nПопытка кота '%s' поесть: %s\n", name, fullness);
        } else {
            System.out.printf("\nCытость кота '%s' уже %s\n",name, fullness);
        }
    }

    public void setFullness(boolean newFullness) {
        this.fullness = newFullness;
    }

}
