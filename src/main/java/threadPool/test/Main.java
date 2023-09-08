package threadPool.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new MyRun("загрузка 1"));
        executorService.execute(new MyRun("загрузка 2"));
        executorService.execute(new MyRun("загрузка 3"));
        executorService.execute(new MyRun("загрузка 4"));
        executorService.execute(new MyRun("загрузка 5"));
        executorService.shutdown();

    }
}

class MyRun implements Runnable{
    String text;

    public MyRun(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(text);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
