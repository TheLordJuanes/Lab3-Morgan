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

public class Load {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	public final static String TYPE_LOAD1 = "PERISHABLE";
	public final static String TYPE_LOAD2 = "NO PERISHABLE";
	public final static String TYPE_LOAD3 = "DANGEROUS";
	public final static int PRICE_DANGEROUS = 390000;
	public final static int PRICE_PERISHABLE = 250000;
	public final static int PRICE_NO_PERISHABLE = 80000;
	public final static int NUM_CLIENTS=5;

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	private int numBoxesToTransp;
	private double boxWeight;
	private String typeLoad;

	// -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

	private Client owner;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/**
	 * Constructor method of a load.
	 * @param numBoxesToTransp
	 * @param boxWeigth
	 * @param typeLoad
	 */
	public void Load(int numBoxesToTransp, double boxWeight, String typeLoad) {
		this.numBoxesToTransp=numBoxesToTransp;
		this.boxWeight=boxWeight;
		this.typeLoad=typeLoad;
		owner=new Client[NUM_CLIENTS];
	}

	/**
	 * This method returns the box weight.
	 */
	public double getBoxWeight() {
		return this.boxWeight;
	}

	/**
	 *
	 * @param boxWeight
	 */
	public void setBoxWeight(double boxWeight) {
		this.boxWeight = boxWeight;
	}

	/**
	 * This method returns the Load's type.
	 */
	public String getTypeLoad() {
		return this.typeLoad;
	}

	/**
	 *
	 * @param typeLoad
	 */
	public void setTypeLoad(String typeLoad) {
		this.typeLoad = typeLoad;
	}

	/**
	 * This method returns the number of boxes to transport.
	 */
	public int getNumBoxesToTransp() {
		return this.numBoxesToTransp;
	}

	/**
	 *
	 * @param numBoxesToTransp
	 */
	public void setNumBoxesToTransp(int numBoxesToTransp) {
		this.numBoxesToTransp = numBoxesToTransp;
	}

	/**
	 * This method calculates the total weight of a Load.
	 */
	public double calculateTotalWeightLoad() {     //Sum of the boxes weigths
		double totalWeight=0;
		return totalWeight;
	}

	public String printTotalWeightLoad() {
		String print1="";
		return print1;
	}

	/**
	 * This method calculates the total transportation price of a Load.
	 * @param typeClient
	 */
	public double calculateTotalPriceLoadTransportation(String typeClient) {
		double totalPrice=0;
		return totalPrice;
	}

	/**
	 * This method prints the total transportation price of a Load.
	 */
	public String printTotalPriceLoadTransportation() {
		String print2="";
		return print2;
	}
}
