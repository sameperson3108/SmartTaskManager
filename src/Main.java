import java.util.List;
import java.util.Scanner;

public class Main {

    private static void dalee(Scanner scanner) {
        System.out.println("\nНАЖМИТЕ ENTER ДЛЯ ПРОДОЛЖЕНИЯ");
        scanner.nextLine();
    }
    private static void showTasks(TaskDAO taskDAO) {
        List<Task> tasks = taskDAO.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("ЗАДАЧ НЕТ");
        } else {
            System.out.println("\n--- СПИСОК ЗАДАЧ ---");
            tasks.forEach(System.out::println);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskDAO taskDAO = new TaskDAO();

        while (true) {
            System.out.println("\n ТАСК-МЕНЕДЖЕР ");
            System.out.println("1. ДОБАВИТЬ ЗАДАЧУ");
            System.out.println("2. ПОКАЗАТЬ ЗАДАЧИ");
            System.out.println("3. ОТМЕТИТЬ ВЫПОЛНЕННОЙ");
            System.out.println("4. УДАЛИТЬ ЗАДАЧУ");
            System.out.println("5. ОТКЛЮЧИТЬСЯ");
            System.out.print("ВВЕДИТЕ ЧИСЛО: ");

            String choice = scanner.nextLine();

            switch(choice) {
                case "1":
                    System.out.print("ВВЕДИТЕ ЗАДАЧУ: ");
                    String title = scanner.nextLine();

                    taskDAO.addTask(title);
                    System.out.println("УСПЕШНО ДОБАВЛЕНО");
                    dalee(scanner);
                    break;

                case "2":
                    showTasks(taskDAO);
                    dalee(scanner);
                    break;

                case "3":
                    showTasks(taskDAO);
                    System.out.print("ВВЕДИТЕ ID ЗАДАЧИ: ");
                    try {
                        int id = Integer.parseInt(scanner.nextLine());
                        taskDAO.completeTask(id);
                        System.out.println("ЗАДАЧА ВЫПОЛНЕНА");
                    } catch (NumberFormatException e) {
                        System.out.println("Неверный формат ID.");
                    }
                    dalee(scanner);
                    break;

                case "4":
                    showTasks(taskDAO);
                    System.out.print("ВВЕДИТЕ ID ЗАДАЧИ ИЗ СПИСКА: ");
                    try {
                        int id1 = Integer.parseInt(scanner.nextLine());
                        taskDAO.removeTask(id1);
                        System.out.println("ЗАДАЧА УДАЛЕНА");
                    } catch (NumberFormatException e) {
                        System.out.println("Неверный формат ID.");
                    }
                    dalee(scanner);
                    break;

                case "5":
                    System.out.println("Программа завершена.");
                    return;

                default:
                    System.out.println("Неверный ввод, попробуйте снова.");
                    dalee(scanner);
                    break;
            }
        }
    }
}