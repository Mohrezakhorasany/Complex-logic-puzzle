package hu.ak_academy.complexlogicpuzzlegame.shape;

import hu.ak_academy.complexlogicpuzzlegame.Board;
import hu.ak_academy.complexlogicpuzzlegame.Coordinates;

public class MaskPlusSign extends AbstractShape {

	public MaskPlusSign(Board board, boolean processOverflowing) {
		super(board, processOverflowing);
	}

	@Override
	public void getCoordinates(Coordinates userGivenCoordinate) {
		Coordinates[] coordinatesToCheck = { userGivenCoordinate, new Coordinates(userGivenCoordinate.getRow(), userGivenCoordinate.getColumn() + 1), new Coordinates(userGivenCoordinate.getRow(), userGivenCoordinate.getColumn() - 1),
				new Coordinates(userGivenCoordinate.getRow() + 1, userGivenCoordinate.getColumn()), new Coordinates(userGivenCoordinate.getRow() - 1, userGivenCoordinate.getColumn()) };
		turn(coordinatesToCheck);
	}

}
