package tuts.common;

import java.util.concurrent.TimeUnit;

public class ValueReturningClassC implements Runnable {

    private int a, b, sum;
    private long sleepTime;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;


    // Don't want to send out results via getSum() unless the Thread has finished!
    // BUT
    // If you .join the task thread using this class in MAIN, then MAIN waits for the join
    // and once the task is complete, the Task thread is joined and MAIN takes the thread, calling
    // getSum() which will definitely have a sum at task completion
    //
    //private volatile boolean done = false;  // Volatile = written to main memory, not cache


    public ValueReturningClassC(int a, int b, long sleepTime) {
            this.a = a;
            this.b=b;
            this.sleepTime = sleepTime;

            this.instanceNumber = ++count;
            this.taskId = "ValReturnTaskC-" + instanceNumber;
    }

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("#### {"+currentThreadName +"] <"+ taskId + "> STARTING #####");
        System.out.println("[" + currentThreadName + "] <" +taskId + "> Sleeping for " + sleepTime + " ms");

        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sum = a+b;

        System.out.println("***** ["+currentThreadName +"] <" + taskId + "> DONE ******");
    }

    public int getSum(){

        return sum;
    }
}
