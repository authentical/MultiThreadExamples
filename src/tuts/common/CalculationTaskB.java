package tuts.common;

import javafx.concurrent.Task;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;


//
// Callable result is given to a Future<V>
//
//
//


public class CalculationTaskB implements Callable<TaskResult<String, Integer>> {

    private int a, b;
    private long sleepTime;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;



    public CalculationTaskB(int a, int b, long sleepTime) {
        this.a = a;
        this.b=b;
        this.sleepTime = sleepTime;

        this.instanceNumber = ++count;
        this.taskId = "CalcTaskB-" + instanceNumber;
    }


    // Sleeps, blocks and does not handle interrupt
    @Override
    public TaskResult<String,Integer> call() {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("#### {"+currentThreadName +"] <"+ taskId + "> STARTING #####");
        System.out.println("[" + currentThreadName + "] <" +taskId + "> Sleeping for " + sleepTime + " ms");

        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("***** ["+currentThreadName +"] <" + taskId + "> DONE ******");

        return new TaskResult<String, Integer>(taskId, a+b);
    }
}
