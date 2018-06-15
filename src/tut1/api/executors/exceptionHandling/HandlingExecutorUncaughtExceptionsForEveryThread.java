package tut1.api.executors.exceptionHandling;

import tuts.common.ExceptionLeakingTask;
import tuts.common.ThreadExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandlingExecutorUncaughtExceptionsForEveryThread {
    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT HANDLER"));

        ExecutorService exec1 = Executors.newCachedThreadPool();
        exec1.execute(new ExceptionLeakingTask());
        exec1.execute(new ExceptionLeakingTask());
        exec1.execute(new ExceptionLeakingTask());

        ExecutorService exec2 = Executors.newCachedThreadPool();
        exec2.execute(new ExceptionLeakingTask());
        exec2.execute(new ExceptionLeakingTask());
        exec2.execute(new ExceptionLeakingTask());


        exec1.shutdown();
        exec2.shutdown();
    }
}
