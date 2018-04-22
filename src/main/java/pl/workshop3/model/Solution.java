package pl.workshop3.model;


import pl.workshop3.dao.SolutionDao;

public class Solution extends SolutionDao {
	
	protected int id;
    protected String created;
    protected String updated;
    protected String description;
    protected int excerciseId;
    protected int usersId;
    
    
	public Solution(String description, int excerciseId, int usersId) {
		super();
		this.description = description;
		this.excerciseId = excerciseId;
		this.usersId = usersId;
	}


	public Solution() {
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getExcerciseId() {
		return excerciseId;
	}

	public void setExcerciseId(int excerciseId) {
		this.excerciseId = excerciseId;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}


	
/*	// próba dodania metody zwracającej nierozwiazane zadania dla user id
	
	static public Solution loadUnsolvedById(Connection conn, int id) throws SQLException {
	    String sql = "SELECT * FROM excercise left JOIN solution ON excercise.id=solution.excercise_id where solution.user_id= ? and excercise.id=null;";
	    PreparedStatement preparedStatement;
	    preparedStatement = conn.prepareStatement(sql);
	    preparedStatement.setInt(1, id);
	    ResultSet resultSet = preparedStatement.executeQuery();
	    if (resultSet.next()) {
	        Solution loadedSolution = new Solution();
	        loadedSolution.id = resultSet.getInt("id");
	        loadedSolution.description = resultSet.getString("description");
	        loadedSolution.created = resultSet.getString("created");
	        loadedSolution.updated = resultSet.getString("updated");
	        loadedSolution.excerciseId = resultSet.getInt("excercise_id");
	        loadedSolution.usersId = resultSet.getInt("users_id");
	        return loadedSolution;}
	    return null;}
*/	
	
	
	
	
	

	@Override
	public String toString() {
		return "Solution [id=" + id + ", created=" + created + ", updated=" + updated + ", description=" + description
				+ ", excerciseId=" + excerciseId + ", usersId=" + usersId + "] \n";
	}
	
	    

}
