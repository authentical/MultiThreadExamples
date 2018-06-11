package tut1.api.executors.terminating;

import tuts.common.FactorialTaskB;
import tuts.common.LoopTaskA;
import tuts.common.LoopTaskG;
import tuts.common.NamedThreadsFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TerminatingBlockedExecutorTasks {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new NamedThreadsFactory());

        LoopTaskA task1= new LoopTaskA();
        LoopTaskG task2 = new LoopTaskG();
        FactorialTaskB task3 = new FactorialTaskB(30,500);

        Future<?> f1 = exec.submit(task1);
        Future<?> f2 = exec.submit(task2);
        Future<?> f3 = exec.submit(task3);

        exec.shutdown();    // Only stops accepting new tasks.
                            // Does not cancel tasks like

        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Invoking cancel() on all tasks");
        f1.cancel(true);
        f2.cancel(true);
        f3.cancel(true);



    }
}
