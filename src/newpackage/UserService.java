package newpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserService {

    // Method for signing up a user
    public void userSignIn(String username, String password) {
        try {
            // Establish connection to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", "root", "password");

            // SQL query to insert user data
            String query = "INSERT INTO Users (username, password) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Set the query parameters
            pstmt.setString(1, username);
            pstmt.setString(2, password); // Hash the password in real-world scenarios for security

            // Execute the query
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("User registered successfully!");
            } else {
                System.out.println("Sign-in failed. Please try again.");
            }

            // Close the connection
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

        
    
    
