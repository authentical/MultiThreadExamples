package tuts.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LoopTaskF implements Runnable{

    private static int count =0;
    private int instanceNumber;
    private String taskId;

    private final int DATA_SET_SIZE = 1000000;

    // Constructor
    public LoopTaskF(){
        this.taskId = "LoopTaskF" + ++count;
    }

    @Override
    public void run(){

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("#### [" +currentThreadName + "] <" + taskId + "> STARTING ####");

        for(int i=1; ; i++){
            System.out.println("["+ currentThreadName + "] <" + taskId + ">" + "TICK TICK "+ i);

            doSomeWork();

            //
            if(Thread.interrupted()){
                System.out.println("[" + currentThreadName + "] <" + taskId + "> Interrupted. Cancelling...");
                break;
            }
        }
        System.out.println("[" + currentThreadName + "] <" + taskId + "> INTERRUPTED status again: " +
                            Thread.interrupted());
        System.out.println(currentThreadName + " DONE");
    }


    private void doSomeWork(){

        Collections.sort(generateDataSet());

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
