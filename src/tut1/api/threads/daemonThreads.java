package tut1.api.threads;

import tuts.common.LoopTaskD;

public class daemonThreads {

    public static void main(String[] args) {

        Thread t1 = new Thread(new LoopTaskD(500), "Thread-1");
        Thread t2 = new Thread(new LoopTaskD(1000), "Thread-2");

   
        t2.setDaemon(true); // AS soon as the USER thread is finished
                            // the JVM will kill the DAEMON, and it may not finish it's job

        t1.start();
        t2.start();

    }
}
