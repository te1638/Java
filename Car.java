public class Car implements Runnable {
    private final String type = ("Car");
    private final float vol = 20f;
    private final float expense = 2.5f;
    public float amountOfGasoline = vol;
    private final String name;
    private FuelStation fuelStation;

    public Car(String name, FuelStation fuelStation) {
        this.name = name;
        this.fuelStation = fuelStation;
    }

    @Override
    public void run() {
        System.out.println(type + " "+ name + " going to road with fuel = "+ vol);
        while (true){
            try {
                Thread.sleep(3000);
                amountOfGasoline -= expense;
                System.out.println(type + " " + name + " fuel = " + amountOfGasoline);



                if (amountOfGasoline <=expense){
                    System.out.println(type + " "+ name+" going to FuelStation");

                    amountOfGasoline = fuelStation.refuel(vol, type, name);



                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}



