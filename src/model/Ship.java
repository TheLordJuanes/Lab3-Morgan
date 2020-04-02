/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Subject: Algorithms and Programming I
 * Laboratory Unit 3 Solution
 * Student Code: A00365977
 * @Author: Juan Esteban Caicedo A.
 * @Date: April, 8th 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package model;

import java.util.ArrayList;

public class Ship {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	public final static int MAX_LOAD_WEIGHT = 28000;
	public final static int MIN_LOAD_WEIGHT = 12000;
	public final static int MIN_LOAD_SHIP = 2;

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	//Name of the ship
	private String nameShip;

	// -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

	private ArrayList<Load> loads;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/**
	 * Constructor method of a ship.
	 * @param nameShip
	 */
	public void Ship(String nameShip) {
		this.nameShip=nameShip;
		loads=new ArrayList<Load>();
	}

	/**
	 * This method determines the total number of loads in the ship.
	 */
	public int calculateNumloads(){
		int num=0;
		num=loads.size();
		return num;
	}

	/**
	 * This method discharges the ship.
	 */
	public boolean dischargeTheShip() {
		boolean discharged=false;
		for (int i=0; i<loads.size;i++){
				loads.clear();
		}
			discharged=true;
		return discharged;
	}

	/**
	 * This method loads the ship.
	 * @param numBoxesToTransp
	 * @param boxWeight
	 * @param typeLoad
	 * @param nameClient
	 */
	public Load loadTheShip(int numBoxesToTransp, double boxWeight, String typeLoad){
		Load objLoad=null;
		return objLoad;
		}
		public Load sameBoxesWeight2(int numBoxesToTransp, double boxWeight){
			Load objsamew = null;
			return objsamew;
}
