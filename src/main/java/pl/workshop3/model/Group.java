package pl.workshop3.model;

import pl.workshop3.dao.GroupDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class Group extends GroupDao {

	private Integer id;
	private String name;


	public Group(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Group() {
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








}