package co.grandcircus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task {

	static Scanner scan = new Scanner(System.in);
	LocalDate ld;
	boolean complete;
	String description;
	String memberName;
	String dateInput;
	int i = 0;
	int taskNumber = 0;
	String confirm = "n";
//	ArrayList<Integer> taskNumber = new ArrayList<>();;

	public Task() {
		return;
	}

	public Task(int i, boolean complete, String memberName, LocalDate ld, String description) {
		this.i = i;
		this.memberName = memberName;
		this.description = description;
		this.ld = ld;
	}

	public void taskBuilder(ArrayList<Task> taskList) {
		memberName = Validator.getStringMatchingRegex(scan, "\nTeam member first name: ", "[A-Za-z]{1,20}");
		description = Validator.getStringMatchingRegex(scan, "\nTask description: ", ".{1,50}");
		ld = dateInput(dateInput);
		i++;
		Task newTask = new Task(i, false, memberName, ld, description);
		taskList.add(newTask);
		return;
	}

	public static LocalDate dateInput(String dateInput) {
		dateInput = Validator.getStringMatchingRegex(scan, "\nDue date (mm/dd/yyyy): ",
				"([0-1]\\d/[0-3]\\d{1}/[1-2]\\d{3})");
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate ld = LocalDate.parse(dateInput, dateFormat);
		return ld;
	}

	@Override
	public String toString() {
		return String.format("\n%-6d %-10s %-14s %-20s %-1s", i, complete, ld, memberName, description);
	}

	public ArrayList<Task> choiceList(ArrayList<Task> taskList) {
		System.out.println("\nLIST TASKS\n");
		System.out.printf("%-6s %-10s %-14s %-20s %-1s\n", "Task#", "Done?", "Due Date", "Team Member", "Description");
		System.out.println(taskList.toString().replace("[", "").replace("]", "").replace(",", ""));
		System.out.println();
		return taskList;
	}

	public ArrayList<Task> choiceAdd(ArrayList<Task> taskList) {
		System.out.println("Adding a new task. Enter information below:");
		taskBuilder(taskList);
		System.out.println("Task added!\n");
		return taskList;
	}

	public ArrayList<Task> choiceDelete(ArrayList<Task> taskList) {
		System.out.println(taskList.toString().replace("[", "").replace("]", "").replace(",", ""));
		System.out.println();
		taskNumber = Validator.getInt(scan, "Choose a task to delete: ");
		confirm = Validator.getStringMatchingRegex(scan, "Are you sure? (y/n) ", "[YyNn]");
		if (confirm.equalsIgnoreCase("y")) {
			taskNumber--;
			taskList.remove(taskNumber);			
		}
		confirm = "n";
		return taskList;
	}

	public ArrayList<Task> choiceComplete(ArrayList<Task> taskList) {
		taskNumber = Validator.getInt(scan, "Choose a task to mark as complete: ");
		confirm = Validator.getStringMatchingRegex(scan, "Are you sure? (y/n) ", "[YyNn]");
		if (confirm.equalsIgnoreCase("y")) {
			taskNumber--;
			taskList.get(taskNumber);
			Task newTask = new Task(i, true, memberName, ld, description);
			taskList.remove(taskNumber);
			taskList.add(taskNumber, newTask);
		}
		confirm = "n";
		return taskList;
	}

}
