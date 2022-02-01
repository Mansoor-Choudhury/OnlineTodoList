package OnlineTodo.TodoList.model;

import javax.persistence.*;

/**
 * Task class to persist the todo list in database
 * Hibernate ORM modeling done using task class
 */
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;
    private String taskName;
    private String updateDate;

    public Task(){}

    public Task(String taskName,String updateDate){
        this.taskName = taskName;
        this.updateDate = updateDate;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate){
        this.updateDate = updateDate;
    }
}