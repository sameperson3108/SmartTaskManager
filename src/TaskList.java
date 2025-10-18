import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(String title) {
        tasks.add(new Task(nextId++, title, false));
    }

    public Task getById(int id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean removeTask(int id) {
        return tasks.removeIf(task -> task.getId() == id);
    }

}
