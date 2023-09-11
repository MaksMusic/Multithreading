package CallableAndFuture;

import java.util.concurrent.*;

public class Main {
    static int factorialResult;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService =
                Executors.newSingleThreadExecutor();

        //обычный вариант запуска потока который не возвращает результат
        // RunnableFactorial factorial= new RunnableFactorial(5);
        //executorService.execute(factorial);


        //вариант запуска потока через Callable который возвращает результат
        //так же выбросит исключение
        //тут применяется метод executorService.submit(factorial)
        //вместо execute(factorial)
        //возвращаемый тип Future<Integer> параметризирован типов котоый
        //вернет данный метод call (который используется вместо run() )
        CallableFactorial factorial = new CallableFactorial(5);
        Future<Integer> resultFuture = executorService.submit(factorial);

        //exception может быть выброшен если ввели не верное число
        try {
            factorialResult = resultFuture.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(factorialResult);
    }
}


class RunnableFactorial implements Runnable{
    int f;

    public RunnableFactorial(int f) {
        this.f = f;
    }

    @Override
    public void run() {
        if (f<=0){
            System.out.println("не верное число");
            return;
        }
       int result = 1;
        for (int i = 1; i <= f; i++) {
            result*=i;
        }
        Main.factorialResult = result;
    }
}

class CallableFactorial implements Callable<Integer>{
    int f;

    public CallableFactorial(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if (f<=0){
           throw new Exception("вы ввели не верное число");
        }

        int result = 1;
        for (int i = 1; i <= f; i++) {
            result*=i;
        }
        return result;
    }
}
