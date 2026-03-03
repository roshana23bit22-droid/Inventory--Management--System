package newpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginService {
    public void loginUser(String username, String password) {
        // Try-with-resources will automatically close Connection and ResultSet
        try (Connection conn = DatabaseConnection.getConnection()) {
            
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Login successful! Welcome, " + username);
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UserLoginService userLoginService = new UserLoginService();
        userLoginService.loginUser("john_doe", "password123");
    }
}
