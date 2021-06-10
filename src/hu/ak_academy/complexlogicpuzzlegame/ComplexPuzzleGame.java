package hu.ak_academy.complexlogicpuzzlegame;

import java.util.Scanner;

import hu.ak_academy.complexlogicpuzzlegame.menu.CircleSignMenuOption;
import hu.ak_academy.complexlogicpuzzlegame.menu.Menu;
import hu.ak_academy.complexlogicpuzzlegame.menu.MenuOption;
import hu.ak_academy.complexlogicpuzzlegame.menu.MenuOptionOverFlowing;
import hu.ak_academy.complexlogicpuzzlegame.menu.PlusSignMenuOption;
import hu.ak_academy.complexlogicpuzzlegame.menu.ProcessOverFlowMenuOption;
import hu.ak_academy.complexlogicpuzzlegame.menu.SkipOverFlowMenuOption;
import hu.ak_academy.complexlogicpuzzlegame.menu.SquareSignMenuOption;
import hu.ak_academy.complexlogicpuzzlegame.menu.TriangleSignMenuOption;

public class ComplexPuzzleGame {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			UserInputHandler inputHandler = new UserInputHandler(scanner);
			TableDimension tableSize = inputHandler.readTableDimension();
			Board board = new Board(tableSize);
			MenuOption[] menuOptions = { new PlusSignMenuOption(), new SquareSignMenuOption(), new CircleSignMenuOption(), new TriangleSignMenuOption() };
			MenuOptionOverFlowing[] menuOptionsOverFlowing = { new SkipOverFlowMenuOption(), new ProcessOverFlowMenuOption() };
			Menu menu = new Menu(menuOptions, inputHandler, menuOptionsOverFlowing, board);
			boolean isItStillRunnig = true;
			while (isItStillRunnig) {
				System.out.println(menu);
				isItStillRunnig = menu.choose();
			}
			System.out.println("Good Bye!");
		}

	}

}
