/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Subject: Algorithms and Programming I
 * Laboratory Unit 3
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

	// Ship's maximum weight capacity.
	public final static int MAX_LOAD_WEIGHT_IN_SHIP = 28000;
	// Ship's minimum weight capacity.
	public final static int MIN_LOAD_WEIGHT_IN_SHIP = 12000;
	// Minimum number of loads in the ship to departure.
	public final static int MIN_LOAD_IN_SHIP = 2;

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	// Name of the ship.
	private String nameShip;

	// -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

	// List of the loads registered in the ship.
	private ArrayList<Load> loads;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/**
	 * Constructor method of a ship.
	 * @param nameShip - name of the ship - nameShip = String, nameShip != null, nameShip != ""
	 */
	public Ship(String nameShip) {
		this.nameShip=nameShip;
		loads=new ArrayList<Load>();
	}

	/** Name: getNameShip
	 * Method used to get the name of the ship.
	 * @return A String representing the name of the ship.
	 */
	public String getNameShip() {
		return this.nameShip;
	}

	/** Name: setNameShip
	 * Method used to update the name of the ship.
	 * @param nameShip - name of the ship - nameShip = String, nameShip != null, nameShip != ""
	 */
	public void setNameShip(String nameShip) {
		this.nameShip = nameShip;
	}

	/** Name: calculateNumloads
	 * Method used to calculate the number of loads loaded in the ship.
	 * <b>post: </b> Number of loads loaded in the ship calculated. <br>
	 * @return A whole number with the number of loads loaded in the ship.
	 */
	public int calculateNumloads(){
		int num=0;
		num=loads.size();
		return num;
	}

	/** Name: dischargeTheShip
	 * Method used to discharge the ship.
	 * <b>post: </b> Ship discharged. <br>
	 * @return A String with a message of the unloading of the ship.
	 */
	public String dischargeTheShip() {
		String message="";
		if(loads.size()==0)
				message= "There is nothing to discharge.";
			else{
				loads.clear();
				message = "The ship was successfully discharged.";
			}
		return message;
	}

	/** Name: loadTheShip
	 * Method used to load the ship.
	 * @param numBoxesToTransp - number of boxes to transport - numBoxesToTransp = int
	 * @param boxWeight - boxes weight - boxWeight = double
	 * @param typeLoad - type of a load - typeLoad = char, typeLoad != null, typeLoad != ''
	 * @param owner - load(s) owner - owner = Client, owner != null
	 * @return A String with a message confirming that a load was registered or not.
	 */
	public String loadTheShip(int numBoxesToTransp, double boxWeight, char typeLoad, Client owner){
		String message="";
		boolean stop=false;
		Load load=new Load(numBoxesToTransp,boxWeight,typeLoad,owner);
		if (load.loadWeightInKg()+totalWeightInShip()>MAX_LOAD_WEIGHT_IN_SHIP){
			message = "Loading processs interrupted! Adding this load would exceed the ship's maximum weight capacity.";
			stop=true;
		}
		else if (load.getTypeLoad()=='D' && verifyPerishableLoadType()==true){
			message="Loading processs interrupted! By health rules, your load as a Dangerous load can not be loaded in the ship because there is already a Perishable load in it.";
			stop=true;
		}
		else if (load.getTypeLoad()=='P' && verifyDangerousLoadType()==true){
			message="Loading processs interrupted! By health rules, your load as a Perishable load can not be loaded in the ship because there is already a Dangerous load in it.";
			stop=true;
		}
		if(!stop){
			loads.add(load);
			load.getOwner().setKilosTranspOverTime(load.getOwner().getKilosTranspOverTime()+load.loadWeightInKg());
			load.getOwner().setMoneyPayedOverTime(load.getOwner().getMoneyPayedOverTime()+load.calculateTotalPriceLoadTransportation());
			message="Load successfully registered.\nThe total weight of this load is "+loadWeightKg()+" kg.\nThe total price of the transportation of this load is "+calculateTotalPriceTransportation()+" pesos.\n";
			message+=clientCateg();
		}
		return message;
	}

	/** Name: totalWeightInShip
	 * Method used to calculate the current total weight in the ship.
	 * <b>post: </b> Total weight in the ship calculated. <br>
	 * @return A real number representing the total weight in the ship in kilograms.
	 */
	public double totalWeightInShip(){
		double sum=0;
		for(int i=0;i<loads.size(); i++){
			sum+=loads.get(i).loadWeightInKg();
		}
		return sum;
	}

	/** Name: calculateTotalPriceTransportation
	 * Method used to evoke the total price to pay for freight transportation determined in the class Load.
	 * @return A real number representing the total price of cargo transportation.
	 */
	public double calculateTotalPriceTransportation() {
		double price=0;
		for(int i=0;i<loads.size(); i++)
			price=loads.get(i).calculateTotalPriceLoadTransportation();
		return price;
	}

	/** Name: loadWeightInKg
	 * Method used to evoke the load weight calculation in kilograms determined in the class Load.
	 * @return A real number representing the load weight in kilograms.
	 */
	public double loadWeightKg(){
		double weight=0;
		for(int i=0;i<loads.size(); i++)
			weight=loads.get(i).loadWeightInKg();
		return weight;
	}

	/** Name: determineShipDeparture
	 * Method used to determine the ship's departure according to the loads weight and the number of loads shipped.
	 * <b>pre: </b> The load weight was already converted from grams to kilograms. The number of loads in the ship was already calculated. <br>
	 * <b>post: </b> Ship's departure determined. <br>
	 * @return A String with a message saying if the ship can departure or not.
	 */
	public String determineShipDeparture(){
		String message="";
		boolean departure=false;
		for(int i=0;i<loads.size(); i++){
		if (loads.get(i).loadWeightInKg() > MIN_LOAD_WEIGHT_IN_SHIP || calculateNumloads() >= MIN_LOAD_IN_SHIP)
			departure=true;
		}
		if(departure==true)
			message="You can departure! Number of loads you are transporting: "+calculateNumloads()+". Total weight of them: "+totalWeightInShip()+" kg.";
		else
			message="You can not departure! Minimum number of loads to be transported: "+MIN_LOAD_IN_SHIP+".\nYour current number of loads: "+calculateNumloads()+".\nMinimum total weight of the loads: "+MIN_LOAD_WEIGHT_IN_SHIP+" kg.\nYour current total weight of the loads: "+totalWeightInShip()+" kg.";
		return message;
	}

	/** Name: clientCateg
	 * Method used to evoke the client categorization determined in the class Client and evoked in the class Load.
	 * @return A String with the client company name and its category.
	 */
	public String clientCateg(){
		String category="";
		for(int i=0;i<loads.size(); i++){
			category=loads.get(i).clientCategory();
		}
		return category;
	}

	/** Name: verifyPerishableLoadType
	 * Method used to verify that there is already a Perishable load in the ship.
	 * <b>pre: </b> A Perishable load was already loaded in the ship correctly. <br>
	 * <b>post: </b> Perishable load presence verified. <br>
	 * @return True if there is already a Perishable load in the ship, or false if not.
	 */
	public boolean verifyPerishableLoadType(){
		boolean presence=false;
		for(int i=0;i<loads.size(); i++){
			if (loads.get(i).getTypeLoad()=='P')
			presence=true;
			else
			presence=false;
		}
		return presence;
	}

	/** Name: verifyDangerousLoadType
	 * Method used to verify that there is already a Dangerous load type in the ship.
	 * <b>pre: </b> A Dangerous load was already loaded in the ship correctly. <br>
	 * <b>post: </b> Dangerous load presence verified. <br>
	 * @return True if there is already a Dangerous load in the ship, or false if not.
	 */
	public boolean verifyDangerousLoadType(){
		boolean presence=false;
		for(int i=0;i<loads.size(); i++){
			if (loads.get(i).getTypeLoad()=='D')
			presence=true;
			else
			presence=false;
		}
		return presence;
	}
}
