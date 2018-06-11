package tut1.api.executors.terminating;

import tuts.common.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TerminatingAllExecutorTasks {
    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool(new NamedThreadsFactory());

        LoopTaskA t1 = new LoopTaskA();
        LoopTaskF t2 = new LoopTaskF();
        FactorialTaskB t3 = new FactorialTaskB(30,500);
        CalculationTaskC t4 = new CalculationTaskC();
        CalculationTaskB t5 = new CalculationTaskB(2,3,9000);

        exec.execute(t1);
        exec.execute(t2);
        exec.submit(t3);
        exec.submit(t4);
        exec.submit(t5);

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        exec.shutdownNow();

        try {
            System.out.println("\nALL THREADS terminated. " +
                    exec.awaitTermination(500, TimeUnit.MILLISECONDS) + "\n");

        }catch(InterruptedException e){e.printStackTrace();}

    }
}
