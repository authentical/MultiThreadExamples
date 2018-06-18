package tuts.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;


//
// Callable result is given to a Future<V>
//
//
//


public class CalculationTaskD implements Callable<Integer> {

    private int a, b;
    private long sleepTime;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;



    public CalculationTaskD(int a, int b, long sleepTime) {
        this.a = a;
        this.b=b;
        this.sleepTime = sleepTime;

        this.instanceNumber = ++count;
        this.taskId = "CalcTaskD-" + instanceNumber;
    }


    private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyy HH:mm:ss.SSS");

    @Override
    public Integer call() throws Exception{
        Date startTime = new Date();

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("#### {"+currentThreadName +"] <"+ taskId + "> STARTED @" +
                dateFormatter.format(startTime) +
                "\n");

        //System.out.println("[" + currentThreadName + "] <" +taskId + "> Sleeping for " + sleepTime + " ms");


        TimeUnit.MILLISECONDS.sleep(sleepTime);


        System.out.println("***** ["+currentThreadName +"] <" + taskId + "> FINISHED @: " +
                dateFormatter.format(new Date()) + "******\n");

        return a + b;
    }
}
