package pl.workshop3.model;


import org.mindrot.jbcrypt.BCrypt;
import pl.workshop3.dao.UserDao;

public class User extends UserDao {


	private Integer id;
	private String name;
	private String email;
	private String password;
	private Integer userGroupId;


	public User(Integer id, String name, String email, String password, Integer userGroupId) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.userGroupId = userGroupId;
	}

    public User(String name, String email, String password, Integer userGroupId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userGroupId = userGroupId;
    }

    public User() {
		super();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Integer userGroupId) {
		this.userGroupId = userGroupId;
	}

	@Override
	public String toString() {
		return "User id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", userGroupId=" + userGroupId + "+\n";
	}








}