package com.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class InTeacher extends School implements Functions {

	public InTeacher() {
	}

	public InTeacher(Integer id, String name, String address, String post) {
		super(id, name, address, post);
	}

	@Override
	public void addData(Integer id, String name, String address, String post, String section) throws IOException {

		String teacherFileName = "Teacher.txt";

		try (Writer writer = new FileWriter(teacherFileName, true)) {
			Gson gson = new GsonBuilder().create();
			gson.toJson(new InTeacher(id, name, address, post), writer);
			writer.write("\n");
		}
	}

	@Override
	public void deleteData(Integer id) throws IOException {

		String teacherFileName = "Teacher.txt";
		String teacherFileName1 = "new.txt";
		File teacherFile = new File(teacherFileName);
		File teacherFile1 = new File(teacherFileName1);

		try (Scanner reader = new Scanner(teacherFile); Writer writer1 = new FileWriter(teacherFileName1, true)) {
			while (reader.hasNextLine() == true) {
				Gson gson = new GsonBuilder().create();
				InTeacher p = gson.fromJson(reader.nextLine(), InTeacher.class);

				if (p.getId() != id) {
					Gson gson1 = new GsonBuilder().create();
					gson1.toJson(new InTeacher(p.getId(), p.getName(), p.getAddress(), p.getPost()), writer1);
					writer1.write("\n");
				}
			}
			teacherFile.delete();
			teacherFile1.renameTo(teacherFile);
		}

	}

	@Override
	public Integer getIdNumber() throws FileNotFoundException {

		String teacherFileName = "Teacher.txt";
		File teacherFile = new File(teacherFileName);

		Integer id = 0;
		try (Scanner reader = new Scanner(teacherFile)) {
			while (reader.hasNextLine() == true) {
				Gson gson = new GsonBuilder().create();
				InTeacher p = gson.fromJson(reader.nextLine(), InTeacher.class);
				id = p.getId();
			}
			return id;
		}
	}

	@Override
	public void updateData(Integer id, String fieldNumber, String fieldUpdateData) throws IOException {

		String teacherFileName = "Teacher.txt";
		String teacherFileName1 = "new.txt";
		File teacherFile = new File(teacherFileName);
		File teacherFile1 = new File(teacherFileName1);
		boolean Flag = true;

		try (Scanner reader = new Scanner(teacherFile); Writer writer1 = new FileWriter(teacherFileName1, true)) {
			while (reader.hasNextLine() == true) {
				Gson gson = new GsonBuilder().create();
				InTeacher p = gson.fromJson(reader.nextLine(), InTeacher.class);

				if (p.getId() == id && Flag == true) {
					switch (fieldNumber) {
					case "1":
						gson.toJson(new InTeacher(p.getId(), fieldUpdateData, p.getAddress(), p.getPost()), writer1);
						writer1.write("\n");
						Flag = false;
						break;

					case "2":
						gson.toJson(new InTeacher(p.getId(), p.getName(), fieldUpdateData, p.getPost()), writer1);
						writer1.write("\n");
						Flag = false;
						break;

					case "3":
						gson.toJson(new InTeacher(p.getId(), p.getName(), p.getAddress(), fieldUpdateData), writer1);
						writer1.write("\n");
						Flag = false;
						break;
					}
				} else {
					gson.toJson(new InTeacher(p.getId(), p.getName(), p.getAddress(), p.getPost()), writer1);
					writer1.write("\n");
				}
			}
			teacherFile.delete();
			teacherFile1.renameTo(teacherFile);
		}

	}

	@Override
	public void showOne(Integer id) throws FileNotFoundException {

		String result = null;

		String teacherFileName = "Teacher.txt";
		File teacherFile = new File(teacherFileName);

		try (Scanner reader = new Scanner(teacherFile)) {
			while (reader.hasNextLine() == true) {
				Gson gson = new GsonBuilder().create();
				InTeacher p = gson.fromJson(reader.nextLine(), InTeacher.class);
				if ((p.getId() == id)) {
					result = "Teacher id = " + p.getId();
					result += "\n\tName = " + p.getName();
					result += "\n\tAddress = " + p.getAddress();
					result += "\n\tPost = " + p.getPost();
					result += "\n";
					break;
				} else {
					result = "no teacher found";
				}
			}
			System.out.println(result);
		}

	}
	
	public void showAll() {
		String teacherFileName = "Teacher.txt";
		File teacherFile = new File(teacherFileName);
		int count = 0;
		try (Scanner reader = new Scanner(teacherFile)) {
			while (reader.hasNextLine() == true) {
				Gson gson = new GsonBuilder().create();
				InTeacher p = gson.fromJson(reader.nextLine(), InTeacher.class);
				String result = "Teacher id = " + p.getId();
				result += "\n\tName = " + p.getName();
				result += "\n\tAddress = " + p.getAddress();
				result += "\n\tPost = " + p.getPost();
				result += "\n";
				System.out.println(result);
				count += 1;
			}
			if (reader.hasNextLine() == false && count == 0) {
				System.out.println();
				System.out.println("no teacher present");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
