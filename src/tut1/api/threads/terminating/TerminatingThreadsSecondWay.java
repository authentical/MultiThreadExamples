package tut1.api.threads.terminating;

import tuts.common.LoopTaskE;
import tuts.common.LoopTaskF;

import java.util.concurrent.TimeUnit;

public class TerminatingThreadsSecondWay {
    public static void main(String[] args) {


        LoopTaskF f1 = new LoopTaskF();
        LoopTaskF f2 = new LoopTaskF();
        LoopTaskF f3 = new LoopTaskF();

        Thread t1 = new Thread(f1);
        Thread t2 = new Thread(f2);
        Thread t3 = new Thread(f3);

        t1.start();
        t2.start();
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
