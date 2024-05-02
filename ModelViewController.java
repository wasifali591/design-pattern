
/**The Model-View-Controller (MVC) pattern is a widely used architectural pattern for developing user interfaces.
 * In the context of Spring Boot, MVC is commonly used for building web applications.
 * 
 * @author wasif
 * @version 1.0
 * @since 02/05/2024
 */

import java.util.ArrayList;
import java.util.List;

// Model
class Task {
    private String name;
    private boolean completed;

    public Task(String name) {
        this.name = name;
        this.completed = false;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

// View
class TaskView {
    public void displayTasks(List<Task> tasks) {
        System.out.println("Task List:");
        for (Task task : tasks) {
            System.out.println(task.getName() + " - Completed: " + task.isCompleted());
        }
    }
}

// Controller
class TaskController {
    private List<Task> tasks = new ArrayList<>();
    private TaskView taskView;

    public TaskController(TaskView taskView) {
        this.taskView = taskView;
    }

    public void addTask(String name) {
        Task task = new Task(name);
        tasks.add(task);
        taskView.displayTasks(tasks);
    }

    // Other controller methods for updating, deleting tasks, etc.
}

public class ModelViewController {
    public static void main(String[] args) {
        TaskView taskView = new TaskView();
        TaskController taskController = new TaskController(taskView);

        // Adding tasks
        taskController.addTask("Task 1");
        taskController.addTask("Task 2");
        taskController.addTask("Task 3");
    }
}