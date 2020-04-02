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

public class Company {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	public final static int NUM_CLIENTS=5;

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	//Name of the company
	private String nameCompany;

	// -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

	// Morgan ship
	private Ship ship;
	// List of the company clients
	private Client[] list;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/**
	 * Constructor method of a company.
	 * @param name - name of the company - name != null
	 */
	public Company(String name) {
		this.name = name;
		ship=new Ship();
		list=new Client[NUM_CLIENTS];
		list[0]=new Client("General Motors", "345-234", "23/05/2025", "Platinum");
		list[1]=new Client("BMW", "768-121", "15/01/2023", "Platinum");
	}

	public String getName() {
		return this.name;
	}

	/**
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** searchClient
	* Method used to search if a client exists. <br>
	* @param commercialRegisterNum - commercial register number from the client- pCommercialRegisterNum != null
	* @return Client if the commercial register number exists, null if not.
	*/
	public Client searchClient(String commercialRegisterNum){
		Client objSearch=null;
		boolean findClient=false;
		for (int i=0;i<list.length && !findClient;i++){
			if (list[i].getCommercialRegisterNum().equals(commercialRegisterNum)){
				objSearch=list[i];
				findClient=true;
			}
		}
		return objSearch;
	}
	/** addClient
	 * Method used to add a new client. <br>
	 * <b>pre: </b> Client array already exists. list!=null
	 * <b>post: </b> Client object created in the client array. <br>
	 * @param nameClient - name of the client company - pNameClient != null
	 * @param commercialRegisterNum - commercial register number of the client to enter - pCommercialRegisterNum != null
	 * @param registryExpeditionDate - registration issue date of the client company - pregistrationIssueDate != null
	 * @param typeClient - type of client - pTypeClient != null
	 * @return String with the message of the operation.
	 */
	 public String addClient(String nameClient,String commercialRegisterNum,String registryExpeditionDate,String typeClient){
		String message="";
		boolean addCl=false;
		Client objSearch=searchClient(commercialRegisterNum);
		if (objSearch!=null)
			message="The client already exists.";
		else{
			for (int i=0;i<list.length && !addCl;i++){
		 		if (list[i]== null){
					list[i]=new Client(nameClient,commercialRegisterNum,registryExpeditionDate,typeClient);
					addCl=true;
					message="The new client was successfully registered.";
				}
			}
			if (addCl==false)
				message="Error. The client array has reached its maximum capacity!";
		}
		return message;
		}

		public boolean sameBoxesWeight1(){
			boolean samew=false;
			Ship objWeight = ship.sameBoxesWeight2();
			return samew;
		}

		public String loadShip(){
			list.getNameClient();
			Ship objLoad = ship.loadTheShip();
			return objLoad;
		}

		public String dischargeShip() {
			String message3="";
			Ship objDischarge = ship.dischargeTheShip();
			message3 = "The ship was successfully discharged.";
			return message3;
		}
}
