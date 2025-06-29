import java.sql.*;
import java.util.*;

public class ProductDAO {
    private Connection conn;

    public ProductDAO() throws Exception {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "sachin1610");
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS products (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), price DOUBLE)");
    }

    public void addProduct(Product p) throws Exception {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO products (name, price) VALUES (?, ?)");
        ps.setString(1, p.getName());
        ps.setDouble(2, p.getPrice());
        ps.executeUpdate();
    }

    public List<Product> viewAll() throws Exception {
        List<Product> list = new ArrayList<>();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM products");
        while (rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getDouble("price"));
            list.add(p);
        }
        return list;
    }

    public Product searchProduct(String name) throws Exception {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM products WHERE name = ?");
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getDouble("price"));
            return p;
        }
        return null;
    }

    public void close() throws Exception {
        conn.close();
    }
}
