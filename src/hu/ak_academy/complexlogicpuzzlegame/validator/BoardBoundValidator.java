package hu.ak_academy.complexlogicpuzzlegame.validator;

import hu.ak_academy.complexlogicpuzzlegame.Coordinates;
import hu.ak_academy.complexlogicpuzzlegame.TableDimension;

public class BoardBoundValidator implements UserInputValidator {

	private final TableDimension tableSize;
	private final Coordinates coordinates;

	public BoardBoundValidator(TableDimension tableSize, Coordinates coordinates) {
		this.tableSize = tableSize;
		this.coordinates = coordinates;
	}

	@Override
	public boolean isValid() {
		return coordinates.getColumn() < tableSize.getWidth() && coordinates.getRow() < tableSize.getHeight() && coordinates.getColumn() >= 0 && coordinates.getRow() >= 0;
	}

	@Override
	public String getErrorMessage() {
		return "The coordinates are out of bounds of the board.";
	}

}
