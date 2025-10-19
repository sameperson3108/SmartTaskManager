import java.util.List;
import java.util.Scanner;

public class TaskLogic {
    private final TaskList taskList;
    Scanner scanner = new Scanner(System.in);

    public TaskLogic(TaskList taskList) {
        this.taskList = taskList;
    }

    public void addTask(String title) {
        taskList.addTask(title);
        System.out.println("УСПЕШНО ДОБАВЛЕНО");
    }

    public void showTask() {
        List<Task> tasks = taskList.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("ЗАДАЧ НЕТ");
            return;
        }
        tasks.forEach(System.out::println);
    }

    public void completeTask(int id) {
        Task task = taskList.getById(id);
        if (task == null) System.out.println("ПОКАЗЫВАТЬ НЕЧЕГО");
        else {
            task.setComplete(true);
            System.out.println("ЗАДАЧА ВЫПОЛНЕНА");
        }
    }

    public void removeTask(int id) {
        Task task = taskList.getById(id);
        if (task == null) System.out.println("УДАЛЯТЬ НЕЧЕГО");
        else {
            taskList.removeTask(id);
            System.out.println("ЗАДАЧА УДАЛЕНА");
        }
    }

    public void dalee() {
        System.out.println("НАЖМИТЕ ENTER ДЛЯ ПРОДОЛЖЕНИЯ");
        scanner.nextLine();
    }
}
