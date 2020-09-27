import java.util.List;
import java.util.Scanner;

import controller.ListMealHelper;
import model.ListMeal;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListMealHelper lmh = new ListMealHelper();

		private static void addAMeal() {
			// TODO Auto-generated method stub
			System.out.print("Enter main course: ");
			String main = in.nextLine();
			System.out.print("Enter vegetable: ");
			String vegetable = in.nextLine();
			System.out.print("Enter fruit: ");
			String fruit = in.nextLine();


			ListMeal toAdd = new ListMeal(main, vegetable, fruit);
			lmh.insertMeal(toAdd);
		}

		private static void deleteAMeal() {
			// TODO Auto-generated method stub
			System.out.print("Enter main course to delete: ");
			String main = in.nextLine();
			System.out.print("Enter vegetable to delete: ");
			String vegetable = in.nextLine();
			System.out.print("Enter fruit to delete: ");
			String fruit = in.nextLine();

			ListMeal toDelete =	new	ListMeal(main, vegetable, fruit);
			lmh.deleteMeal(toDelete);
		}

		private static void editAMeal() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Main Course");
			System.out.println("2 : Search by Vegetable");
			System.out.println("3 : Search by Fruit");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListMeal> foundMeals;
			if (searchBy == 1) {
				System.out.print("Enter the main course: ");
				String mainDesc = in.nextLine();
				foundMeals = lmh.searchForMealByMain(mainDesc);
			} else if (searchBy == 2){
				System.out.print("Enter vegetable: ");
				String vegDesc = in.nextLine();
				foundMeals = lmh.searchForMealByVegetable(vegDesc);
			} else {
				System.out.print("Enter fruit: ");
				String fruitDesc = in.nextLine();
				foundMeals = lmh.searchForMealByFruit(fruitDesc);
			}

			if (!foundMeals.isEmpty()) {
				System.out.println("Found Results.");
				for (ListMeal l : foundMeals) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListMeal toEdit = lmh.searchForMealById(idToEdit);
				System.out.println("Retrieved " + toEdit.getMain() + ", " + toEdit.getVegetable() + ", " + toEdit.getFruit());
				System.out.println("1 : Update Main Course");
				System.out.println("2 : Update Vegetable");
				System.out.println("3 : Update Fruit");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Main Course: ");
					String newMain = in.nextLine();
					toEdit.setMain(newMain);
				} else if (update == 2) {
					System.out.print("New Vegetable: ");
					String newVeg = in.nextLine();
					toEdit.setVegetable(newVeg);
				} else if (update == 3) {
					System.out.print("New Fruit: ");
					String newFruit = in.nextLine();
					toEdit.setFruit(newFruit);
				}
				

				lmh.updateMeal(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select an option:");
				System.out.println("*  1 -- Add a meal");
				System.out.println("*  2 -- Edit a meal");
				System.out.println("*  3 -- Delete a meal");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAMeal();
				} else if (selection == 2) {
					editAMeal();
				} else if (selection == 3) {
					deleteAMeal();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lmh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ListMeal> allMeals	= lmh.showAllMeals();
			for(ListMeal singleMeal : allMeals){
			System.out.println(singleMeal.returnMealDetails());
			}

		}

	}