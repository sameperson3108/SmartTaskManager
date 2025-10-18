//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Task tryTask = new Task (01, "помыть посуду", false);
        TaskList taskList = new TaskList();
        taskList.addTask("написать список задач");
        taskList.addTask("вторая задача");

        System.out.println(tryTask);

        System.out.print(taskList.getTasks());
    }
}