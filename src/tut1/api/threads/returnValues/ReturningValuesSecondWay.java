package tut1.api.threads.returnValues;


//
// "Non-blocking way" with Callback object to return a value from a Runnable
//
//
//

import tuts.common.ValueReturningClassB;

public class ReturningValuesSecondWay {

    public static void main(String[] args) {


        ValueReturningClassB task1 = new ValueReturningClassB(2,3,2000,
                new SumObserver("task-1"));
        Thread t1 = new Thread(task1, "Thread-1");
        ValueReturningClassB task2 = new ValueReturningClassB(3,4,1000,
                new SumObserver("task-2"));
        Thread t2 = new Thread(task2, "Thread-2");
        ValueReturningClassB task3 = new ValueReturningClassB(4,5,500,
                new SumObserver("task-3"));
        Thread t3 = new Thread(task3, "Thread-3");


        t1.start();
        t2.start();
        t3.start();


    }



}
