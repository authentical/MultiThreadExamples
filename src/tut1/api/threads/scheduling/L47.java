package tut1.api.threads.scheduling;

import tuts.common.ScheduledTaskA;
import tuts.utils.TimeUtils;

// Repeated FIXED DELAY executions with Timer, TimerTask

// NOTE: Start times drift as some executions will start a little later
// and that will cascade

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

// COMPARE TO L51:
// Task is scheduled to run at DELAY FROM last task's +++START+++ TIME


public class L47 {

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyy HH:mm:ss.SSS");

    public static void main(String[] args) throws InterruptedException {

        Timer timer = new Timer("Timer-Thread", true);
        Date currentTime = new Date();
        Date scheduledTime = TimeUtils.getFutureTime(currentTime, 0);


        long intervalms = 2000;
        timer.schedule(new ScheduledTaskA(1000), scheduledTime, intervalms);

        long delayms = 4000;
        long interval2 = 2000;
        timer.schedule(new ScheduledTaskA(4000), delayms, interval2);


        TimeUnit.MILLISECONDS.sleep(10000);
        timer.cancel();
    }
}
