package OnlineTodo.TodoList;

import OnlineTodo.TodoList.model.Constant;
import OnlineTodo.TodoList.model.Task;
import OnlineTodo.TodoList.repository.TaskRepo;
import OnlineTodo.TodoList.web.TaskController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

/**
 * Junit test class for testing the task controller class
 */
@SpringBootTest
class TodoListApplicationTests {

	@Autowired
	private TaskRepo taskRepo;
	private static TaskController taskController = new TaskController();

	/**
	 * checks for getTaskList method is working fine. Adds new task and checks entry is successfully done in database
	 */
	@Test
	void validateTaskList() {
		Constant.taskRepo = taskRepo;
		int previous = taskController.getTaskList().size();
		Task task = new Task("Wake up and clean","09-01-2022");
		taskRepo.save(task);
		assert (taskController.getTaskList().size() > previous);
	}

	/**
	 * Checks if addTodo method works fine. Adds new record and checks in database for entry
	 */
	@Test
	void validateAddNewTodo() {
		int previous = taskController.getTaskList().size();
		ResponseEntity<String> response = taskController.addNewTodo("Add field to text");
		assert (response.getStatusCode().getReasonPhrase().contains("Created"));
		assert (taskController.getTaskList().size() > previous);
	}

	/**
	 * Validates if deleteTodo method is working correctly. Deletes a record and validate with database
	 */
	@Test
	void validateDeleteTodo() {
		int previous = taskController.getTaskList().size();
		taskRepo.delete(taskController.getTaskList().get(0));
		assert (taskController.getTaskList().size() < previous);
	}
}