package tut1.api.executors.running;

import tuts.common.LoopTaskA;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class UsingCachedThreadPool {


    public static void main(String[] args) {

        System.out.println("Main started");

        // Initialize ExecutorService
        ExecutorService executorService = Executors.newCachedThreadPool();


        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());

        executorService.shutdown();

        System.out.println("Main ENDED");

    }

}
