package tuts.common;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialTaskB implements Callable<Long> {

    private static int count =0;
    private static int instanceNumber;
    private String taskId;

    private long a;         // operand
    private long factorial; // result
    private long sleepTime;


    // Constructor
    public FactorialTaskB(long a, long sleepTime ){
        this.instanceNumber = ++count;
        this.taskId = "FactorialTaskB" + instanceNumber;

        this.a = a;
        this.sleepTime = sleepTime;
    }

    // Blocks and handles interrupts
    @Override
    public Long call(){
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("#### [" +currentThreadName + "] <" + taskId + "> STARTING ####");


        factorial = 1L;

        // Calculation ////////////// Start
        for(long i=1; i<=a ; i++){

            factorial *= i;

        // Calculation ////////////// End
            System.out.println("["+ currentThreadName + "] <" + taskId + ">" + "Iteration-"+ i
            + ". Intermediate result = " + factorial);

            try{
                TimeUnit.MILLISECONDS.sleep(sleepTime); }
            catch(InterruptedException e){
                System.out.println(currentThreadName + " "+ taskId + " Sleep was interrupted. Cancelling...");
                factorial = -1L;
                break;
            }
        }

        return factorial;
    }


    // Recursive factorial
    private Long factorialStep(Long x){
        if(x<=0L){
            return 1L;
        }

        return x*factorialStep(x-1);
    }

}
