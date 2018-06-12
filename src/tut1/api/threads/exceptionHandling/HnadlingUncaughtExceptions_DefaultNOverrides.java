package tut1.api.threads.exceptionHandling;

import tuts.common.ExceptionLeakingTask;
import tuts.common.ThreadExceptionHandler;

public class HnadlingUncaughtExceptions_DefaultNOverrides {
    public static void main(String[] args) {


        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));

        Thread t1 = new Thread(new ExceptionLeakingTask(), "1");


        Thread t2 = new Thread(new ExceptionLeakingTask(), "2");
        t2.setUncaughtExceptionHandler(new ThreadExceptionHandler("Custom Handler 1"));

        Thread t3 = new Thread(new ExceptionLeakingTask(), "3");


        Thread t4 = new Thread(new ExceptionLeakingTask(), "4");
        t4.setUncaughtExceptionHandler(new ThreadExceptionHandler("Custom Handler 2"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
