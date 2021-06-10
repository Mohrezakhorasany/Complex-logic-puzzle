package hu.ak_academy.complexlogicpuzzlegame.shape;

import hu.ak_academy.complexlogicpuzzlegame.Board;
import hu.ak_academy.complexlogicpuzzlegame.Coordinates;

public class MaskCircleSign extends AbstractShape {

	public MaskCircleSign(Board board, boolean processOverflowing) {
		super(board, processOverflowing);
	}

	@Override
	public void getCoordinates(Coordinates userGivenCoordinates) {
		int row = userGivenCoordinates.getRow();
		int column = userGivenCoordinates.getColumn();
		Coordinates[] coordinatesToCheck = { new Coordinates(row, column), new Coordinates(row, column + 1), new Coordinates(row, column + 2), new Coordinates(row, column - 1), new Coordinates(row, column - 2), new Coordinates(row + 1, column),
				new Coordinates(row + 1, column + 1), new Coordinates(row + 1, column - 1), new Coordinates(row - 1, column), new Coordinates(row - 1, column + 1), new Coordinates(row - 1, column - 1) };
		turn(coordinatesToCheck);
	}

}
