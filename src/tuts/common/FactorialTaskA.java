package tuts.common;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialTaskA implements Callable<Long> {

    private static int count =0;
    private static int instanceNumber;
    private String taskId;

    private long a;         // operand
    private long factorial; // result
    private long sleepTime;

    //Tell JVM not to apply optimizations to this variabele
    private volatile boolean shutdown = false;


    // Constructor
    public FactorialTaskA(long a, long sleepTime ){
        this.instanceNumber = ++count;
        this.taskId = "FactorialTaskA" + instanceNumber;

        this.a = a;
        this.sleepTime = sleepTime;
    }

    @Override
    public Long call(){
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("#### [" +currentThreadName + "] <" + taskId + "> STARTING ####");


        factorial = 1L;

        // Calculation ////////////// Start
        for(int i=1; i<=a ; i++){

            factorial *= i;

        // Calculation ////////////// End
            System.out.println("["+ currentThreadName + "] <" + taskId + ">" + "Iteration-"+ i
            + ". Intermediate result = " + factorial);

            try{
                TimeUnit.MILLISECONDS.sleep(sleepTime); }
            catch(InterruptedException e){}

            // READ shutdown - Make sure the object can only read XOR write the variable
            //
            synchronized (this){
                if(shutdown) {
                    factorial = -1L;    // Factorial calculation not finished
                    break;
                }
            }
        }

        return factorial;
    }

    // A method that can be called from another class to shut this class
    // down mid-way
    public void cancel(){
        System.out.println(Thread.currentThread().getName() + " "+ taskId + " Shutting down *****");

        // WRITE shutdown - - Make sure the object can only read XOR write the variable
        synchronized (this){
            this.shutdown = true;
        }
    }

    // Recursive factorial
    private Long factorialStep(Long x){
        if(x<=0L){
            return 1L;
        }

        return x*factorialStep(x-1);
    }

}
