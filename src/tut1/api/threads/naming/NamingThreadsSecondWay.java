package tut1.api.threads.naming;

import tuts.common.LoopTaskC;

import java.util.concurrent.TimeUnit;

public class NamingThreadsSecondWay {
    public static void main(String[] args) {

        String currentThreadName = Thread.currentThread().getName();


        System.out.println("[" + currentThreadName + "] Main start");

        new Thread(new LoopTaskC(), "MyThread-1").start();

        Thread  t = new Thread(new LoopTaskC());
        t.setName("BOOP");  // Defined in class instantiation! Can't change name!
        t.start();

        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.setName("BOPSSS");

        System.out.println("[" + currentThreadName + "] Main END");

    }

}
