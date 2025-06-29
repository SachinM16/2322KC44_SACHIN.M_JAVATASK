import java.sql.*;

public class StudentDBManager {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "password");
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS students (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), department VARCHAR(50))");

            String sql = "INSERT INTO students (name, department) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "Bob");
            pstmt.setString(2, "Electronics");
            pstmt.executeUpdate();

            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ", " + rs.getString("name") + ", " + rs.getString("department"));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
