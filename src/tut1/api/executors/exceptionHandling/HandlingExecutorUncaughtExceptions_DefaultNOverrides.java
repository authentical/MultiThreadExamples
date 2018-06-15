package tut1.api.executors.exceptionHandling;

import tuts.common.ExceptionLeakingTask;
import tuts.common.ThreadExceptionHandler;
import tuts.common.ThreadFactoryWithExceptionHandlerAlternator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandlingExecutorUncaughtExceptions_DefaultNOverrides {

    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT"));

        ExecutorService exec = Executors.newCachedThreadPool(new ThreadFactoryWithExceptionHandlerAlternator());

        exec.execute(new ExceptionLeakingTask());
        exec.execute(new ExceptionLeakingTask());
        exec.execute(new ExceptionLeakingTask());
        exec.execute(new ExceptionLeakingTask());

        exec.shutdown();
    }
}
