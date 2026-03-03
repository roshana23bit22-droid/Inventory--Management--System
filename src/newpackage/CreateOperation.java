package newpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateOperation {
    private Connection connection;

    public CreateOperation(Connection connection) {
        this.connection = connection;
    }

    public void insertProduct(String name, int quantity, double price) {
        try {
            String query = "INSERT INTO products (name, quantity, price) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, quantity);
            stmt.setDouble(3, price);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        CreateOperation createOp = new CreateOperation(db.getConnection());
        createOp.insertProduct("Test Product", 10, 99.99);
    }
}
