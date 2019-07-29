package co.grandcircus;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> menu = new ArrayList<>();
		Task menuChoice = new Task();
		ArrayList<Task> taskList = new ArrayList<>();
		int choice = 0;
		boolean cont = true;
		String confirm = "n";

		System.out.println("Welcome to Task Manager!");
		buildList(menu);
		while (cont) {
			displayList(menu);
			choice = Validator.getInt(scan, "Please select an option: ", 1, 5);

			switch (choice) {
			case 1:
				menuChoice.choiceList(taskList);
				break;
			case 2:
				menuChoice.choiceAdd(taskList);
				break;
			case 3:
				menuChoice.choiceDelete(taskList);
				break;
			case 4:
				menuChoice.choiceComplete(taskList);
				break;
			case 5:
				cont = false;
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}
		System.out.println("Exiting!");
	}

	// build command menu
	public static ArrayList<String> buildList(ArrayList<String> menu) {
		menu.add("1. List Tasks");
		menu.add("2. Add Task");
		menu.add("3. Delete Task");
		menu.add("4. Mark Task Complete");
		menu.add("5. Exit");
		return menu;
	}

	// display command menu
	public static ArrayList<String> displayList(ArrayList<String> menu) {
		for (int i = 0; i < menu.size(); i++) {
			System.out.println(menu.get(i));
		}
		return menu;
	}
}
