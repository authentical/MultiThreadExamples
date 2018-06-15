package tut1.api.executors;

import tuts.common.ExceptionLeakingTask;
import tuts.common.LoopTaskI;
import tuts.common.NamedThreadsFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JoiningExecutorThreads {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool(new NamedThreadsFactory());

        CountDownLatch doneSignal = new CountDownLatch(2);

        exec.execute(new LoopTaskI(1, doneSignal));
        exec.execute(new LoopTaskI(500, doneSignal));
        exec.execute(new LoopTaskI(500, doneSignal));
        exec.execute(new LoopTaskI(1, doneSignal));


        try{
            doneSignal.await();
            System.out.println(".............. Finished waiting");
        }catch (InterruptedException e){e.printStackTrace();}

    }
}
