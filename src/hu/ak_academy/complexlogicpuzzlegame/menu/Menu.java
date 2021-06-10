package hu.ak_academy.complexlogicpuzzlegame.menu;

import hu.ak_academy.complexlogicpuzzlegame.Board;
import hu.ak_academy.complexlogicpuzzlegame.Coordinates;
import hu.ak_academy.complexlogicpuzzlegame.Puzzle;
import hu.ak_academy.complexlogicpuzzlegame.PuzzleGenerator;
import hu.ak_academy.complexlogicpuzzlegame.PuzzleSolver;
import hu.ak_academy.complexlogicpuzzlegame.UserInputHandler;
import hu.ak_academy.complexlogicpuzzlegame.validator.BoardBoundValidator;

public class Menu {
	private MenuOption[] menuOptions;
	private UserInputHandler userInput;
	private MenuOptionOverFlowing[] menuOptionsOverFlowing;
	private Board board;

	public Menu(MenuOption[] menuOptions, UserInputHandler userInput, MenuOptionOverFlowing[] menuOptionsOverFlowing, Board board) {
		this.menuOptions = menuOptions;
		this.userInput = userInput;
		this.menuOptionsOverFlowing = menuOptionsOverFlowing;
		this.board = board;
	}

	public boolean choose() {
		int userChoice = userInput.chooseWhichOption();
		PuzzleGenerator puzzleGenerator = new PuzzleGenerator();
		for (MenuOptionOverFlowing menuOptionOverFlowing : menuOptionsOverFlowing) {
			System.out.print(menuOptionOverFlowing);
		}
		boolean processOverFlowing = userInput.processOverflowing();
		Puzzle puzzle = puzzleGenerator.generate(board, 10, userChoice, processOverFlowing);
		PuzzleSolver solver = new PuzzleSolver(puzzle);
		Coordinates coordinates;
		do {
			System.out.println(board);
			coordinates = userInput.readCoordinates();
			if (coordinates.getRow() + 1 == 0 && coordinates.getColumn() + 1 == 0) {
				return false;
			}
			BoardBoundValidator boardBoundValidator = new BoardBoundValidator(board.getTableDimension(), coordinates);
			if (!boardBoundValidator.isValid()) {
				System.out.println(boardBoundValidator.getErrorMessage());
				continue;
			}
			solver.turnSwitch(coordinates);
		} while (!puzzle.isSolved());
		return false;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Welcome to the Complex logic puzzle game ");
		stringBuilder.append("\n");
		stringBuilder.append("\n");
		stringBuilder.append("You need to choose the inversion mask type first, after that The program will give you an option to choose how to handle the overflow.");
		stringBuilder.append("\n");
		stringBuilder.append("\n");
		stringBuilder.append("And by giving the row and the column, neighboring cells will change their state according to mask type. ");
		stringBuilder.append("\n");
		stringBuilder.append("\n");
		stringBuilder.append("The game will finish either by turning all the cells state to positive which is winning criteria or by entering 0 for both row and the column, which indicates you would like to quit the game..");
		stringBuilder.append("\n");
		stringBuilder.append("\n");
		stringBuilder.append("\n");
		stringBuilder.append("Good luck!");
		stringBuilder.append("\n");
		stringBuilder.append("\n");
		for (MenuOption menuOption : menuOptions) {
			stringBuilder.append(menuOption);
		}
		return stringBuilder.toString();
	}

}
