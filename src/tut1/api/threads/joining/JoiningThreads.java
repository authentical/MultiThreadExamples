package tut1.api.threads.joining;

import tuts.common.LoopTaskD;

public class JoiningThreads {
    public static void main(String[] args) throws InterruptedException {



        Thread t1 = new Thread(new LoopTaskD(100), "1");
        Thread t2 = new Thread(new LoopTaskD(200), "2");
        Thread t3 = new Thread(new LoopTaskD(500), "3");
        Thread t4 = new Thread(new LoopTaskD(400), "4");


        t1.start();
        t2.start();
        t3.start();
        t4.start();


        t1.join();
        System.out.println("[JOINED]     " + t1.getName() + " to main");

        t2.join();
        System.out.println("[JOINED]     " + t2.getName() + " to main");

        t3.join();
        System.out.println("[JOINED]     " + t3.getName() + " to main");

        t4.join();
        System.out.println("[JOINED]     " + t4.getName() + " to main");



    }
}
