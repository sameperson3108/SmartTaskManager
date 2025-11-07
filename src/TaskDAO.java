import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/task_manager";
    private static final String USER = "task_user";
    private static final String PASSWORD = "12345";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addTask(String title) {
        String SQL = "INSERT INTO tasks (title, completed) VALUES (?, FALSE)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, title);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении задачи: " + e.getMessage());
        }
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        String SQL = "SELECT id, title, completed FROM tasks ORDER BY id";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                Task task = new Task(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getBoolean("completed")
                );
                tasks.add(task);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при получении задач: " + e.getMessage());
        }
        return tasks;
    }

    public void completeTask(int taskId) {
        String SQL = "UPDATE tasks SET complete = TRUE WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, taskId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Ошибка при обновлении задачи: " + e.getMessage());
        }
    }

    public void removeTask(int taskId) {
        String SQL = "DELETE FROM tasks WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, taskId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Ошибка при удалении задачи: " + e.getMessage());
        }
    }
}
