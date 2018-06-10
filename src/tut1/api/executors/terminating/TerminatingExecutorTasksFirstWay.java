package tut1.api.executors.terminating;

import tuts.common.FactorialTaskA;
import tuts.common.LoopTaskE;
import tuts.common.NamedThreadsFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TerminatingExecutorTasksFirstWay {
    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool(new NamedThreadsFactory());

        LoopTaskE task1 = new LoopTaskE();
        FactorialTaskA task2 = new FactorialTaskA(30, 1000);

        exec.execute(task1);
        exec.submit(task2);

        exec.shutdown();    // Shutdown your ExecutorService!!

        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task1.cancel();
        task2.cancel();
    }
}
