package tuts.common;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// LoopTaskI has a CountDownLatch object
// LoopTaskI calls CountDownLatch.countDown() (which uses Sync method (extends AbstractQueuedSynchronizer))
// to decrement the number of tasks MAIN's CountDownLatch.await() will wait for.
//
// If CountDownLatch doneSignal > 0, MAIN will continue waiting
// otherwise if doneSignal reaches 0, MAIN will stop waiting and continue execution



public class LoopTaskI implements Runnable{

    private static int count =0;
    private int instanceNumber;
    private String taskId;
    private long sleepTime;
    private CountDownLatch doneCountLatch;


    // Constructor
    public LoopTaskI(long sleepTime, CountDownLatch doneCountLatch){
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskI" + instanceNumber;
        this.sleepTime = sleepTime;
        this.doneCountLatch =  doneCountLatch;
    }

    // Blocking
    @Override
    public void run(){

        boolean isRunningInDaemonThread = Thread.currentThread().isDaemon();
        String threadType = isRunningInDaemonThread ? "DAEMON" : "USER";
        String currentThreadName = Thread.currentThread().getName();


        System.out.println("#### [" +currentThreadName + ", " + threadType + "] <" + taskId + "> STARTING ####");

        for(int i=10; i>0; i--){
            System.out.println("["+ currentThreadName + "] <" + taskId + ">" + "TICK TICK "+ i);
            try{
                TimeUnit.MILLISECONDS.sleep(sleepTime);}
            catch(InterruptedException e){}
        }

        System.out.println("***** ["+ currentThreadName + ", " + threadType + "] <" + taskId + "> DONE *****");


        if(doneCountLatch !=null){
            doneCountLatch.countDown(); // = 1 task has completed
            System.out.println("***** ["+ currentThreadName + ", " + threadType + "] <" + taskId + "> LATCH COUNT = " + doneCountLatch.getCount());
        }
    }

}
