package tuts.common;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ScheduledTaskA extends TimerTask {

    private long sleepTime;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;



    public ScheduledTaskA(long sleepTime) {

            this.sleepTime = sleepTime;

            this.instanceNumber = ++count;
            this.taskId = "SchedTaskA-" + instanceNumber;
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


        //System.out.println(DONE);
    }
}
