package hu.ak_academy.complexlogicpuzzlegame;

import hu.ak_academy.complexlogicpuzzlegame.shape.MaskCircleSign;
import hu.ak_academy.complexlogicpuzzlegame.shape.MaskPlusSign;
import hu.ak_academy.complexlogicpuzzlegame.shape.MaskSquareSign;
import hu.ak_academy.complexlogicpuzzlegame.shape.MaskTriangleSign;
import hu.ak_academy.complexlogicpuzzlegame.shape.Shape;

public class Puzzle {

	private Board board;
	private int userChoiseForMask;
	private boolean processOverflowing;

	public Puzzle(Board board, int userChoiseForMask, boolean processOverflowing) {
		this.board = board;
		this.userChoiseForMask = userChoiseForMask;
		this.processOverflowing = processOverflowing;
	}

	public void choose(Coordinates coordinates) {
		Shape[] shapes = { new MaskPlusSign(board, processOverflowing), new MaskSquareSign(board, processOverflowing), new MaskCircleSign(board, processOverflowing), new MaskTriangleSign(board, processOverflowing) };
		int index = userChoiseForMask - 1;
		shapes[index].getCoordinates(coordinates);
	}

	public boolean isSolved() {
		for (int row = 0; row < board.getTableDimension()
				.getHeight(); row++) {
			for (int column = 0; column < board.getTableDimension()
					.getWidth(); column++) {
				if (board.getMark(new Coordinates(row, column))
						.equals("-")) {
					return false;
				}
			}
		}
		return true;
	}

}
