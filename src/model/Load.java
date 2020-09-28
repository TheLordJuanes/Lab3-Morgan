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

public class Load {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	// Perishable load type.
	public final static char TYPE_LOAD1 = 'P';
	// Non-Perishable load type.
	public final static char TYPE_LOAD2 = 'N';
	// Dangerous load type.
	public final static char TYPE_LOAD3 = 'D';
	// Perishable load price.
	public final static int PRICE_PERISHABLE = 250000;
	// Non-Perishable load price.
	public final static int PRICE_NO_PERISHABLE = 80000;
	// Dangerous load price.
	public final static int PRICE_DANGEROUS = 390000;

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	// Number of boxes to transport.
	private int numBoxesToTransp;
	// Boxes weight.
	private double boxWeight;
	// Type of a load.
	private char typeLoad;

	// -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

	// Load(s) owner.
	private Client owner;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/** Name: Load
	 * Constructor method of a load.
	 * @param numBoxesToTransp - number of boxes to transport - numBoxesToTransp = int, numBoxesToTransp != 0
	 * @param boxWeight - boxes weight - boxWeight = double
	 * @param typeLoad - type of a load - typeLoad = char, typeLoad != null, typeLoad != ''
	 * @param owner - load(s) owner - owner = Client, owner != null
	 */
	public Load(int numBoxesToTransp, double boxWeight, char typeLoad,Client owner) {
		this.numBoxesToTransp=numBoxesToTransp;
		this.boxWeight=boxWeight;
		this.typeLoad=typeLoad;
		this.owner=owner;
	}

	/** Name: getNumBoxesToTransp
	 * Method used to get the number of boxes to transport.
	 * @return A whole number representing the number of boxes to transport.
	 */
	public int getNumBoxesToTransp() {
		return this.numBoxesToTransp;
	}

	/** Name: setNumBoxesToTransp
	 * Method used to update the number of boxes to transport.
	 * @param numBoxesToTransp - number of boxes to transport - numBoxesToTransp = int, numBoxesToTransp != 0
	 */
	public void setNumBoxesToTransp(int numBoxesToTransp) {
		this.numBoxesToTransp = numBoxesToTransp;
	}

	/** Name: getBoxWeight
	 * Method used to get the boxes weight.
	 * @return A real number representing the boxes weight.
	 */
	public double getBoxWeight() {
		return this.boxWeight;
	}

	/** Name: setBoxWeight
	 * Method used to update the boxes weight.
	 * @param boxWeight - boxes weight - boxWeight = double
	 */
	public void setBoxWeight(double boxWeight) {
		this.boxWeight = boxWeight;
	}

	/** Name: getTypeLoad
	 * Method used to get the type of a load.
	 * @return A char representing the type of a load.
	 */
	public char getTypeLoad() {
		return this.typeLoad;
	}

	/** Name: setTypeLoad
	 * Method used to update the type of a load.
	 * @param typeLoad - type of a load - typeLoad = char, typeLoad != null, typeLoad != ''
	 */
	public void setTypeLoad(char typeLoad) {
		this.typeLoad = typeLoad;
	}

	/** Name: getOwner
	 * Method used to get the the load(s) owner.
	 * @return A object Client representing the load(s) owner.
	 */
	public Client getOwner() {
		return this.owner;
	}

	/** Name: setOwner
	 * Method used to update the load(s) owner.
	 * @param owner - load(s) owner - owner = Client, owner != null
	 */
	public void setOwner(Client owner) {
		this.owner = owner;
	}

	/** Name: loadWeightInKg
	 * Method used to calculate the load weight in kilograms.
	 * <b>pre: </b> The load weight was entered in grams before. <br>
	 * <b>post: </b> Load weight in kilograms calculated. <br>
	 * @return A real number representing the load weight in kilograms.
	 */
	public double loadWeightInKg(){
		double weight=boxWeight*numBoxesToTransp/1000;
		return weight;
	}

	/** Name: calculateTotalPriceLoadTransportation
	 * Method used to calculate the total price to pay for freight transportation of the client company.
	 * <b>pre: </b> The load weight was already converted in kilograms. <br>
	 * <b>post: </b> Total price of cargo transportation calculated. <br>
	 * @return A real number representing the total price to pay for freight transportation.
	 */
	public double calculateTotalPriceLoadTransportation() {
		double totalPrice=0;
		if (typeLoad==TYPE_LOAD1)
			totalPrice=loadWeightInKg()*PRICE_PERISHABLE*(1-surpriseDiscountAssignment());
		else if (typeLoad==TYPE_LOAD2)
			totalPrice=loadWeightInKg()*PRICE_NO_PERISHABLE*(1-surpriseDiscountAssignment());
		else if (typeLoad==TYPE_LOAD3)
			totalPrice=loadWeightInKg()*PRICE_DANGEROUS*(1-surpriseDiscountAssignment());
		return totalPrice;
	}

	/** Name: surpriseDiscountAssignment
	 * Method used to assign a possible surprise discount to the client company according to its category.
	 * <b>pre: </b> The client was already categorized. <br>
	 * <b>post: </b> Discount assigned to the client company or not. <br>
	 * @return A real number representing the possible discount to the client company.
	 */
	public double surpriseDiscountAssignment() {
		double discount=0;
		if (owner.getTypeClient()==Client.TYPE_CLIENT1)
			discount=0;
		else if (owner.getTypeClient()==Client.TYPE_CLIENT2 && getTypeLoad()==TYPE_LOAD1)
			discount=0.015;
		else if (owner.getTypeClient()==Client.TYPE_CLIENT3 && (getTypeLoad()==TYPE_LOAD1 || getTypeLoad()==TYPE_LOAD2))
			discount=0.03;
		else if (owner.getTypeClient()==Client.TYPE_CLIENT4)
			discount=0.05;
		return discount;
	}

	/** Name: clientCategory
	 * Method used to evoke the client categorization determined in the class Client.
	 * @return A String with the client company name and its category.
	 */
	public String clientCategory(){
		owner.clientCategorization();
		return owner.clientCategorization();
	}
}