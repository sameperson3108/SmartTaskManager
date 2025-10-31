import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/task_manager";
    private static final String USER = "task_user";
    private static final String PASSWORD = "12345";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            if (conn != null) {
                System.out.println("Подключен");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка" + e.getMessage());
        }
    }
}
