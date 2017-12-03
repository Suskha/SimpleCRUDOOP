package com.main;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Functions {
	
	void addData(Integer id, String name, String address, String grade, String section)throws IOException;
	void deleteData(Integer id) throws IOException;
	Integer getIdNumber ()throws FileNotFoundException;
	void updateData(Integer id,String fieldNumber, String fieldUpdateData) throws IOException ;
	void showOne(Integer id) throws FileNotFoundException;
	
}
