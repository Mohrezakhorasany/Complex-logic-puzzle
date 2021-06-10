package hu.ak_academy.complexlogicpuzzlegame;

public class PuzzleSolver {

	private Puzzle puzzleToSolve;
	private int score = 0;

	public PuzzleSolver(Puzzle puzzle) {
		this.puzzleToSolve = puzzle;
	}

	public void turnSwitch(Coordinates coordinates) {
		puzzleToSolve.choose(coordinates);
		score++;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
