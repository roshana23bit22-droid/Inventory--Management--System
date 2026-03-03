package newpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteOperation {
    private Connection connection;

    public DeleteOperation(Connection connection) {
        this.connection = connection;
    }

    public void deleteProduct(int id) {
        try {
            String query = "DELETE FROM products WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        DeleteOperation deleteOp = new DeleteOperation(db.getConnection());
        deleteOp.deleteProduct(1);
    }
}