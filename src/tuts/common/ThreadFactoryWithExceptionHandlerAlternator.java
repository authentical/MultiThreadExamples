package tuts.common;

public class ThreadFactoryWithExceptionHandlerAlternator extends NamedThreadsFactory {


    private int count =0;

    @Override
    public Thread newThread(Runnable r) {

        int sequenceNumber = ++ count;

        Thread t = super.newThread(r);

        if(sequenceNumber % 2 ==0){
            t.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        }

        return t;
    }
}
