package tuts.common;

import java.util.concurrent.TimeUnit;

public class ValueReturningClassB implements Runnable {

    private int a, b, sum;
    private long sleepTime;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private ResultListener<Integer> listener;

    public ValueReturningClassB(int a, int b, long sleepTime, ResultListener<Integer> listener) {
        this.a = a;
        this.b=b;
        this.sleepTime = sleepTime;

        this.instanceNumber = ++count;
        this.taskId = "ValReturnTaskB-" + instanceNumber;

        this.listener = listener;
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

        listener.notifyResult(sum);
    }
}
