package com.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class InStudent extends School implements Functions {

	public InStudent() {
	}

	public InStudent(Integer id, String name, String address, String grade, String section) {
		super(id, name, address, grade, section);
	}

	public void addData(Integer id, String name, String address, String grade, String section)
			throws IOException {

		String studentFileName = "Student.txt";

		try (Writer writer = new FileWriter(studentFileName, true)) {
			Gson gson = new GsonBuilder().create();
			gson.toJson(new InStudent(id, name, address, grade, section), writer);
			writer.write("\n");
		}

	}

	@Override
	public void deleteData(Integer id) throws IOException {

		String studentFileName = "Student.txt";
		String studentFileName1 = "new.txt";
		File studentFile = new File(studentFileName);
		File studentFile1 = new File(studentFileName1);

		try (Scanner reader = new Scanner(studentFile); Writer writer1 = new FileWriter(studentFileName1, true)) {
			while (reader.hasNextLine() == true) {
				Gson gson = new GsonBuilder().create();
				InStudent p = gson.fromJson(reader.nextLine(), InStudent.class);

				if (p.getId() != id) {
					Gson gson1 = new GsonBuilder().create();
					gson1.toJson(new InStudent(p.getId(), p.getName(), p.getAddress(), p.getGrade(),
							p.getSection()), writer1);
					writer1.write("\n");
				}
			}
			studentFile.delete();
			studentFile1.renameTo(studentFile);
		}
	}

	@Override
	public Integer getIdNumber() throws FileNotFoundException {

		String studentFileName = "Student.txt";
		File studentFile = new File(studentFileName);

		Integer id = 0;
		try (Scanner reader = new Scanner(studentFile)) {
			while (reader.hasNextLine() == true) {
				Gson gson = new GsonBuilder().create();
				InStudent p = gson.fromJson(reader.nextLine(), InStudent.class);
				id = p.getId();
			}
			return id;
		}
	}

	@Override
	public void updateData(Integer id, String fieldNumber, String fieldUpdateData) throws IOException {

		String studentFileName = "Student.txt";
		String studentFileName1 = "new.txt";
		File studentFile = new File(studentFileName);
		File studentFile1 = new File(studentFileName1);
		boolean Flag = true;

		try (Scanner reader = new Scanner(studentFile); Writer writer1 = new FileWriter(studentFileName1, true)) {
			while (reader.hasNextLine() == true) {
				Gson gson = new GsonBuilder().create();
				InStudent p = gson.fromJson(reader.nextLine(), InStudent.class);

				if (p.getId() == id && Flag == true) {
					switch (fieldNumber) {
					case "1":
						gson.toJson(new InStudent(p.getId(), fieldUpdateData, p.getAddress(), p.getGrade(), p.getSection()), writer1);
						writer1.write("\n");
						Flag = false;
						break;

					case "2":
						gson.toJson(new InStudent(p.getId(), p.getName(), fieldUpdateData, p.getGrade(), p.getSection()), writer1);
						writer1.write("\n");
						Flag = false;
						break;

					case "3":
						gson.toJson(new InStudent(p.getId(), p.getName(), p.getAddress(), fieldUpdateData, p.getSection()), writer1);
						writer1.write("\n");
						Flag = false;
						break;

					case "4":
						gson.toJson(new InStudent(p.getId(), fieldUpdateData, p.getAddress(), p.getGrade(), fieldUpdateData), writer1);
						writer1.write("\n");
						Flag = false;
						break;
					}
				} else {
					gson.toJson(new InStudent(p.getId(), p.getName(), p.getAddress(), p.getGrade(),	p.getSection()), writer1);
					writer1.write("\n");
				}
			}
			studentFile.delete();
			studentFile1.renameTo(studentFile);
		}
	}

	@Override
	public void showOne(Integer id) throws FileNotFoundException {
		String result = null;

		String studentFileName = "Student.txt";
		File studentFile = new File(studentFileName);

		try (Scanner reader = new Scanner(studentFile)) {
			while (reader.hasNextLine() == true) {
				Gson gson = new GsonBuilder().create();
				School p = gson.fromJson(reader.nextLine(), School.class);
				if ((p.getId() == id)) {
					result = "Student id = " + p.getId();
					result += "\n\tName = " + p.getName();
					result += "\n\tAddress = " + p.getAddress();
					result += "\n\tGrade = " + p.getGrade();
					result += "\n\tSection = " + p.getSection();
					result += "\n";
					break;
				} else {
					result = "no student found";
				}
			}
			System.out.println(result);
		}

	}
	
	public void showAll() {
		String studentFileName = "Student.txt";
		File studentFile = new File(studentFileName);
		int count = 0;
		try (Scanner reader = new Scanner(studentFile)) {
			while (reader.hasNextLine() == true) {
				Gson gson = new GsonBuilder().create();
				School p = gson.fromJson(reader.nextLine(), School.class);
				String result = "Student id = " + p.getId();
				result += "\n\tName = " + p.getName();
				result += "\n\tAddress = " + p.getAddress();
				result += "\n\tGrade = " + p.getGrade();
				result += "\n\tSection = " + p.getSection();
				result += "\n";
				System.out.println(result);
				count += 1;
			}
			if (reader.hasNextLine() == false && count == 0) {
				System.out.println();
				System.out.println("no student present");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
