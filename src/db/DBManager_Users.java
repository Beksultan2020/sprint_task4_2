package db;

import java.sql.*;

public class DBManager_Users {
    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        try {
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/shopSPT2",
                    "postgres","beka asd2020");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

//    public static User getUser(User user){
//        try {
//            PreparedStatement stmt = connection.prepareStatement(
//                    "SELECT * FROM users WHERE email=? AND password=?");
//            ResultSet resultSet=stmt.executeQuery();
//            while (resultSet.next()){
//                user.setId(resultSet.getLong("id"));
//                user.setEmail(resultSet.getString("email"));
//                user.setPassword(resultSet.getString("password"));
//                user.setFullName(resultSet.getString("full_name"));
//            }
//        }catch (SQLException e){
//            throw new RuntimeException(e);
//        }
//        return user;
//    }

    public static void addUser(User user){
        try {
            PreparedStatement stmt=connection.prepareStatement("INSERT INTO users( email, password,full_name) "+
                    "VALUES (?,?,?,?)");
            stmt.setString(1,user.getEmail());
            stmt.setString(2,user.getPassword());
            stmt.setString(3,user.getFullName());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
