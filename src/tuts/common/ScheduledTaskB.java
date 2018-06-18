package tuts.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ScheduledTaskB implements Runnable {

    private long sleepTime;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;



    public ScheduledTaskB(long sleepTime) {

            this.sleepTime = sleepTime;

            this.instanceNumber = ++count;
            this.taskId = "SchedTaskB-" + instanceNumber;
    }


    private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyy HH:mm:ss.SSS");

    @Override
    public void run() {
        Date startTime = new Date();
        Date scheduleForRunningTime = new Date();

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("#### {"+currentThreadName +"] <"+ taskId + "> STARTING @" +
                                    dateFormatter.format(startTime) +
                "\n");


        //System.out.println("[" + currentThreadName + "] <" +taskId + "> Sleeping for " + sleepTime + " ms");

        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("[" + currentThreadName + "] <"+taskId+"> FINISHED @" +
        dateFormatter.format(new Date()) + " *****\n");
    }
}
