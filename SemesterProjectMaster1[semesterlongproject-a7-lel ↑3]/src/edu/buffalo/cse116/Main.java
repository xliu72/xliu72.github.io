package edu.buffalo.cse116;

import java.util.Arrays;
import javax.swing.JTextField;

/**
 * this class do calculating escape time, translating index to coordinates,
 * adding escape time to 2-d array, translating text to number of type double, 
 * and updating escape distance.
 * @author 72471
 *
 */
public class Main {
	
	/**	 * associate class UI with class Main to execute method in UI.	 */
	UI ui;
	
	/**	 * a 2-d array of type int[][] which will be filled in escape time of fractals.	 */
	int[][] array = new int[512][512];// initiate a 2-d array of size 512*512
	
	/**	 * a number typed of int will change it's value as any fractal is selected.	 */
	int fractal;
	
	/**	 * a number of type double which will changed to the number as same as the valid positive number user inputed.	 */
	double esDistance = 2.0;
	
	/**	 
	 * * allows UI to observe method done in Main and execute corresponding method in UI.
	 * @param ui2 class typed of UI will be assigned to instance variable ui.
	 */
	
	public void addObserver(UI ui2) {
		ui = ui2;
		// TODO Auto-generated method stub	
	}
	/**
	 * This method is used to calculate the escape time of every point out of 512*512 points of Mandelbrot Set.
	 * By calling mandelbrotSet()(which calculate the escape time of one point) in two loops,
	 * all the escape time of every point are added it to corresponding place in 2-d array.
	 * @param esd of type double, is the escape distance which influences value of escape time.
	 * @return the 2-d array in which are all the escape time of corresponding point.
	 */
	public int[][] mandelbrotSetArray(double esd){// add mandelbrot set's escape-time of every pixel in the 2-d array
		for(int r=0;r<=511;r++){
			for(int c=0;c<=511;c++){
				double xCrt = translateXmandelbrotSet(r);
				double yCrt = translateYmandelbrotSet(c);
				array[r][c] = mandelbrotSet(xCrt, yCrt,esd);
			}
		}		
		return array;
	}
	/**
	 * This method is used to translate the row index of point in the 2-d array of Mandelbrot Set
	 * to the point's current x-coordinate based on the range of x's value.
	 * @param row of type int, is the row index of a point in 2-d array.
	 * @return returns the value of current x-coordinate of the point.
	 */
	public double translateXmandelbrotSet(int row){
		double xCrt = -2.15 + ((2.75)/511)*row;
		return xCrt;
	}
	/**
	 * This method is used to translate the column index of escape time in the 2-d array of Mandelbrot Set
	 * to the point's current y-coordinate based on the range of x's value.
	 * @param col of type int, is the column index of a point in 2-d array.
	 * @return returns the value of current y-coordinate of the point.
	 */
	public double translateYmandelbrotSet(int col){
		double yCrt = -1.3 + ((2.6)/511)*col;
		return yCrt;
	}
	/**
	 * This method will calculate the escape time of a point with a certain escape distance.
	 * @param xCrt of type double, is the x-coordinate of a specific point of Mandelbrot Set.
	 * @param yCrt of type double, is the y-coordinate of a specific point of Mandelbrot Set.
	 * @param esd the escape distance which influences value of escape time.
	 * @return return the value of escape time of the point with the escape distance.
	 */
	public int mandelbrotSet(double xCrt, double yCrt,double esd){// find madelbrot set's escape-time of a current coordinate 
		double xCalc = xCrt;
		double yCalc = yCrt;
		double dist = Math.sqrt(xCalc*xCalc + yCalc*yCalc);
		int passes = 0;	
		while(dist<=esd && passes <255){			
			double xCalc1 = xCalc*xCalc - yCalc*yCalc + xCrt;
			double yCalc1 = 2*xCalc*yCalc + yCrt;
			xCalc = xCalc1;
			yCalc = yCalc1;
			passes = passes + 1;
			dist = Math.sqrt(xCalc*xCalc + yCalc*yCalc);
		}
		return passes;
	}
	
