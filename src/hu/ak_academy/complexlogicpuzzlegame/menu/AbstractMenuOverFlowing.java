package hu.ak_academy.complexlogicpuzzlegame.menu;

public abstract class AbstractMenuOverFlowing implements MenuOptionOverFlowing {

	@Override
	public String toString() {
		return getOptionNumber() + " - " + getName() + "\n";
	}

}
