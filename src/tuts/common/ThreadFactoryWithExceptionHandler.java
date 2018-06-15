package tuts.common;

public class ThreadFactoryWithExceptionHandler extends NamedThreadsFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = super.newThread(r);

        thread.setUncaughtExceptionHandler(new ThreadExceptionHandler());

        return thread;
    }

}