	/**
	 * This method is used to calculate the escape time of every point out of 512*512 points of Julia Set.
	 * By calling JuliaSet()(which calculate the escape time of one point) in two loops,
	 * all the escape time of every point are added it to corresponding place in 2-d array.
	 * @param esd of type double, is the escape distance which influences value of escape time.
	 * @return the 2-d array in which are all the escape time of corresponding point.
	 */
	public int[][] juliaSetArray(double esd){
		for(int r=0;r<=511;r++){
			for(int c=0;c<=511;c++){
				double xCrt = translateXjuliaSet(r);
				double yCrt = translateYjuliaSet(c);
				array[r][c] = juliaSet(xCrt, yCrt,esd);
			}
		}		
		return array;
	}
	/**
	 * This method is used to translate the row index of point in the 2-d array of Julia Set
	 * to the point's current x-coordinate based on the range of x's value.
	 * @param row of type int, is the row index of a point in 2-d array.
	 * @return returns the value of current x-coordinate of the point.
	 */
	public double translateXjuliaSet(int row){
		double xCrt = -1.7 + ((3.4)/511)*row;
		return xCrt;
	}
	
	/**
	 * This method is used to translate the column index of escape time in the 2-d array of Julia Set
	 * to the point's current y-coordinate based on the range of x's value.
	 * @param col of type int, is the column index of a point in 2-d array.
	 * @return returns the value of current y-coordinate of the point.
	 */
	public double translateYjuliaSet(int col){
		double yCrt = -1.0 + ((2.0)/511)*col;
		return yCrt;
	}
	
	/**
	 * This method will calculate the escape time of a point with a certain escape distance.
	 * @param xCrt of type double, is the x-coordinate of a specific point of Julia Set.
	 * @param yCrt of type double, is the y-coordinate of a specific point of Julia Set.
	 * @param esd the escape distance which influences value of escape time.
	 * @return return the value of escape time of the point with the escape distance.
	 */
	public int juliaSet(double xCrt, double yCrt,double esd){
		double xCalc = xCrt;
		double yCalc = yCrt;
		double dist = Math.sqrt(xCalc*xCalc + yCalc*yCalc);
		int passes = 0;	
		while(dist<=esd && passes <255){			
			double xCalc1 = xCalc*xCalc - yCalc*yCalc + -0.72689;
			double yCalc1 = 2*xCalc*yCalc + 0.188887;
			xCalc = xCalc1;
			yCalc = yCalc1;
			passes = passes + 1;
			dist = Math.sqrt(xCalc*xCalc + yCalc*yCalc);
		}
		return passes;		
	}
	
	/**
	 * This method is used to calculate the escape time of every point out of 512*512 points of BurningShip Set.
	 * By calling BurningShipSet()(which calculate the escape time of one point) in two loops,
	 * all the escape time of every point are added it to corresponding place in 2-d array.
	 * @param esd of type double, is the escape distance which influences value of escape time.
	 * @return the 2-d array in which are all the escape time of corresponding point.
	 */
	public int[][] burningShipSetArray(double esd){// add burningship set's escape-time of every pixel in the 2-d array
		for(int r=0;r<=511;r++){
			for(int c=0;c<=511;c++){
				double xCrt = translateXburningShipSet(r);
				double yCrt = translateYburningShipSet(c);
				array[r][c] = burningShipSet(xCrt, yCrt,esd);
			}
		}		
		return array;
	}
	
	/**
	 * This method is used to translate the row index of point in the 2-d array of BurningShip Set
	 * to the point's current x-coordinate based on the range of x's value.
	 * @param row of type int, is the row index of a point in 2-d array.
	 * @return returns the value of current x-coordinate of the point.
	 */
	public double translateXburningShipSet(int row){
		double xCrt = -1.8 + ((0.1)/511)*row;
		return xCrt;
	}
	
	/**
	 * This method is used to translate the column index of escape time in the 2-d array of BurningShip Set
	 * to the point's current y-coordinate based on the range of x's value.
	 * @param col of type int, is the column index of a point in 2-d array.
	 * @return returns the value of current y-coordinate of the point.
	 */
	public double translateYburningShipSet(int col){
		double yCrt = -0.08 + ((0.105)/511)*col;
		return yCrt;
	}

