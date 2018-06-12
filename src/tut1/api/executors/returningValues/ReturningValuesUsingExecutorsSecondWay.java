package tut1.api.executors.returningValues;

import tuts.common.*;

import java.util.concurrent.*;

/*

CompletionService is used to push Callable Tasks into a pool
They are executed and results can be gotten via:

take().get()  which blocks if no task is finished and ready to give a result
poll().get() which doesn't block and returns null if not task is ready to  give a result

However, when you submit a Callable like this, it's identification is unknown.

*/

public class ReturningValuesUsingExecutorsSecondWay {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool(new NamedThreadsFactory());

        // It's like a thread monitor
        CompletionService<TaskResult<String, Integer>> tasks =
                new ExecutorCompletionService<TaskResult<String, Integer>>(exec);

        tasks.submit(new CalculationTaskB(2,3,2000));
        tasks.submit(new CalculationTaskB(5,3,1000));
        tasks.submit(new CalculationTaskB(12,3,500));

        tasks.submit(new LoopTaskA(), new TaskResult<String, Integer>("LoopTaskA-1", 999));


        exec.shutdown();

        for(int i =0; i< 4; i++){
            try {
                /*
                        Can use non-blocking .poll() to get results but
                        it returns null if there is no result available/ready

                 */
                System.out.println(tasks.take().get()); // <----------- .poll / .take


            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
