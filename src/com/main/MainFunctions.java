package com.main;

import java.io.IOException;
import java.util.Scanner;

public class MainFunctions {

	public int idStudent = 0;
	public int idTeacher = 0;
	private String name;
	private String address;
	private String grade;
	private String post;
	private String section;
	public Scanner takeInput = new Scanner(System.in);
	public InStudent student = new InStudent();
	public InTeacher teacher = new InTeacher();

	public void studentPrint() {
		System.out.println("1 - add student");
		System.out.println("2 - show all student");
		System.out.println("3 - show particular Student with id number");
		System.out.println("4 - delete Student data");
		System.out.println("5 - update Student data");
		System.out.println("0 - back to main");
		System.out.print("Enter what you want to do : ");
		
	}

	public void teacherPrint() {
		System.out.println("1 - add Teacher");
		System.out.println("2 - show all Teacher");
		System.out.println("3 - show particular Teacher with id number");
		System.out.println("4 - delete Teacher data");
		System.out.println("5 - update Teacher data");
		System.out.println("0 - back to main");
		System.out.print("Enter what you want to do : ");
	}

	public void allTaskStudent(String doTask) throws IOException {
		Integer studentId;
		switch (doTask) {
		case "1":
			takeInputStudent();
			idStudent = idStudent + 1;
			student.addData(idStudent, name, address, grade, section);
			break;
			
		case "2":
			student.showAll();
			break;

		case "3":
			System.out.print("Enter student id : ");
			studentId = takeInput.nextInt();
			student.showOne(studentId);
			takeInput.nextLine();
			break;

		case "4":
			System.out.print("Enter id number : ");
			studentId = takeInput.nextInt();
			student.deleteData(studentId);
			takeInput.nextLine();
			break;

		case "5":
			System.out.println("1 - Name : 2 - Address : 3 - Grade : 4 - Section");
			System.out.print("what field you want to update : ");
			String fieldNumber = takeInput.nextLine();
			System.out.print("Enter the field data : ");
			String fieldUpdateData = takeInput.nextLine();
			System.out.print("Enter the id whose field you want to update");
			studentId = takeInput.nextInt();
			student.updateData(studentId, fieldNumber, fieldUpdateData);
			takeInput.nextLine();
		}
	}

	public void allTaskTeacher(String doTask) throws IOException {
		Integer teacherId;
		switch (doTask) {
		case "1":
			takeInputTeacher();
			idTeacher = idTeacher + 1;
			teacher.addData(idTeacher, name, address, post,null);
			break;
		case "2":
			teacher.showAll();
			break;

		case "3":
			System.out.print("Enter teacher id : ");
			teacherId = takeInput.nextInt();
			teacher.showOne(teacherId);
			takeInput.nextLine();
			break;

		case "4":
			System.out.print("Enter id number : ");
			teacherId = takeInput.nextInt();
			teacher.deleteData(teacherId);
			takeInput.nextLine();
			break;

		case "5":
			System.out.println("1 - Name : 2 - Address : 3 - Post :");
			System.out.print("what field you want to update : ");
			String fieldNumber = takeInput.nextLine();
			System.out.print("Enter the field data : ");
			String fieldUpdateData = takeInput.nextLine();
			System.out.print("Enter the id whose field you want to update");
			teacherId = takeInput.nextInt();
			teacher.updateData(teacherId, fieldNumber, fieldUpdateData);
			takeInput.nextLine();
		}
	}
	
	public void takeInputStudent() {
		System.out.print("Enter the name of the student : ");
		name = takeInput.nextLine();

		System.out.print("Enter the address of the student : ");
		address = takeInput.nextLine();

		System.out.print("Enter the grade of the student : ");
		grade = takeInput.nextLine();

		System.out.print("Enter the section of the student : ");
		section = takeInput.nextLine();

	}
	
	public void takeInputTeacher() {
		System.out.print("Enter the name of the teacher : ");
		name = takeInput.nextLine();

		System.out.print("Enter the address of the teacher : ");
		address = takeInput.nextLine();

		System.out.print("Enter the post of the teacher : ");
		post = takeInput.nextLine();
	}

}
