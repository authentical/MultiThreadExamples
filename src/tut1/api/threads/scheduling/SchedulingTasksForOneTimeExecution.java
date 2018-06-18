package tut1.api.threads.scheduling;

import tuts.common.ScheduledTaskA;
import tuts.utils.TimeUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class SchedulingTasksForOneTimeExecution {

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyy HH:mm:ss.SSS");

    public static void main(String[] args) throws InterruptedException {

        // If you run Timer as a USER THREAD, it may take a long time to terminate
        Timer timer = new Timer("Timer-Thread", true); // Daemon mode

        // Set up scheduleTime and currentTime
        // and Print currentTime
        Date currentTime= new Date();
        Date scheduledTime = TimeUtils.getFutureTime(currentTime, 5000);
        System.out.println("Curent time: " + dateFormatter.format(currentTime));



        // Run scheduled task1 at scheduledTime
        // Print scheduledTime AS CALCULATED and WITHOUT querying task
        timer.schedule(new ScheduledTaskA(8000), scheduledTime);
        System.out.println("Task-1 scheduled for " + dateFormatter.format(scheduledTime));



        // Run scheduled task2 in delayms1 milliseconds from now
        long delayms1 = 1000;
        ScheduledTaskA task2 = new ScheduledTaskA(4000);

        timer.schedule(task2, delayms1);
        System.out.println("Task-2 scheduled for " +
                dateFormatter.format(new Date(task2.scheduledExecutionTime())));



        // Run scheduled task3 in delayms2 milliseconds from now
        long delayms2 = 12000;
        ScheduledTaskA task3 = new ScheduledTaskA(0);

        timer.schedule(task3, delayms2);
        System.out.println("Task-3 scheduled for " +
                dateFormatter.format(new Date(task3.scheduledExecutionTime())));



        // Run scheduled task4 at scheduledTime2
        // Print scheduledTime BY QUERYING task (could be more accurate!)
        Date scheduledTime2 = TimeUtils.getFutureTime(currentTime, 3000);
        ScheduledTaskA task4 = new ScheduledTaskA(0);

        timer.schedule(task4, scheduledTime2);
        System.out.println("Task-4 scheduled for " +
                dateFormatter.format(new Date(task4.scheduledExecutionTime())));
        task4.cancel();




        TimeUnit.MILLISECONDS.sleep(14000);
        System.out.println("Cancelling timer...................");
        timer.cancel();


    }
}
