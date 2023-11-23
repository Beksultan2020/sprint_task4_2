package db;

import java.sql.*;
import java.util.ArrayList;

public class DBManager_Items {
    private static Connection connection;
    static {
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        try{
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/shopSPT2",
                    "postgres","beka asd2020");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Item> getAllItems(){
        ArrayList<Item> items=new ArrayList<>();
        try {
            PreparedStatement stmt=connection.prepareStatement(
                    "SELECT * FROM items");
            ResultSet resultSet=stmt.executeQuery();
            while(resultSet.next()){
                Item item=new Item();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));
                items.add(item);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return items;
    }

    public static Item getItem(Long id){
        Item item=new Item();
        try {
            PreparedStatement stmt=connection.prepareStatement("SELECT * FROM items WHERE id=?");
            stmt.setLong(1,id);
            ResultSet resultSet=stmt.executeQuery();
            while (resultSet.next()){
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return item;
    }

    public static User getUser(String email){
        User user=new User();
        try {
            PreparedStatement stmt=connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            stmt.setString(1, email);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
