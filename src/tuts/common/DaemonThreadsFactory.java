package tuts.common;

public class DaemonThreadsFactory extends NamedThreadsFactory {

    private static int count =0;



    @Override
    public Thread newThread(Runnable r) {
        Thread thread = super.newThread(r);

        count++;

        if(count % 2 ==0){
            thread.setDaemon(true);
        }

        return thread;
    }
}
