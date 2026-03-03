package newpackage;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateOperation {
    private Connection connection;

    public UpdateOperation(Connection connection) {
        this.connection = connection;
    }

    public void updateProduct(int id, String name, int quantity, double price) {
        try {
            String query = "UPDATE products SET name = ?, quantity = ?, price = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, quantity);
            stmt.setDouble(3, price);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        UpdateOperation updateOp = new UpdateOperation(db.getConnection());
        updateOp.updateProduct(1, "Updated Product", 20, 49.99);
    }
}