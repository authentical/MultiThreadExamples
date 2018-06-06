package tut1.api.threads.naming;

import tuts.common.LoopTaskC;
import tuts.common.NamedThreadsFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NamingExecutorThreads {
    public static void main(String[] args) {

        String currentThreadName = Thread.currentThread().getName();



        System.out.println("[" + currentThreadName + "] Main start");


        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());

        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());

        System.out.println("[" + currentThreadName + "] Main END");


        executorService.shutdown();

    }
}
