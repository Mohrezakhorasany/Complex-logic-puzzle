package hu.ak_academy.complexlogicpuzzlegame.shape;

import hu.ak_academy.complexlogicpuzzlegame.Board;
import hu.ak_academy.complexlogicpuzzlegame.Coordinates;

public abstract class AbstractShape implements Shape {

	protected Board board;
	protected boolean processOverflowing;

	public AbstractShape(Board board, boolean processOverflowing) {
		this.board = board;
		this.processOverflowing = processOverflowing;
	}

	@Override
	public void changeState(Coordinates coordinates) {
		if (board.getMark(coordinates)
				.equals("+")) {
			board.setMark(coordinates, "-");
		} else {
			board.setMark(coordinates, "+");
		}
	}

	@Override
	public boolean checkCondition(Coordinates coordinates) {
		return coordinates.getColumn() < board.getTableDimension()
				.getWidth() && coordinates.getColumn() >= 0 && coordinates.getRow() < board.getTableDimension()
						.getHeight()
				&& coordinates.getRow() >= 0;
	}

	@Override
	public Coordinates adjustCoordinates(Coordinates userGiven) {
		int column = userGiven.getColumn();
		int row = userGiven.getRow();
		return new Coordinates(row < 0 ? row + board.getTableDimension()
				.getHeight()
				: row > board.getTableDimension()
						.getHeight() - 1 ? row - row : row,
				column < 0 ? column + board.getTableDimension()
						.getWidth()
						: column >= board.getTableDimension()
								.getWidth() ? column
										- board.getTableDimension()
												.getWidth()
										: column);
	}

	@Override
	public void turn(Coordinates[] coordinatesToCheck) {
		for (Coordinates coordinate : coordinatesToCheck) {
			if (checkCondition(coordinate)) {
				changeState(coordinate);
			} else {
				if (processOverflowing) {
					changeState(adjustCoordinates(coordinate));
				}
			}
		}
	}

}
