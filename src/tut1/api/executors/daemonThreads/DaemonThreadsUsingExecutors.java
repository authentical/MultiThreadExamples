package tut1.api.executors.daemonThreads;

import tuts.common.DaemonThreadsFactory;
import tuts.common.LoopTaskD;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DaemonThreadsUsingExecutors {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadsFactory());

        exec.submit(new LoopTaskD(1000));
        exec.submit(new LoopTaskD(2000));
        exec.submit(new LoopTaskD(1000));
        exec.submit(new LoopTaskD(5000));


        exec.shutdown();

    }
}
