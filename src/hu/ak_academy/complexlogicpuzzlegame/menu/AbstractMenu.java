package hu.ak_academy.complexlogicpuzzlegame.menu;

public abstract class AbstractMenu implements MenuOption {

	@Override
	public String toString() {
		return getOptionNumber() + " - " + getName() + "\n";
	}

}
