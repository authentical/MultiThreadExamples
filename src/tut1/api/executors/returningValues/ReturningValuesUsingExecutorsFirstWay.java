package tut1.api.executors.returningValues;

import tuts.common.CalculationTaskA;
import tuts.common.LoopTaskA;
import tuts.common.NamedThreadsFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReturningValuesUsingExecutorsFirstWay {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool(new NamedThreadsFactory());

        // /submit returns an instance of Future
        Future<Integer> result1 = exec.submit(new CalculationTaskA(2,3,2000));
        Future<Integer> result2 = exec.submit(new CalculationTaskA(5,3,1000));
        Future<Integer> result3 = exec.submit(new CalculationTaskA(12,3,500));

        // ANy Runnable can be submitted but where there's no result,
        // Mark the Future<type> as unknown (?)
        Future<?> result4 = exec.submit(new LoopTaskA());

        Future<Double> result5 = exec.submit(new LoopTaskA(), 999.333);


        exec.shutdown();

        try {
            /*
                    .get() blocks until result is available
            */

            System.out.println("Result1 = " + result1.get());
            System.out.println("Result2 = " + result2.get());
            System.out.println("Result3 = " + result3.get());
            System.out.println("Result4 = " + result4.get());
            System.out.println("Result5 = " + result5.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
