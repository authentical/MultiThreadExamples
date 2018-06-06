package tuts.common;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;


//
// Callable result is given to a Future<V>
//
//
//


public class CalculationTaskA implements Callable<Integer> {

    private int a, b;
    private long sleepTime;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;



    public CalculationTaskA(int a, int b, long sleepTime) {
        this.a = a;
        this.b=b;
        this.sleepTime = sleepTime;

        this.instanceNumber = ++count;
        this.taskId = "CalcTaskA-" + instanceNumber;
    }


    @Override
    public Integer call() {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("#### {"+currentThreadName +"] <"+ taskId + "> STARTING #####");
        System.out.println("[" + currentThreadName + "] <" +taskId + "> Sleeping for " + sleepTime + " ms");

        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("***** ["+currentThreadName +"] <" + taskId + "> DONE ******");

        return a + b;
    }
}
