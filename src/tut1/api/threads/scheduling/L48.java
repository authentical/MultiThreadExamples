package tut1.api.threads.scheduling;

import tuts.common.ScheduledTaskA;
import tuts.utils.TimeUtils;

// Repeated FIXED RATE executions with Timer, TimerTask

// NOTE: Start times do not drift.... YEAH THEY DO, If the thread is in use...they go way off
// Good for maintenance tasks and interval alarms


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class L48 {

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyy HH:mm:ss.SSS");

    public static void main(String[] args) throws InterruptedException {

        Timer timer = new Timer("Timer-Thread", true);
        Date currentTime = new Date();
        Date scheduledTime = TimeUtils.getFutureTime(currentTime, 0);


        long intervalms = 2000;
        timer.scheduleAtFixedRate(new ScheduledTaskA(1000), scheduledTime, intervalms);

        long delayms = 2000;
        long interval2 = 2000;
        timer.scheduleAtFixedRate(new ScheduledTaskA(4000), delayms, interval2);


        TimeUnit.MILLISECONDS.sleep(10000);
        timer.cancel();
    }
}
