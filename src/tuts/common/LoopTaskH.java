package tuts.common;

import java.util.concurrent.TimeUnit;


// This class allows the thread to do one cycle of doSomeMoreWork()
// before stopping

public class LoopTaskH implements Runnable {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private boolean sleepInterrupted = false;


    public LoopTaskH() {
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskG" + instanceNumber;
    }

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("##### [" + currentThreadName + "] <" + taskId + "> STARTING #####");

        for (int i=1;; i++) {
            System.out.println("[" + currentThreadName + "] <" + taskId + ">TICK TICK " + i);


            try {
                // Interrupt could come in here....
                TimeUnit.MILLISECONDS.sleep((long)(Math.random() * 3000));
            } catch (InterruptedException e) {
                System.out.println("***** [" + currentThreadName + "] <" + taskId + "> Sleep Interrupted. "
                + "SETTING THE FLAG");
                sleepInterrupted = true;
            }

            // Interrupt could also happen here....
            doSomeMoreWork();

            if(sleepInterrupted || Thread.interrupted()){
                System.out.println(currentThreadName + " "+ taskId + " INTERRUPTED.");
                break; // From infinite for()
            }
        }

        System.out.println("***** [" + currentThreadName + "] <" + taskId + "> DONE ******");
    }

    private void doSomeMoreWork(){
        System.out.println(Thread.currentThread().getName() + " " + taskId + " is WORKING....");
    }
}
