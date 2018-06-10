package tuts.common;

// This is a Bean


public class TaskResult<S, R> {

    private S taskId;
    private R result;


    public TaskResult(S taskId, R result){
        this.taskId = taskId;
        this.result = result;
    }


    public S getTaskId() {
        return taskId;
    }

    public R getResult() {
        return result;
    }


    @Override
    public String toString() {
        return "============TaskResult{" +
                "taskId=" + taskId +
                ", result=" + result +
                '}';
    }


    ///////////////////////////////////////////////////////////////////
    // Implement a way to tell the difference between objects
    //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        TaskResult<?, ?> that = (TaskResult<?, ?>) o;

        if (!taskId.equals(that.taskId)) return false;

        if(!result.equals(that.result)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = taskId.hashCode();
        result1 = 31 * result1 + result.hashCode();
        return result1;
    }
}
