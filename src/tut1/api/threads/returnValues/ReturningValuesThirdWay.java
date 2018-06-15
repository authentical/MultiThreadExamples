package tut1.api.threads.returnValues;

//
// "Blocking way" to return a value from a Runnable
//
//
//

import tuts.common.ValueReturningClassC;

public class ReturningValuesThirdWay {

    public static void main(String[] args) throws InterruptedException {


        ValueReturningClassC task1 = new ValueReturningClassC(2,3,20);
        Thread t1 = new Thread(task1, "Thread-1");
        ValueReturningClassC task2 = new ValueReturningClassC(3,4,500);
        Thread t2 = new Thread(task2, "Thread-2");
        ValueReturningClassC task3 = new ValueReturningClassC(4,5,1000);
        Thread t3 = new Thread(task3, "Thread-3");


        t1.start();
        t2.start();
        t3.start();

        t1.join();
        System.out.println("Result-1 = " + task1.getSum());
        t2.join();
        System.out.println("Result-2 = " + task2.getSum());
        t3.join();
        System.out.println("Result-3 = " + task3.getSum());



    }



}
