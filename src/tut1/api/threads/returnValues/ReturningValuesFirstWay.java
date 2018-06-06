package tut1.api.threads.returnValues;

import tuts.common.ValueReturningClassA;

public class ReturningValuesFirstWay {

    public static void main(String[] args) {


        ValueReturningClassA task1 = new ValueReturningClassA(2,3,2000);
        Thread t1 = new Thread(task1, "Thread-1");
        ValueReturningClassA task2 = new ValueReturningClassA(3,4,1000);
        Thread t2 = new Thread(task2, "Thread-2");
        ValueReturningClassA task3 = new ValueReturningClassA(4,5,500);
        Thread t3 = new Thread(task3, "Thread-3");


        t1.start();
        t2.start();
        t3.start();

        System.out.println("Result-1 = " + task1.getSum());
        System.out.println("Result-2 = " + task2.getSum());
        System.out.println("Result-3 = " + task3.getSum());
    }



}
