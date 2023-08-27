package volatileFlow;

public class VolatileEx extends Thread{
   volatile boolean b = true;

    @Override
    public void run() {
        long counter = 0;
        while (b){
            counter++;
        }
        System.out.println("Loop is finished  = " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileEx thread = new VolatileEx();
        thread.start();

        Thread.sleep(3000);
        System.out.println("After 3 seconds it is to wake up!");
        thread.b = false;
        thread.join();
        System.out.println("End of program");
    }
}
