package pl.workshop3.model;

import pl.workshop3.dao.ExcerciseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Excercise extends ExcerciseDao {
	
	private int id;
	private String title;
	private String description;
	
    
    
    public Excercise(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public Excercise() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		return "Excercise [id=" + id + ", title=" + title + ", description=" + description + "] \n";
	}
	
	

}


	




	
	
    
    
	

    
    

