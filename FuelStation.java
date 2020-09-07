
import java.util.concurrent.Semaphore;

public class FuelStation {
    Semaphore semaphore = new Semaphore(3);
    public float refuel(float maxVol, String type, String name) {
             try {
                    semaphore.acquire();
                    System.out.println(type + " " + name + " started to refuel");
                    Thread.sleep(1000);
                    System.out.println(type + " " + name + " is refueling by 25%");
                    Thread.sleep(1000);
                    System.out.println(type + " " + name + " is refueling by 50%");
                    Thread.sleep(1000);
                    System.out.println(type + " " + name + " is refueling by 75%");
                    Thread.sleep(1000);
                    System.out.println(type + " " + name + " is refueling by 100%\n" + type + " " + name + " going to road");
                    semaphore.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return maxVol;
    }
}




