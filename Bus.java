import javax.crypto.Mac;

public class Bus implements Runnable{
    private final String type = ("Bus");
    private final float vol = 40f;
    private static final float expense = 7.5f;
    public float amountOfGasoline = vol;
    private final String name;
    private FuelStation fuelStation;


    public Bus(String name, FuelStation fuelStation) {
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