	/**
	 * This method will calculate the escape time of a point with a certain escape distance.
	 * @param xCrt of type double, is the x-coordinate of a specific point of BurningShip Set.
	 * @param yCrt of type double, is the y-coordinate of a specific point of BurningShip Set.
	 * @param esd the escape distance which influences value of escape time.
	 * @return return the value of escape time of the point with the escape distance.
	 */
	public int burningShipSet(double xCrt, double yCrt,double esd){// find burningship set's escape-time of a current coordinate 
		double xCalc = xCrt;
		double yCalc = yCrt;
		double dist = Math.sqrt(xCalc*xCalc + yCalc*yCalc);
		int passes = 0;	
		while(dist<=esd && passes <255){			
			double xCalc1 = xCalc*xCalc - yCalc*yCalc + xCrt;
			double yCalc1 = Math.abs(2*xCalc*yCalc) + yCrt;
			xCalc = xCalc1;
			yCalc = yCalc1;
			passes = passes + 1;
			dist = Math.sqrt(xCalc*xCalc + yCalc*yCalc);
		}
		return passes;		
	}
	
	/**
	 * This method will be used to test that none of the pixels in the BurningShip Set has
	 * escape time of 0 if the escape distance is 2.0;
	 * @return return if none of the pixels in the BurningShip Set has escape time of 0 if the escape distance is 2.0;
	 */
	public boolean burningShipSetNoneZero(){
		burningShipSetArray(2.0);
		return !Arrays.asList(array).contains(0);
	}
	
	/**
	 * This method will be used to test that none of the pixels in the BurningShip Set has
	 * escape time of 1 if the escape distance is 2.0;
	 * @return return if none of the pixels in the BurningShip Set has escape time of 1 if the escape distance is 2.0;
	 */
	public boolean burningShipSetNoneOne(){
		burningShipSetArray(2.0);
		return !Arrays.asList(array).contains(1);
	}
	
	/**
	 * This method is used to calculate the escape time of every point out of 512*512 points of Multibrot Set.
	 * By calling MultibrotSet()(which calculate the escape time of one point) in two loops,
	 * all the escape time of every point are added it to corresponding place in 2-d array.
	 * @param esd of type double, is the escape distance which influences value of escape time.
	 * @return the 2-d array in which are all the escape time of corresponding point.
	 */
	public int[][] multibrotSetArray(double esd){// add multibrot set's escape-time of every pixel in the 2-d array
		for(int r=0;r<=511;r++){
			for(int c=0;c<=511;c++){
				double xCrt = translateXmultibrotSet(r);
				double yCrt = translateYmultibrotSet(c);
				array[r][c] = multibrotSet(xCrt, yCrt,esd);
			}
		}		
		return array;
	}
	/**
	 * This method is used to translate the row index of point in the 2-d array of Multibrot Set
	 * to the point's current x-coordinate based on the range of x's value.
	 * @param row of type int, is the row index of a point in 2-d array.
	 * @return returns the value of current x-coordinate of the point.
	 */
	public double translateXmultibrotSet(int row){
		double xCrt = -1.0 + ((2.0)/511)*row;
		return xCrt;
	}
	
	/**
	 * This method is used to translate the column index of escape time in the 2-d array of Multibrot Set
	 * to the point's current y-coordinate based on the range of x's value.
	 * @param col of type int, is the column index of a point in 2-d array.
	 * @return returns the value of current y-coordinate of the point.
	 */
	public double translateYmultibrotSet(int col){
		double yCrt = -1.3 + ((2.6)/511)*col;
		return yCrt;
	}
	
	/**
	 * This method will calculate the escape time of a point with a certain escape distance.
	 * @param xCrt of type double, is the x-coordinate of a specific point of Multibrot Set.
	 * @param yCrt of type double, is the y-coordinate of a specific point of Multibrot Set.
	 * @param esd the escape distance which influences value of escape time.
	 * @return return the value of escape time of the point with the escape distance.
	 */
	public int multibrotSet(double xCrt, double yCrt,double esd){// find multibrot set's escape-time of a current coordinate 
		double xCalc = xCrt;
		double yCalc = yCrt;
		double dist = Math.sqrt(xCalc*xCalc + yCalc*yCalc);
		int passes = 0;	
		while(dist<=esd && passes <255){			
			double xCalc1 = xCalc*xCalc*xCalc - 3*xCalc*yCalc*yCalc + xCrt;
			double yCalc1 = 3*xCalc*xCalc*yCalc-yCalc*yCalc*yCalc + yCrt;
			xCalc = xCalc1;
			yCalc = yCalc1;
			passes = passes + 1;
			dist = Math.sqrt(xCalc*xCalc + yCalc*yCalc);
		}
		return passes;		
	}
	
