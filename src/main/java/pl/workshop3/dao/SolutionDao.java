package pl.workshop3.dao;

import pl.workshop3.model.Solution;
import pl.workshop3.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SolutionDao {

    private static final String CREATE_SOLUTION_QUERY = "INSERT INTO solution (description, created, users_id, excercise_id) VALUES (?, NOW(), ?, ?)";
    private static final String READ_SOLUTION_QUERY = "Select * from solution where id = ?";
    private static final String UPDATE_SOLUTION_QUERY = "UPDATE solution SET description=?, users_id=?, excercise_id=?, updated=NOW() where id=?";
    private static final String DELETE_SOLUTION_QUERY = "DELETE FROM solution where id = ?";
    private static final String FIND_ALL_SOLUTION_QUERY = "SELECT * FROM solution";
    private static final String FIND_ALL_SOLUTION_LIMIT_QUERY = "SELECT * FROM solution ORDER BY created LIMIT ? ";
    private static final String READ_SOLUTION_BYUSERID_QUERY = "SELECT * FROM solution where users_id=?";
    private static final String READ_SOLUTION_BYEXID_QUERY = "SELECT * FROM solution where excercise_id=? ORDER BY created DESC";


    private static final String READ_USER_EMAIL_QUERY = "Select * from users where email = ?";
    private static final String READ_USER_GROUPID_QUERY = "Select * from users where user_group_id = ?";
    private static final String READ_USER_BY_SURNAME_QUERY = "SELECT * FROM users WHERE username like ?";





    public static void delete(Integer solId) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement =
                     connection.prepareStatement(DELETE_SOLUTION_QUERY);) {
            statement.setInt(1, solId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong...");
        }
    }

    public static Solution read(Integer solId) {
        Solution solution = new Solution();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(READ_SOLUTION_QUERY);) {
            statement.setInt(1, solId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    solution.setId(resultSet.getInt("id"));
                    solution.setDescription(resultSet.getString("description"));
                    solution.setCreated(resultSet.getString("created"));
                    solution.setUpdated(resultSet.getString("updated"));
                    solution.setExcerciseId(resultSet.getInt("excercise_id"));
                    solution.setUsersId(resultSet.getInt("users_id")); }}

        } catch (Exception e) { e.printStackTrace();
            System.out.println("Something went wrong...");}
        return solution;
    }

    public static void update(Solution solution) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SOLUTION_QUERY);) {
            statement.setString(1, solution.getDescription());
            statement.setInt(2, solution.getUsersId());
            statement.setInt(3, solution.getExcerciseId());
            statement.setInt(4, solution.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong...");
        }

    }


    public static Solution[] loadAllSolutions() {
        ArrayList<Solution> sols = new ArrayList<Solution>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_SOLUTION_QUERY);) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Solution loadedSol = new Solution();
                loadedSol.setId(resultSet.getInt("id"));
                loadedSol.setDescription(resultSet.getString("description"));
                loadedSol.setCreated(resultSet.getString("created"));
                loadedSol.setUpdated(resultSet.getString("updated"));
                loadedSol.setExcerciseId(resultSet.getInt("excercise_id"));
                loadedSol.setUsersId(resultSet.getInt("users_id"));
                sols.add(loadedSol);}

        } catch (Exception e) { e.printStackTrace();
            System.out.println("Something went wrong...");}
        Solution[] uArray = new Solution[sols.size()]; uArray = sols.toArray(uArray);
        return uArray;}




    public static void add(Solution solution) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(CREATE_SOLUTION_QUERY);) {

            statement.setString(1, solution.getDescription());
            statement.setInt(2, solution.getUsersId());
            statement.setInt(3, solution.getExcerciseId());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong...");
        }
    }

    public static Solution[] loadAllSolsByUserId(int UserId) {
        ArrayList<Solution> sols = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
            PreparedStatement statement = connection.prepareStatement(READ_SOLUTION_BYUSERID_QUERY);) {
            statement.setInt(1, UserId);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Solution loadedSol = new Solution();
                loadedSol.setId(resultSet.getInt("id"));
                loadedSol.setDescription(resultSet.getString("description"));
                loadedSol.setCreated(resultSet.getString("created"));
                loadedSol.setUpdated(resultSet.getString("updated"));
                loadedSol.setExcerciseId(resultSet.getInt("excercise_id"));
                loadedSol.setUsersId(resultSet.getInt("users_id"));
                sols.add(loadedSol);}

        } catch (Exception e) { e.printStackTrace();
            System.out.println("Something went wrong...");}
        Solution[] uArray = new Solution[sols.size()]; uArray = sols.toArray(uArray);
        return uArray;}



    public static Solution[] loadAllSolsByExcerciseId(int ExId) {
        ArrayList<Solution> sols = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(READ_SOLUTION_BYEXID_QUERY);) {
            statement.setInt(1, ExId);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Solution loadedSol = new Solution();
                loadedSol.setId(resultSet.getInt("id"));
                loadedSol.setDescription(resultSet.getString("description"));
                loadedSol.setCreated(resultSet.getString("created"));
                loadedSol.setUpdated(resultSet.getString("updated"));
                loadedSol.setExcerciseId(resultSet.getInt("excercise_id"));
                loadedSol.setUsersId(resultSet.getInt("users_id"));
                sols.add(loadedSol);}

        } catch (Exception e) { e.printStackTrace();
            System.out.println("Something went wrong...");}
        Solution[] uArray = new Solution[sols.size()]; uArray = sols.toArray(uArray);
        return uArray;}


    /**
     *
     * @param limit
     * @return List of solutions, ordered by created, shows only 'limit' number of records
     */
    public static Solution[] loadAllSolutions(int limit) {
        ArrayList<Solution> sols = new ArrayList<Solution>();
        try (Connection connection = DbUtil.getConn();
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_SOLUTION_LIMIT_QUERY);) {
            statement.setInt(1, limit);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Solution loadedSol = new Solution();
                loadedSol.setId(resultSet.getInt("id"));
                loadedSol.setDescription(resultSet.getString("description"));
                loadedSol.setCreated(resultSet.getString("created"));
                loadedSol.setUpdated(resultSet.getString("updated"));
                loadedSol.setExcerciseId(resultSet.getInt("excercise_id"));
                loadedSol.setUsersId(resultSet.getInt("users_id"));
                sols.add(loadedSol);}

        } catch (Exception e) { e.printStackTrace();
            System.out.println("Something went wrong...");}
        Solution[] uArray = new Solution[sols.size()]; uArray = sols.toArray(uArray);
        return uArray;}


}



