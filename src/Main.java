import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskList taskList = new TaskList();
        TaskLogic taskLogic = new TaskLogic(taskList);

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
                    taskLogic.addTask(title);
                    taskLogic.dalee();
                    break;

                case "2":
                    taskLogic.showTask();
                    taskLogic.dalee();
                    break;

                case "3":
                    System.out.println("ВВЕДИТЕ ID");
                    taskLogic.showTask();
                    int id = Integer.parseInt(scanner.nextLine());
                    taskLogic.completeTask(id);
                    taskLogic.dalee();
                    break;

                case "4":
                    System.out.println("ВВЕДИТЕ ID ЗАДАЧИ ИЗ СПИСКА");
                    taskLogic.showTask();
                    int id1 = Integer.parseInt(scanner.nextLine());
                    taskLogic.removeTask(id1);
                    taskLogic.dalee();
                    break;

                case "5":
                    return;
            }
        }
    }
}