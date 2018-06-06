package tut1.api.threads.returnValues;

//
// Each Worker (runnable) need's it's own instance of SumObserver
// because it notifies just ONE worker
//
//



import tuts.common.ResultListener;

public class SumObserver implements ResultListener<Integer>{

    private String taskId;

    public SumObserver(String taskId){
        this.taskId = taskId;
    }

    @Override
    public void notifyResult(Integer result) {
        System.out.println("Result for " + taskId + " = " + result);
    }
}
