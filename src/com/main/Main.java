package com.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	

	private static School pStudent = new InStudent();
	private static School pTeacher = new InTeacher();
	private static School pSchool = new School();

	public static void main(String[] args) throws IOException {
		
		MainFunctions task = new MainFunctions();

		checkFile();

		task.idStudent = task.student.getIdNumber();
		task.idTeacher = task.teacher.getIdNumber();

		while (true) {

			System.out.println("1 - Student");
			System.out.println("2 - Teacher");
			System.out.println("3 - Show All Student and Teacher data");
			System.out.println("0 - quit");
			System.out.print("Enter your choice : ");
			String doTask = null;
			doTask = task.takeInput.nextLine();

			if (doTask.equals("0")) {
				break;
			} else if (doTask.equals("1")) {
				task.studentPrint();
				String doTask1;
				doTask1 = task.takeInput.nextLine();
				while (doTask1.equals("0") == false) {
					task.allTaskStudent(doTask1);
					task.studentPrint();
					doTask1 = task.takeInput.nextLine();
				}
			} else if (doTask.equals("2")) {
				task.teacherPrint();
				String doTask1;
				doTask1 = task.takeInput.nextLine();
				while (doTask1.equals("0") == false) {
					task.allTaskTeacher(doTask1);
					task.teacherPrint();
					doTask1 = task.takeInput.nextLine();
				}
			} else if (doTask.equals("3")) {
				pSchool.showAll();
				System.out.println("Student Field");
				pStudent.showAll();
				System.out.println();
				System.out.println("Teacher Field");
				pTeacher.showAll();
			}
		}
	}

	public static void checkFile() throws IOException {
		if (!new File("Student.txt").exists()) {
			new FileWriter("Student.txt");
			System.out.println("Student file does not exists");
		}
		if (!new File("Teacher.txt").exists()) {
			new FileWriter("Teacher.txt");
			System.out.println("Teacher file does not exists");
		}
	}
}