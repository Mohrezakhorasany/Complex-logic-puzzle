package hu.ak_academy.complexlogicpuzzlegame.shape;

import hu.ak_academy.complexlogicpuzzlegame.Board;
import hu.ak_academy.complexlogicpuzzlegame.Coordinates;

public class MaskSquareSign extends AbstractShape {

	public MaskSquareSign(Board board, boolean processOverflowing) {
		super(board, processOverflowing);
	}

	@Override
	public void getCoordinates(Coordinates userGivenCoordinate) {
		Coordinates[] coordinatesToCheck = { userGivenCoordinate, new Coordinates(userGivenCoordinate.getRow(), userGivenCoordinate.getColumn() + 1), new Coordinates(userGivenCoordinate.getRow() + 1, userGivenCoordinate.getColumn() + 1),
				new Coordinates(userGivenCoordinate.getRow() - 1, userGivenCoordinate.getColumn() + 1), new Coordinates(userGivenCoordinate.getRow(), userGivenCoordinate.getColumn() - 1),
				new Coordinates(userGivenCoordinate.getRow() - 1, userGivenCoordinate.getColumn() - 1), new Coordinates(userGivenCoordinate.getRow() + 1, userGivenCoordinate.getColumn() - 1),
				new Coordinates(userGivenCoordinate.getRow() + 1, userGivenCoordinate.getColumn()), new Coordinates(userGivenCoordinate.getRow() - 1, userGivenCoordinate.getColumn()) };
		turn(coordinatesToCheck);
	}

}
