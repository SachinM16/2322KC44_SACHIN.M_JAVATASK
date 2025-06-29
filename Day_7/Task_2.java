import java.sql.*;

public class InsertStudent {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "password");
            String sql = "INSERT INTO students (name, department) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "Alice");
            pstmt.setString(2, "Computer Science");
            pstmt.executeUpdate();
            System.out.println("Inserted student record.");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
