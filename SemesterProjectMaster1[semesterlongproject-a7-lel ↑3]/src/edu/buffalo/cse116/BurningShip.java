package edu.buffalo.cse116;

import java.awt.event.ActionEvent;//hola
import java.awt.event.ActionListener;

/**
 * this class will update and display image of BurningShip Set.
 * @author 72471
 *
 */
public class BurningShip implements ActionListener{
	
	/**	 * _main will perform the action of updating BurningShip Set using updated esDistance in Main method.	 */
	private Main _main;
	
	/**
	 * create a new ActionListener which can be used to recalculate and redraw BurningShip Set.
	 * @param main A Main class which was associated with UI class.
	 */
	public BurningShip(Main main){
		_main = main;
	}
	
	/**
	 * perform the method in _main with initialized number 2, and recalculate and redraw BurningShip Set.
	 */
	public void actionPerformed(ActionEvent ae){
		_main.updateBurningShip(2.0);
	}

}
