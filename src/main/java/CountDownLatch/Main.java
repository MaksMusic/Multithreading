package CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Main {
    static CountDownLatch countDownLatch =
            new CountDownLatch(3);
    public static void main(String[] args) throws InterruptedException {
        new Friend("Anna1",countDownLatch);
        new Friend("Anna2",countDownLatch);
        new Friend("Anna3",countDownLatch);
        new Friend("Anna4",countDownLatch);
        new Friend("Anna5",countDownLatch);

        marketStaffIsOnPlace();
        everyThingIsReady();
        openMarket();

    }

    private static void marketStaffIsOnPlace() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Персонал вышел на работу");
        countDownLatch.countDown();
        System.out.println(countDownLatch.getCount() + "countDownLatch ");
    }

    private static void everyThingIsReady() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("everyThingIsReady");
        countDownLatch.countDown();
        System.out.println(countDownLatch.getCount() + "countDownLatch ");
    }



    private static void openMarket() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("open Market");
        countDownLatch.countDown();
        System.out.println(countDownLatch.getCount() + "countDownLatch ");
    }
}

class Friend extends Thread{
    String name;
    private CountDownLatch countDownLatch;

    public Friend(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    @Override
    public void run() {
        //если счетчик countDownLatch больше нуля то поток будет
        // заблокирован пока счетчик не станет равен нулю
        try {
            countDownLatch.await();
            System.out.println(name + " приступил к покупкам");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

