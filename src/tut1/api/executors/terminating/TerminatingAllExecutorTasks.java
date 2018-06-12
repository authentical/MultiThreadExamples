package tut1.api.executors.terminating;

import tuts.common.*;

import java.util.concurrent.*;

public class TerminatingAllExecutorTasks {
    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool(new NamedThreadsFactory());

        LoopTaskA t1 = new LoopTaskA();
        LoopTaskF t2 = new LoopTaskF();
        FactorialTaskB t3 = new FactorialTaskB(30,500);
        CalculationTaskC t4 = new CalculationTaskC();
        CalculationTaskB t5 = new CalculationTaskB(2,3,9000);

        // NOTE: Usage of Future here!

        exec.execute(t1);
        exec.execute(t2);
        Future<Long> t3Future = exec.submit(t3);  // <---------------
        Future<Long> t4Future = exec.submit(t4);  // <-----------------------
        Future<TaskResult<String, Integer>> t5Future = exec.submit(t5); // <-------



        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        exec.shutdownNow();

        try {
            System.out.println("\nALL THREADS terminated. " +
                    exec.awaitTermination(5000, TimeUnit.MILLISECONDS) + "\n");

        }catch(InterruptedException e){e.printStackTrace();}

        // Get() results if available from our Future tasks
        try {
            System.out.println("FactTaskB returned: " + t3Future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("CalcTaskB returned: " + t5Future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("CalcTaskB returned: **ERROR** CalcTaskB got ExecutionException");
            e.getCause().printStackTrace();
        }
        try {
            System.out.print("CalcTaskC returned: " + t4Future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
