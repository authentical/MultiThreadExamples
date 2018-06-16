package tuts.common;

import java.util.concurrent.TimeUnit;

public class ValueReturningClassA implements Runnable {

    private int a, b, sum;
    private long sleepTime;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    // Don't want to send out results via getSum() unless the Thread has finished!
    private volatile boolean done = false;  // Volatile = written to main memory, not cache


    public ValueReturningClassA(int a, int b, long sleepTime) {
            this.a = a;
            this.b=b;
            this.sleepTime = sleepTime;

            this.instanceNumber = ++count;
            this.taskId = "ValReturnTaskA-" + instanceNumber;
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

        done = true;

        // Synchronized is used so notifyAll() cannot occur at the same time
        // as wait().
        synchronized (this){
            System.out.println("["+ currentThreadName + "] <" + taskId + "> NOTIFY.....");
            this.notifyAll();   // I forgot now... what happens when .notify occurs
            // before getSum() is called.... ANSWER: if(!done) is skipped and sum is returned !
        }
    }

    public int getSum(){

        // If the work isn't done, wait
        // synchronized is used because wait()ing and return sum
        // cannot end until run() is finished
        if(!done){
            synchronized (this){
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting=========");
                    this.wait();    // Thread is set to wait() however I forget now if
                    // synchornized block BLOCKS another synchronized block....
                    // If that is so then how would the run() synchronized block execute
                    // notifyAll()...   **TODO** REVIEW SYNCHRONIZED
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("[" + Thread.currentThread().getName() + "] ====== WOKE UP for " + taskId + "....");
        }
        return sum;
    }
}
