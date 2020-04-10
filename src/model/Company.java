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

public class Company {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	// Number of clients the company works with.
	public final static int NUM_CLIENTS=5;
	// Name of the ship.
	public final static String NAME_SHIP="The Pirate";

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	// Name of the company.
	private String nameCompany="Morgan®";
	// Name of the company's CEO.
	private String ceo= "Morgan";

	// -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

	// Morgan's ship.
	private Ship ship;
	// List of the company clients.
	private Client[] list;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/** Name: Company
	 * Constructor method of a company.
	 * @param nameCompany - name of the company - nameCompany = String, nameCompany != null, nameCompany != ""
	 * @param ceo - name of the company's CEO - chief = String, chief != null, chief != ""
	 */
	public Company(String nameCompany,String ceo) {
		this.nameCompany = nameCompany;
		this.ceo=ceo;
		ship=new Ship(NAME_SHIP);
		list=new Client[NUM_CLIENTS];
	}

	/** Name: getNameCompany
	 * Method used to get the name of the Morgan company.
	 * @return A String representing the name of the Morgan company.
	 */
	public String getNameCompany() {
		return this.nameCompany;
	}

	/** Name: setNameCompany
	 * Method used to update the name of the Morgan company.
	 * @param nameCompany - name of the Morgan company - nameCompany = String, nameCompany != null, nameCompany != ""
	 */
	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	/** Name: getCeo
	 * Method used to get the name of the company's CEO.
	 * @return A String representing the name of the company's CEO.
	 */
	public String getCeo() {
		return this.ceo;
	}

	/** Name: setCeo
	 * Method used to update the name of the company's CEO.
	 * @param ceo - name of the company's CEO - ceo = String, ceo != null, ceo != ""
	 */
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	/** searchClient
	* Method used to search if a client exists. <br>
	* @param commercialRegisterNum - commercial registration number from the client - commercialRegisterNum = String, commercialRegisterNum != null, commercialRegisterNum != ""
	* @return A client if the commercial register number exists, null if not.
	*/
	public Client searchClient(String commercialRegisterNum){
		Client objSearch=null;
		boolean findClient=false;
		for (int i=0;i<list.length && !findClient;i++){
			if(list[i]!=null){
				if (list[i].getCommercialRegisterNum().equals(commercialRegisterNum)){
					objSearch=list[i];
					findClient=true;
				}
			}
		}
		return objSearch;
	}
	/** name: addClient
	 * Method used to add a new client. <br>
	 * <b>pre: </b> Client array already exists. list!=null
	 * <b>post: </b> Client object created in the client array. <br>
	 * @param nameCompanyClient - nameCompany of the client company - nameCompanyClient = String, nameCompanyClient != null, nameCompanyClient != ""
	 * @param commercialRegisterNum - commercial registration number from the client - commercialRegisterNum = String, commercialRegisterNum != null, commercialRegisterNum != ""
	 * @param registryExpeditionDate - registration issue date of the client company - registryExpeditionDate = String, registrationIssueDate != null, registrationIssueDate != ""
	 * @param typeClient - type of the client company - typeClient = char, typeClient != null, typeClient != ''
	 * @param kilosTranspOverTime - quantity of kilos transported over the time by the client company - kilosTranspOverTime = double
	 * @param moneyPayedOverTime - amount of money payed over the time by the client company - moneyPayedOverTime = double
	 * @return String with a message of the successfully client registration, or an error because of the full client array capacity.
	 */
	 public String addClient(String nameCompanyClient,String commercialRegisterNum,String registryExpeditionDate,char typeClient,double kilosTranspOverTime, double moneyPayedOverTime){
		String message="";
		boolean addCl=false;
		Client objSearch=searchClient(commercialRegisterNum);
		if (objSearch!=null)
			message="This client already exists.";
		else{
			for (int i=0;i<list.length && !addCl;i++){
		 		if (list[i]== null){
					list[i]=new Client(nameCompanyClient,commercialRegisterNum,registryExpeditionDate,typeClient,kilosTranspOverTime,moneyPayedOverTime);
					addCl=true;
					message="New client successfully registered.";
				}
			}
			if (addCl==false)
				message="Error. The client array has reached its maximum capacity!";
		}
		return message;
		}

		/** Name: loadShip
		 * Method used to verify if a load can be loaded in the ship.
		 * @param numBoxesToTransp - number of boxes to transport - numBoxesToTransp = int, numBoxesToTransp != 0
		 * @param boxWeight - boxes weight - boxWeight = double
		 * @param typeLoad - type of a load - typeLoad = char, typeLoad != null, typeLoad != ''
		 * @param commercialRegisterNum - commercial registration number from the client - commercialRegisterNum = String, commercialRegisterNum != null, commercialRegisterNum != ""
		 * @return A String with a message confirming that a load was registered or not due to others factors.
		 */
		public String loadShip(int numBoxesToTransp, double boxWeight, char typeLoad,String commercialRegisterNum){
			String message="";
			Client objSearch=searchClient(commercialRegisterNum);
			if (objSearch==null)
				message="This client is not in the system. Register it.";
			else
					message = ship.loadTheShip(numBoxesToTransp,boxWeight,typeLoad,objSearch);
			return message;
		}

		/** Name: totalWeightShip
		 * Method used to evoke the current total weight in the ship determined in class Ship.
		 * @return A String with a message specifying the current total weight in the ship.
		 */
		public String totalWeightShip(){
			String message="";
			message = "The total weight of the cargo carried by the ship is "+ship.totalWeightInShip()+" kg.";
			return message;
		}

		/** Name: dischargeShip
		 * Method used to evoke the unloading of the ship determined in class Ship.
		 * @return A String with a message of the unloading of the ship.
		 */
		public String dischargeShip() {
			ship.dischargeTheShip();
			return ship.dischargeTheShip();
		}

		/** Name: determineDeparture
		 * Method used to evoke the decision of the ship's departure determined in class Ship.
		 * @return A String with a message saying if the ship can departure or not.
		 */
		public String determineDeparture(){
			ship.determineShipDeparture();
			return ship.determineShipDeparture();
		}
}
