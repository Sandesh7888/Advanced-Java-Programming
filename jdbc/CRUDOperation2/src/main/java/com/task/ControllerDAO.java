package com.task;

import java.sql.SQLException;

public interface ControllerDAO {
	
	void save() throws SQLException;
	
	void update() throws SQLException, IdNotFoundException;
	
	void delete() throws SQLException, IdNotFoundException;
	
	void getById()throws SQLException, IdNotFoundException;


}
