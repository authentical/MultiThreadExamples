package tut1.api.threads.terminating;

import tuts.common.LoopTaskE;

import java.util.concurrent.TimeUnit;

public class TerminatingThreadsFirstWay {
    public static void main(String[] args) {

        LoopTaskE e = new LoopTaskE();

        new Thread(e, "Bleep").start();

        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        e.cancel();



    }
}
