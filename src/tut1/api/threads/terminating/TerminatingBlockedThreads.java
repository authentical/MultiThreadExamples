package tut1.api.threads.terminating;


import tuts.common.LoopTaskG;

import java.util.concurrent.TimeUnit;

public class TerminatingBlockedThreads {

        public static void main(String[] args) {


            LoopTaskG f1 = new LoopTaskG();
            LoopTaskG f2 = new LoopTaskG();
            LoopTaskG f3 = new LoopTaskG();

            Thread t1 = new Thread(f1);
            t1.start();
            Thread t2 = new Thread(f2);
            t2.start();
            Thread t3 = new Thread(f3);
            t3.start();


            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println("Sending interrupt to " + t1.getName());
            t1.interrupt();
            System.out.println("Sending interrupt to " + t2.getName());
            t2.interrupt();
            System.out.println("Sending interrupt to " + t3.getName());
            t3.interrupt();


        }
}
