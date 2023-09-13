package CallableAndFuture.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SumNumbers {

    private static long value = 1_000_000_000l;
    private static long sum;

    public static void main(String[] args) throws
            ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Long>> futures = new ArrayList<>();

        //разделение на 10 задач для 10 потоков
        long valueDividedBy10 = value/10;
        for (int i = 0; i < 10; i++) {
            long from = valueDividedBy10 * i + 1;
            long to = valueDividedBy10 * (i + 1);
            PartialSum task = new PartialSum(from, to);
            Future<Long> longFuture = executorService.submit(task);
            futures.add(longFuture);
        }

            //получить результат работы 10 потоков
            for (Future<Long> future : futures) {
                sum+=future.get();
            }
            executorService.shutdown();
            System.out.println("Total sum " + sum);
    }
}

class PartialSum implements  Callable<Long>{
    long from;
    long to;
    long localSum;

    public PartialSum(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() {
        for (long i =from; i < to; i++) {
            localSum+=i;
        }
        System.out.println("sum from "+ from +" to" + to +" = "+ localSum);
        return localSum;
    }
}