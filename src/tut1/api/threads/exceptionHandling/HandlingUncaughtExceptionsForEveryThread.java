package tut1.api.threads.exceptionHandling;

import tuts.common.ExceptionLeakingTask;
import tuts.common.ThreadExceptionHandler;

public class HandlingUncaughtExceptionsForEveryThread {
    public static void main(String[] args) {


        // Set default exception handler  for all threads in the application
        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));


        new Thread(new ExceptionLeakingTask(), "1").start();
        new Thread(new ExceptionLeakingTask(), "2").start();

    }
}
