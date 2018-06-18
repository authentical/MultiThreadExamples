package tut1.api.threads.scheduling;

import tuts.common.CalculationTaskD;
import tuts.common.NamedThreadsFactory;
import tuts.common.ScheduledTaskA;
import tuts.common.ScheduledTaskB;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class L49 {
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyy HH:mm:ss.SSS");
    public static void main(String[] args) throws Exception {

        // RUN ////////////////////////////////////////////////////////////////////
        //ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor(); // 1 thread
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(3);// 3 threads

        System.out.println("TIME: " + dateFormatter.format(new Date()));


        ScheduledFuture<?> sf1 = exec.schedule(new ScheduledTaskB(3000), 4,TimeUnit.SECONDS); // TASK-1
        ScheduledFuture<?> sf2 = exec.schedule(new CalculationTaskD(0,3,3000), 6, TimeUnit.SECONDS); // TASK-2

        exec.schedule(new ScheduledTaskB(0), 8, TimeUnit.SECONDS);
        ScheduledFuture<?> sf4 = exec.schedule(new CalculationTaskD(3,4,0), 10 , TimeUnit.SECONDS); // TASK-4

        exec.shutdown();
        sf1.cancel(true);
        sf2.cancel(true);

        // GET RESULTS ////////////////////////////////////////////////////////////

        System.out.println("\n\n\nGetting results: ");

            /*
                    .get() blocks until result is available
            */
        System.out.println("TASK-1: " + sf1.get() + "\n");
        System.out.println("TASK-2: " + sf2.get() + "\n");
        System.out.println("TASK-4: " + sf4.get() + "\n");





    }
}
