package tut1.api.executors.terminating;

import tuts.common.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TerminatingExecutorTasksSecondWay {
    public static void main(String[] args) {

        ExecutorService exec = Executors.newFixedThreadPool(2);

        LoopTaskF task1 = new LoopTaskF();
        CalculationTaskC task2 = new CalculationTaskC();
        LoopTaskF task3 = new LoopTaskF();


        Future<?> f1 =  exec.submit(task1);
        Future<Long> f2 = exec.submit(task2);
        Future<?> f3 = exec.submit(task3);

        exec.shutdown();    // Shutdown your ExecutorService!!

        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Interrupting LoopTaskF-1");
        f1.cancel(true);
        System.out.println("Interrupting CalcTaskC ");
        f2.cancel(true);
        System.out.println("Interrupting LoopTaskF-2");
        //f3.cancel(true);

    }
}
