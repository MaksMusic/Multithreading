package waitNotify;

public class WaitNotifyExample {
    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();


    }
}

class Market{
    private int smartphoneCount ;

    public synchronized void getSmartphone(){
        while (smartphoneCount < 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        smartphoneCount--;

        System.out.println("Покупатель купил 1 смартфон");
        System.out.println("Смартфонов осталось  магазине " + smartphoneCount);
        notify();
    }


    public synchronized void putSmartphone(){
        while (smartphoneCount >=5){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        smartphoneCount++;

        System.out.println("Потребитель добавил на витрину 1 смартфон");
        System.out.println("Смартфонов осталось  магазине " + smartphoneCount);
        notify();
    }

}

class Producer implements Runnable{
private Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putSmartphone();
        }
    }
}

class Consumer implements Runnable{
    private Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getSmartphone();
        }

    }
}
