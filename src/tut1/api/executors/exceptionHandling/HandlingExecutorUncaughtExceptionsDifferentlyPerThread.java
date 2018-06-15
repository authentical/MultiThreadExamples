package tut1.api.executors.exceptionHandling;

import tuts.common.ExceptionLeakingTask;
import tuts.common.ThreadFactoryWithExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandlingExecutorUncaughtExceptionsDifferentlyPerThread {
    public static void main(String[] args) {


        ExecutorService exec = Executors.newCachedThreadPool(new ThreadFactoryWithExceptionHandler());

        exec.execute(new ExceptionLeakingTask());
        exec.execute(new ExceptionLeakingTask());
        exec.execute(new ExceptionLeakingTask());
        exec.execute(new ExceptionLeakingTask());

        exec.shutdown();
    }
}