	/**
	 * this method was called when a fractal is selected or when a positive number typed double is inputed.
	 * Esd is a fixed number 2.0 of type double.
	 * If updated instance variable esDistance is not equals to 2.0(which means there's no input to change escape distance),
	 * esd will be updated to the inputed number.
	 * @param esd a fixed number 2.0 of type double.
	 */
	public void updateMandelbrot(double esd){
		if(esDistance != esd){
			esd = esDistance;
		}
		if(ui != null){
			ui.updateMandelbrot(esd);
			fractal = 1;
		}
	}
	/**
	 * this method was called when a fractal is selected or when a positive number typed double is inputed.
	 * Esd is a fixed number 2.0 of type double.
	 * If updated instance variable esDistance is not equals to 2.0(which means there's no input to change escape distance),
	 * esd will be updated to the inputed number.
	 * @param esd a fixed number 2.0 of type double.
	 */

	public void updateJulia(double esd){
		if(esDistance != esd){
			esd = esDistance;
		}
		if(ui != null){
			ui.updateJulia(esd);
			fractal = 2;
		}
	}
	
	/**
	 * this method was called when a fractal is selected or when a positive number typed double is inputed.
	 * Esd is a fixed number 2.0 of type double.
	 * If updated instance variable esDistance is not equals to 2.0(which means there's no input to change escape distance),
	 * esd will be updated to the inputed number.
	 * @param esd a fixed number 2.0 of type double.
	 */
	public void updateBurningShip(double esd){
		if(esDistance != esd){
			esd = esDistance;
		}
		if(ui != null){
			ui.updateBurningShip(esd);
			fractal = 3;
		}
	}
	
	/**
	 * this method was called when a fractal is selected or when a positive number typed double is inputed.
	 * Esd is a fixed number 2.0 of type double.
	 * If updated instance variable esDistance is not equals to 2.0(which means there's no input to change escape distance),
	 * esd will be updated to the inputed number.
	 * @param esd a fixed number 2.0 of type double.
	 */
	public void updateMultibrot(double esd){
		if(esDistance != esd){
			esd = esDistance;
		}
		if(ui != null){
			ui.updateMultibrot(esd);
			fractal = 4;
		}
	}
	
	/**
	 * the method is used to translate the jtext user inputed in JTextField appears on JFrame.
	 * the jtext must be a valid number to be translated to a number of type double.
	 * if the input is invalid, reportError() in class UI will be called to pop out a new jframe, reporting the error.
	 * @param jtext type of JTextField, the number users inputed in JTextField.
	 * @return type of double, returns the translated number from jtext if it's valid.
	 */
	public double getDouble(JTextField jtext){
    	try{
    		esDistance = Double.parseDouble(jtext.getText());
    	}
    	catch(NumberFormatException nfe){
			ui.reportError();//a new jframe pop out reporting the error;
    	}
    	return esDistance;   	
	}
	
	/**
	 * using translated number of type double from method getDouble().
	 * if the number is negative or 0, a method in class UI named reportError() will be called to report the error.
	 * if the number is positive, the latest chosen fractal will be updated using the the updated escape distance.
	 * And picture of updated fractal will also be displayed on JFrame.
	 * Which fractal will be updated depends on the latest chosen fractal. This was detected through updated number named fractal.
	 * @param esDistance typed of double, the valid escape Distance user inputed.
	 */
	public void setEscapeDistance(double esd) {
		if(esd<= 0){
			esd = 0;
			ui.reportError();//a new jframe pop out reporting the error;
		}
		else{
			if(fractal==1){
				this.updateMandelbrot(esd);
			}
			else if(fractal==2){
				this.updateJulia(esd);
			}
			else if(fractal==3){
				this.updateBurningShip(esd);
			}
			else if(fractal==4){
				this.updateMultibrot(esd);
			}
		}				
	}
	
}
