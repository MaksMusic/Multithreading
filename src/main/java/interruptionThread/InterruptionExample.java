package interruptionThread;

public class InterruptionExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main starts");
        InterrupterThread thread = new InterrupterThread();
        thread.start();

        Thread.sleep(5000);
        //thread.stop(); //грубо прерывал поток
        thread.interrupt();

        thread.join();
        System.out.println("main ends");
    }
}


class InterrupterThread extends Thread{
    @Override
    public void run() {
        double sqrtSum = 0;
        for (int i = 0; i <1_000_000_000 ; i++) {
            if (isInterrupted()){
                System.out.println(getName() + " хотят прервать");
                System.out.println("sqrtSum = " + sqrtSum);
                System.out.println("поток прерван");
                return;
            }
            sqrtSum+=Math.sqrt(i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Поток пытаются прервать во время сна ");
                System.out.println("sqrtSum = " + sqrtSum);
                System.out.println("прерываем поток");
                return;
            }
        }

        System.out.println(sqrtSum);
    }
}
