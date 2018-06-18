package tut1.api.threads.scheduling;



// Schedule times should not drift forward
// Each execution is scheudles relative to the scheudle start time of the first execution

// NOTE: Can only run Runnables

import tuts.common.NamedThreadsFactory;
import tuts.common.ScheduledTaskB;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class L53 {

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yy HH:mm:ss.SSS");
    public static void main(String[] args) throws Exception {

        System.out.println("Current time: " + dateFormatter.format(new Date()));

        ScheduledExecutorService exec = Executors.newScheduledThreadPool(3, new NamedThreadsFactory());
        ScheduledFuture<?> sf1 = exec.scheduleAtFixedRate(new ScheduledTaskB(1000), 4,2, TimeUnit.SECONDS);
        ScheduledFuture<?> sf2 = exec.scheduleAtFixedRate(new ScheduledTaskB(3000), 4,2, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(10000);
        exec.shutdown();
    }
}
