package pl.workshop3.dao;

import pl.workshop3.model.Excercise;
import pl.workshop3.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ExcerciseDao {


    private static final String READ_EXCERCISE_QUERY = "SELECT * FROM excercise where id=?";
    private static final String DELETE_EXCERCISE_QUERY = "DELETE FROM excercise where id = ?";
    private static final String CREATE_EXCERCISE_QUERY = "INSERT INTO excercise (title, description) VALUES (?, ?)";
    private static final String FIND_ALL_EXCERCISE_QUERY = "SELECT * FROM excercise";
    private static final String UPDATE_EXCERCISE_QUERY = "UPDATE excercise SET title=?, description=? where id = ?";




    public static void delete(Integer excerciseId) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement =
                     connection.prepareStatement(DELETE_EXCERCISE_QUERY);) {
            statement.setInt(1, excerciseId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong...");
        }
    }

    public static void add(Excercise excercise) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(CREATE_EXCERCISE_QUERY);) {

            statement.setString(1, excercise.getTitle());
            statement.setString(2, excercise.getDescription());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong...");
        }
    }

    public static Excercise[] loadAllExces() {
        ArrayList<Excercise> exces = new ArrayList<Excercise>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_EXCERCISE_QUERY);) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Excercise loadedExce = new Excercise();
                loadedExce.setId(resultSet.getInt("id"));
                loadedExce.setTitle(resultSet.getString("title"));
                loadedExce.setDescription(resultSet.getString("description"));

                exces.add(loadedExce);}

        } catch (Exception e) { e.printStackTrace();
            System.out.println("Something went wrong...");}
        Excercise[] uArray = new Excercise[exces.size()]; uArray = exces.toArray(uArray);
        return uArray;}


    public static void update(Excercise exce) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EXCERCISE_QUERY);) {
            statement.setInt(3, exce.getId());
            statement.setString(1, exce.getTitle());
            statement.setString(2, exce.getDescription());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong...");
        }

    }


    public static Excercise read(Integer exceId) {
        Excercise exce = new Excercise();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(READ_EXCERCISE_QUERY);) {
            statement.setInt(1, exceId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    exce.setId(resultSet.getInt("id"));
                    exce.setTitle(resultSet.getString("title"));
                    exce.setDescription(resultSet.getString("description"));
                }

            }

        } catch (Exception e) { e.printStackTrace();
            System.out.println("Something went wrong...");}
        return exce; }
}






