package tut1.api.threads.scheduling;

import tuts.common.NamedThreadsFactory;
import tuts.common.ScheduledTaskB;
import tuts.utils.TimeUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


// COMPARE TO L47:
// Task is scheduled to run at DELAY FROM last task's +++FINISH+++ TIME
// Each execution is scheduled to run relative to the end of the last execution

// NOTE: Can only run Runnables

public class L51 {
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyy HH:mm:ss.SSS");
    public static void main(String[] args) throws Exception {

        //ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor(new NamedThreadsFactory());
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(3, new NamedThreadsFactory());

        System.out.println("Current time: " + dateFormatter.format(new Date()));

        //exec.scheduleWithFixedDelay(new ScheduledTaskB(1000), 4, 2, TimeUnit.SECONDS);
        ScheduledFuture<?> sf1 = exec.scheduleWithFixedDelay(new ScheduledTaskB(1000), 4, 2, TimeUnit.SECONDS);
        ScheduledFuture<?> sf2 = exec.scheduleWithFixedDelay(new ScheduledTaskB(1000), 4, 2, TimeUnit.SECONDS);


        sf2.cancel(true);






        // Loop every 3 seconds for the task's remaining execution time
//        for(int i =0; i<10; i++){
//            System.out.println("Next run of TASK-1 scheduled for approx: ");
//            /*
//                  ScheduleFuture .getDelay = DELAY in executor.scheduleWithFixedDelay(x,x, DELAY, x)
//             */
//            Date scheduledTime = TimeUtils.getFutureTime(new Date(), sf1.getDelay(TimeUnit.MILLISECONDS));
//            System.out.println(dateFormatter.format(scheduledTime));
//
//            TimeUnit.MILLISECONDS.sleep(3000);
//        }

        TimeUnit.MILLISECONDS.sleep(10000);
        exec.shutdown();
    }
}
