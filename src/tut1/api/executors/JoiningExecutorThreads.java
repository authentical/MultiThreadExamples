package tut1.api.executors;


import tuts.common.LoopTaskI;
import tuts.common.NamedThreadsFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


// If CountDownLatch doneSignal > 0, MAIN will continue waiting
// otherwise if doneSignal == 0, MAIN will stop waiting and continue execution

/*
* A classical example of using CountDownLatch in Java is a server side
* core Java application which uses services architecture, where multiple
* services are provided by multiple threads and the application cannot
* start processing until all services have started successfully.
* --FROM: NikolaB@https://stackoverflow.com/questions/17827022/how-is-countdownlatch-used-in-java-multithreading
* */



public class JoiningExecutorThreads {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool(new NamedThreadsFactory());

        // When tasks have finished, join main thread
        CountDownLatch doneSignal = new CountDownLatch(2);

        exec.execute(new LoopTaskI(1, doneSignal));
        exec.execute(new LoopTaskI(500, doneSignal));
        exec.execute(new LoopTaskI(500, doneSignal));
        exec.execute(new LoopTaskI(1, doneSignal));


        try{
            // Main thread waits until doneSignal reaches 0
            // OR
            //  is interrupted by another thread
            doneSignal.await(); //  Wait for doneSignal count down latches=0
            System.out.println(".............. Finished waiting");
        }catch (InterruptedException e){e.printStackTrace();}

    }
}
