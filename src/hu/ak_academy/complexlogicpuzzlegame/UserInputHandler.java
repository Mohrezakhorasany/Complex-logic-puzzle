package hu.ak_academy.complexlogicpuzzlegame;

import java.util.Scanner;

import hu.ak_academy.complexlogicpuzzlegame.validator.TableDimensionValidator;

public class UserInputHandler {

	private Scanner input;

	public UserInputHandler(Scanner scanner) {
		this.input = scanner;
	}

	public int chooseWhichOption() {
		int number = isValidMenuOption();
		return number;
	}

	private int isValidMenuOption() {
		int number;
		do {
			System.out.println("Please enter your choice: ");
			while (!input.hasNextInt()) {
				System.out.println("Incorrect option, you have choose between 1 to 2.");
				input.next();
			}
			number = input.nextInt();
		} while (number > 4 || number < 1);
		return number;
	}

	public Coordinates readCoordinates() {
		System.out.print("Please provide next row: ");
		int row = input.nextInt();
		input.nextLine();
		System.out.print("Please provide next column: ");
		int column = input.nextInt();
		input.nextLine();
		return new Coordinates(row - 1, column - 1);
	}

	public boolean processOverflowing() {
		return isValidMenuOption() == 2 ? true : false;
	}

	public TableDimension readTableDimension() {
		boolean tableDimensionValid;
		TableDimension tableDimension;
		do {
			System.out.print("Please provide the height of the table: ");
			int height = input.nextInt();
			input.nextLine();
			System.out.println("Please provide the width of the table: ");
			int width = input.nextInt();
			input.nextLine();
			tableDimension = new TableDimension(height, width);
			TableDimensionValidator tableDimensionValidator = new TableDimensionValidator(tableDimension);
			tableDimensionValid = tableDimensionValidator.isValid();
			if (!tableDimensionValid) {
				System.out.println(tableDimensionValidator.getErrorMessage());
			}
		} while (!tableDimensionValid);
		return tableDimension;
	}

}
