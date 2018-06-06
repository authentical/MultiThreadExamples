package tut1.api.executors.running;

import tuts.common.LoopTaskA;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingFixedThreadPool {
    public static void main(String[] args) {

        System.out.println("Main started");

        // Initialize ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(3);


        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());

        executorService.shutdown();
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());

        System.out.println("Main ENDED");

    }
}
