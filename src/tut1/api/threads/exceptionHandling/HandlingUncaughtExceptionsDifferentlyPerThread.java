package tut1.api.threads.exceptionHandling;

import tuts.common.ExceptionLeakingTask;
import tuts.common.ThreadExceptionHandler;

public class HandlingUncaughtExceptionsDifferentlyPerThread {
    public static void main(String[] args) {

        Thread t1 = new Thread(new ExceptionLeakingTask(), "1");
        t1.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        Thread t2 = new Thread(new ExceptionLeakingTask(), "2");
        t2.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        Thread t3 = new Thread(new ExceptionLeakingTask(), "3");
        t3.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        Thread t4 = new Thread(new ExceptionLeakingTask(), "4");
        t4.setUncaughtExceptionHandler(new ThreadExceptionHandler());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
