package hu.ak_academy.complexlogicpuzzlegame.shape;

import hu.ak_academy.complexlogicpuzzlegame.Coordinates;

public interface Shape {

	void changeState(Coordinates coordinates);

	void getCoordinates(Coordinates userGivenCoordinates);

	boolean checkCondition(Coordinates coordinates);

	Coordinates adjustCoordinates(Coordinates userGiven);

	void turn(Coordinates[] coordinatesToCheck);

}
