package OnlineTodo.TodoList;

import OnlineTodo.TodoList.model.Constant;
import OnlineTodo.TodoList.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import OnlineTodo.TodoList.repository.TaskRepo;

/**
 * Todolist application class to start spring boot and H2 database
 */
@SpringBootApplication
public class TodoListApplication{

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}
}