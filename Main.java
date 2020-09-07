public class Main {
    public static void main(String[] args) {
        FuelStation fuelStation = new FuelStation();
        Car car0 = new Car("Bmw", fuelStation);
        Car car1 = new Car("Volvo", fuelStation);
        Car car2 = new Car("Lada", fuelStation);
        Bus bus0 = new Bus("Паз", fuelStation);
        Bus bus1 = new Bus("Икарус", fuelStation);
        Bus bus2 = new Bus("Паз2", fuelStation);
        Truck truck0 = new Truck("Volvo", fuelStation);
        Truck truck1 = new Truck("Scania", fuelStation);
        Truck truck2 = new Truck("Mercedes", fuelStation);
        Thread t1 = new Thread(car0);
        Thread t2 = new Thread(car1);
        Thread t3 = new Thread(car2);
        Thread t4 = new Thread(bus0);
        Thread t5 = new Thread(bus1);
        Thread t6 = new Thread(bus2);
        Thread t7 = new Thread(truck0);
        Thread t8 = new Thread(truck1);
        Thread t9 = new Thread(truck2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();

    }
}
