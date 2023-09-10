package threadPool.v2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool2 {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(3);

        //обычный способ запуска задачи в пуле потоков сразу
        // for (int i = 0; i < 10; i++) {
        //  scheduledExecutorService.execute(new RunnableImpl2());
        //}

        //запуск задачи в пуле потоков через 5 сек
        // scheduledExecutorService.schedule(new RunnableImpl2(),5, TimeUnit.SECONDS);


        //запуск задачи через 3 сек далее будет выполняться с периодичностью в 2 сек пока не остановить
        //если задача выполнялась 1 сек и периодичность было 5 сек то след задача выполниться уже через 4 сек

        //если задача выполнялась 10 сек, а периодичность было 5 сек то
        // след задача запуститься сразу после выполнения предыдущей
        // scheduledExecutorService.scheduleAtFixedRate(new RunnableImpl2(), 3,5,TimeUnit.SECONDS);


        //запуск задачи через 3 сек далее будет выполняться с периодичностью в 3 сек
        //если задача выполнялась 3 секунду то след будет выполится через 3 секунды после
        //завершения предыдущей
        //scheduledExecutorService.scheduleWithFixedDelay(new RunnableImpl2(), 3,3,TimeUnit.SECONDS);

        //завершение работы со thread pool
            Thread.sleep(20000);
            scheduledExecutorService.shutdown();

            //}


        //Пул который сам создает потоки по мере необходимости если они не исп удаляет их
        ExecutorService executorService = Executors.newCachedThreadPool();
    }


}
class RunnableImpl2 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " начал работу");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " завершил работу");
    }
}