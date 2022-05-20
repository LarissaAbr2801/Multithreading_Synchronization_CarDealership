import java.util.ArrayList;
import java.util.List;

public class CarDealership {

    final List<Car> cars = new ArrayList<>();
    final static int BUYING_CAR_TIME = 3000;

    public synchronized void sellCar() {
        try {
            System.out.println("Покупатель " + Thread.currentThread().getName() + " зашел в автосалон");

            while (cars.size() == 0) {
                System.out.println("Машин нет");
                wait();
            }
            Thread.sleep(BUYING_CAR_TIME);
            System.out.println("Покупатель " + Thread.currentThread().getName() +
                    " уехал на новеньком авто");
            cars.remove(0);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public synchronized void addCar() {
        cars.add(new Car());
        notify();
    }

}
