package tuts.common;


public class ThreadExceptionHandler implements Thread.UncaughtExceptionHandler {


    public String handlerId;


    public ThreadExceptionHandler(){}

    public ThreadExceptionHandler(String handlerId) {
        this.handlerId = handlerId;
    }


    @Override
    public void uncaughtException(Thread thread, Throwable exception) {
        System.out.println(this +
                        " caught Exception in Thread - \"" +
                        thread.getName() +
                        "\" => " + exception);
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "@" + this.hashCode() +
                (handlerId == null || "".equals(handlerId) ? "" : "(\"" + handlerId + "\")");
                    // There must be a clearer way of doing this
    }
}
