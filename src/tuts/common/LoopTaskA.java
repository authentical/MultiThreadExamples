package tuts.common;

import tut1.api.threads.running.First;

import java.util.concurrent.TimeUnit;

public class LoopTaskA implements Runnable{

        private static int count =0;
        private int id;


        // Blocking and does not handle interrupts
        @Override
        public void run(){
            System.out.println("#### <TASK-" + id + "> STARTING ####");

            for(int i=10; i>0; i--){
                System.out.println("<TASK-"+ id + ">" + "TICK TICK "+ i);
                try{
                    TimeUnit.MILLISECONDS.sleep(500);}
                catch(InterruptedException e){e.printStackTrace();}
            }

            System.out.println("#### <TASK-" + id + "> DONE ####");
        }

        // Constructor
        public LoopTaskA(){
            this.id= ++count;

        }

}
