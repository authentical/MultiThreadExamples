package tuts.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class CalculationTaskC implements Callable<Long> {

    private static int count =0;
    private String taskId;

    private final int DATA_SET_SIZE = 1000000;

    private boolean isThreadInterrupted = false;

    // Constructor
    public CalculationTaskC(){
        this.taskId = "CalcTaskC-" + ++count;
    }


    // Non-blocking and handles interrupt
    @Override
    public Long call(){

        String currentThreadName = Thread.currentThread().getName();
        System.out.println("#### [" +currentThreadName + "] <" + taskId + "> STARTING ####");

        long totalWorkTimeMillis = 0;

        for(int i=1; i<1000; i++){
            System.out.println("["+ currentThreadName + "] <" + taskId + ">" + "Sort Set AVG RUN TIME PER SET(ms) "+
                    totalWorkTimeMillis/i);

            long workTimeMillis = doSomeWork();
            totalWorkTimeMillis+=workTimeMillis;

            //
            if(Thread.interrupted()){
                System.out.println("[" + currentThreadName + "] <" + taskId + "> Interrupted. Cancelling...");
                isThreadInterrupted = true;
                break;
            }
        }
        System.out.println("[" + currentThreadName + "] <" + taskId + "> INTERRUPTED status again: " +
                            Thread.interrupted());
        System.out.println(currentThreadName + " DONE");

        return isThreadInterrupted ? -1: totalWorkTimeMillis / 1000;
    }


    private long doSomeWork(){
        long startTime = System.currentTimeMillis();
        Collections.sort(generateDataSet());
        return System.currentTimeMillis() - startTime;
    }

    private List<Integer> generateDataSet(){
        List<Integer> intList = new ArrayList<>();

        Random random = new Random();

        for(int i=0; i< DATA_SET_SIZE; i++){
            intList.add(random.nextInt(DATA_SET_SIZE));
        }
        return intList;
    }
}
