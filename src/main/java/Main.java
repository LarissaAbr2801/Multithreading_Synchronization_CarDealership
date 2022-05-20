public class Main {

    final static int BUYERS_QUANTITY = 3;
    final static int WORK_WITH_CLIENT = 2500;

    public static void main(String[] args) throws InterruptedException {
        CarDealership dealership = new CarDealership();
        Seller seller = new Seller("Производитель Toyota");

        for (int i = 0; i < BUYERS_QUANTITY; i++) {
            Thread.sleep(WORK_WITH_CLIENT);
            new Thread(null, dealership::sellCar, "" + (i + 1) + "").start();
            Thread.sleep(WORK_WITH_CLIENT);
            new Thread(null, () -> seller.produceCar(dealership), seller.getName()).start();

        }

    }
}
