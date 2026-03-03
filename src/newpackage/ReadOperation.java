package newpackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadOperation {
    private Connection connection;

    public ReadOperation(Connection connection) {
        this.connection = connection;
    }

    public ResultSet getAllProducts() {
        try {
            String query = "SELECT * FROM products";
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        ReadOperation readOp = new ReadOperation(db.getConnection());
        ResultSet rs = readOp.getAllProducts();
        try {
            while (rs.next()) {
                System.out.println("Product ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}