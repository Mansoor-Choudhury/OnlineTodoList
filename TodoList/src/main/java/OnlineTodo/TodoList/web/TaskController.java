package OnlineTodo.TodoList.web;

import OnlineTodo.TodoList.model.Constant;
import OnlineTodo.TodoList.model.Task;
import OnlineTodo.TodoList.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * TaskController class to accept hhtp get and post request for fetching, deleting and adding tasks
 */
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("api/")
public class TaskController {

    @Autowired
    private TaskRepo taskRepo;

    /**
     * sets task repo value if null
     * used only for junit testing
     */
    private void setTaskRepoIfNull(){
        if(taskRepo == null){
            this.taskRepo = Constant.taskRepo;
        }
    }

    /**
     * Gets list of all tasks
     *
     * @return - task list
     */
    @GetMapping("tasks")
    public List<Task> getTaskList(){
        setTaskRepoIfNull();
        return taskRepo.findAll();
    }

    /**
     * Adds new task to Database
     * Gets called from the client or front end
     *
     * @param todoDesc - todo description
     * @return - http status
     */
    @PostMapping("addTodo")
    public ResponseEntity<String> addNewTodo(@RequestBody String todoDesc) {
        try {
            setTaskRepoIfNull();
            String todo = todoDesc.replaceAll("[+=]"," ");
            String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
            taskRepo.save(new Task(todo,timeStamp));
            return new ResponseEntity<>("Task "+ todoDesc+"added to DB", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes a todo from database when user wants to delete it
     *
     * @param taskId - task id
     * @return - http status
     */
    @PostMapping("deleteTodo")
    public ResponseEntity<String> deleteTodo(@RequestBody String taskId) {
        try {
            setTaskRepoIfNull();
            String id = taskId.replaceAll("[+=]","");
            Task task = taskRepo.getById(Long.valueOf(id));
            taskRepo.delete(task);
            return new ResponseEntity<>("Task "+ task.getTaskName()+"deleted from DB", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}