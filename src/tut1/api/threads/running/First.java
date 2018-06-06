package tut1.api.threads.running;

import java.util.concurrent.TimeUnit;

public class First {

    public static int count=0;

    public static void main(String[] args) {
        Thread.currentThread().setName("X_MAIN_X");

        System.out.println("Main thread start " + Thread.currentThread().getName());

        // This is called:
        // Capture the thread reference with t
        Thread t = new FirstTask();
        t.setName("1");

        //
        new SecondTask().start();

        new ThirdTask();

        new Thread(new FourthTask()).start();

        // Provide an INLINE task to the Thread object
        // This method is often used to handle UI events
        Thread anon = new Thread(new Runnable() {
            @Override
            public void run(){
                for(int i=10; i>0; i--){
                    System.out.println("<NO-ID>" + "TICK TICK "+ i + "\t\t"+Thread.currentThread().getName());
                    try{TimeUnit.MILLISECONDS.sleep(200);}
                    catch(InterruptedException e){}
                }
            }
        });
        anon.start();


        System.out.println("Main thread ended " + Thread.currentThread().getName());
    }
}


class FirstTask extends Thread {

    private int id;

    @Override
    public void run(){
        for(int i=10; i>0; i--){
            System.out.println("<"+ id + ">" + "TICK TICK "+ i + "\t\t"+Thread.currentThread().getName());
            try{TimeUnit.MILLISECONDS.sleep(200);}
            catch(InterruptedException e){}
        }
    }

    // Constructor - As soon as in instance is created, the start method is called, so
    // thread is called immediately
    public FirstTask(){
        this.id= ++First.count;   // Every time new instance is created
                            // the count is inc'd and thus it's ID is recorded
                            // Of course count should be static so
                            // each instance does not just start at 0
        this.start();
    }
}

class SecondTask extends Thread {

    private int id;

    @Override
    public void run(){
        for(int i=10; i>0; i--){
            System.out.println("<"+ id + ">" + "TICK TICK "+ i + "\t\t"+Thread.currentThread().getName());
            try{TimeUnit.MILLISECONDS.sleep(200);}
            catch(InterruptedException e){}
        }
    }

    // Constructor
    public SecondTask(){
        this.id= ++First.count;

    }
}

// Once you start this up you don't have as much control as when extending Thread
class ThirdTask implements Runnable {

    private int id;
    private Thread thread;

    @Override
    public void run(){
        for(int i=10; i>0; i--){
            System.out.println("<"+ id + ">" + "TICK TICK "+ i + "\t\t"+Thread.currentThread().getName());
            try{TimeUnit.MILLISECONDS.sleep(200);}
            catch(InterruptedException e){}
        }
    }

    // Constructor
    public ThirdTask(){
        thread = new Thread(this);
        thread.setName("3");
        thread.start();
        this.id= ++First.count;

    }
}

class FourthTask implements Runnable {

    private int id;
    private Thread thread;

    @Override
    public void run(){
        for(int i=10; i>0; i--){
            System.out.println("<"+ id + ">" + "TICK TICK "+ i + "\t\t"+Thread.currentThread().getName());
            try{TimeUnit.MILLISECONDS.sleep(200);}
            catch(InterruptedException e){}
        }
    }

    // Constructor
    public FourthTask(){
        this.id= ++First.count;

    }
}