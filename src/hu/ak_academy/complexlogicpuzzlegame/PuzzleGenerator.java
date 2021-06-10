package hu.ak_academy.complexlogicpuzzlegame;

import java.util.Random;

public class PuzzleGenerator {

	public Puzzle generate(Board board, int difficulty, int userChoiceForMask, boolean willProcessOverFlowing) {
		Puzzle puzzle = new Puzzle(board, userChoiceForMask, willProcessOverFlowing);
		Random random = new Random();
		while (puzzle.isSolved()) {
			int count = 0;
			while (count < difficulty) {
				int randomNumberForRow = random.nextInt(board.getTableDimension()
						.getHeight());
				int randomNumberForColumn = random.nextInt(board.getTableDimension()
						.getWidth());
				puzzle.choose(new Coordinates(randomNumberForRow, randomNumberForColumn));
				count++;
			}
		}
		return puzzle;
	}
}
