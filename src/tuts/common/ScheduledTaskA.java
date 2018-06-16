package tuts.common;

import java.text.SimpleDateFormat;
import java.util.Date;
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


    private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyy HH:mm:ss.SSS");

    @Override
    public void run() {
        Date startTime = new Date();
        Date scheduleForRunningTime = new Date(super.scheduledExecutionTime());

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("#### {"+currentThreadName +"] <"+ taskId + "> STARTING @" +
                                    dateFormatter.format(startTime) +
                "\nWas scheduled for: " + dateFormatter.format(scheduleForRunningTime));


        System.out.println("[" + currentThreadName + "] <" +taskId + "> Sleeping for " + sleepTime + " ms");

        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("[" + currentThreadName + "] <"+taskId+"> DONE @" +
        dateFormatter.format(new Date()) + " *****\n");
    }
}
