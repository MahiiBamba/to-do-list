package toDoList;

public class Task {
    private String deadLine;
    private String taskName;
    private Boolean isCompleted;

    public Task(String taskName, String deadLine){
        this.taskName = taskName;
        this.deadLine = deadLine;
        this.isCompleted = false;
    }

    public String getTaskName(){return taskName;}
    public Boolean getIsCompleted(){return isCompleted;}
    public void setIsCompleted(){this.isCompleted=true;}

    public String toString(){return (isCompleted?"[✓]":"[✗]") +" --- "+ taskName +" -- (Deadline "+deadLine+")";}
}
