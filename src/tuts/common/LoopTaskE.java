package tuts.common;

import java.util.concurrent.TimeUnit;

public class LoopTaskE implements Runnable{

    private static int count =0;
    private int instanceNumber;
    private String taskId;

    //Tell JVM not to apply optimizations to this variabele
    private volatile boolean shutdown = false;


    // Constructor
    public LoopTaskE(){
        this.taskId = "LoopTaskE" + ++count;
    }

    @Override
    public void run(){
        Thread.currentThread().setName("Super Thread-" + instanceNumber);

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("#### [" +currentThreadName + "] <" + taskId + "> STARTING ####");

        for(int i=1; ; i++){
            System.out.println("["+ currentThreadName + "] <" + taskId + ">" + "TICK TICK "+ i);
            try{
                TimeUnit.MILLISECONDS.sleep(1000);}
            catch(InterruptedException e){}

            // READ shutdown - Make sure the object can only read XOR write the variable
            //
            synchronized (this){
                if(shutdown) {
                    break;
                }
            }
        }
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
}
