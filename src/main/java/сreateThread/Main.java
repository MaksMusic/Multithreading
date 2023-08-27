package сreateThread;


public class Main {
    public static void main(String[] args) {
        Flow1 flow1 = new Flow1("flow1");
        Flow1 flow2 = new Flow1("flow2");

        flow1.start();
        flow2.start();

        //Runnable
         //Thread thread = new Thread(new FlowRunnable());
         //thread.start();

        //анонимный класс
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
            System.out.println("flow anonim "+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }}).start();


    }
}
