package pl.workshop3.dao;

import pl.workshop3.model.User;
import pl.workshop3.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDao {


    private static final String CREATE_USER_QUERY = "INSERT INTO users(username,email,password,user_group_id) VALUES (?,?,?,?)";
    private static final String READ_USER_QUERY = "Select * from users where id = ?";
    private static final String UPDATE_USER_QUERY = "UPDATE users SET username = ? , email = ?, password = ?, user_group_id =? WHERE id = ?";
    private static final String DELETE_USER_QUERY = "DELETE FROM users where id = ?";
    private static final String FIND_ALL_USERS_QUERY = "SELECT * FROM users";
    private static final String READ_USER_EMAIL_QUERY = "Select * from users where email = ?";
    private static final String READ_USER_GROUPID_QUERY = "Select * from users where user_group_id = ?";
    private static final String READ_USER_BY_SURNAME_QUERY = "SELECT * FROM users WHERE username like ?";





    public static void delete(Integer userId) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement =
                     connection.prepareStatement(DELETE_USER_QUERY);) {
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong...");
        }
    }

    public static User read(Integer userId) {
        User user = new User();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(READ_USER_QUERY);) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("username"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setUserGroupId(resultSet.getInt("user_group_id")); }}
        } catch (Exception e) { e.printStackTrace();
            System.out.println("Something went wrong...");}
        return user;
    }

    public static void update(User user) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER_QUERY);) {
            statement.setInt(5, user.getId());
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getUserGroupId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong...");
        }

    }

    public User readEmail(String userEmail) {
        User user = new User();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(READ_USER_EMAIL_QUERY);) {
            statement.setString(1, userEmail);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("username"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setUserGroupId(resultSet.getInt("user_group_id")); }}
        } catch (Exception e) { e.printStackTrace();
            System.out.println("Something went wrong...");}
        return user;
    }

    public static User[] loadAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_USERS_QUERY);) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User loadedUser = new User();
                loadedUser.setId(resultSet.getInt("id"));
                loadedUser.setName(resultSet.getString("username"));
                loadedUser.setPassword(resultSet.getString("password"));
                loadedUser.setEmail(resultSet.getString("email"));
                loadedUser.setUserGroupId(resultSet.getInt("user_group_id"));
                users.add(loadedUser);}

        } catch (Exception e) { e.printStackTrace();
            System.out.println("Something went wrong...");}
        User[] uArray = new User[users.size()]; uArray = users.toArray(uArray);
        return uArray;}


    public static User[] loadAllUsersByGroupId(int groupId) {
        ArrayList<User> users = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(READ_USER_GROUPID_QUERY);) {

            statement.setInt(1, groupId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User loadedUser = new User();
                loadedUser.setId(resultSet.getInt("id"));
                loadedUser.setName(resultSet.getString("username"));
                loadedUser.setPassword(resultSet.getString("password"));
                loadedUser.setEmail(resultSet.getString("email"));
                loadedUser.setUserGroupId(resultSet.getInt("user_group_id"));
                users.add(loadedUser);}

        } catch (Exception e) { e.printStackTrace();
            System.out.println("Something went wrong...");}
        User[] uArray = new User[users.size()]; uArray = users.toArray(uArray);
        return uArray;}

    public static void add(User user) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(CREATE_USER_QUERY);) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getUserGroupId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong...");
        }
    }


    public static User readSurname(String userSurname) {
        userSurname = "%"+userSurname+"%";
        User user = new User();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(READ_USER_BY_SURNAME_QUERY);) {
            statement.setString(1, userSurname);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("username"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setUserGroupId(resultSet.getInt("user_group_id")); }}
        } catch (Exception e) { e.printStackTrace();
            System.out.println("Something went wrong...");}
        return user;
    }


}

