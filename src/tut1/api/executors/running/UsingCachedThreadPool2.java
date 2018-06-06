package tut1.api.executors.running;

import tuts.common.LoopTaskC;
import tuts.common.NamedThreadsFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UsingCachedThreadPool2 {


    public static void main(String[] args) {

        System.out.println("Main started");

        // Initialize ExecutorService
        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());

        //3 tasks
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 5 tasks
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());


        executorService.shutdown();

        System.out.println("Main ENDED");

    }

}
