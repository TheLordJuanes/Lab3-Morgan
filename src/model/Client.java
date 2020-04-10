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

public class Client {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	// Normal client type.
	public final static char TYPE_CLIENT1 = 'N';
	// Silver client type.
	public final static char TYPE_CLIENT2 = 'S';
	// Gold client type.
	public final static char TYPE_CLIENT3 = 'G';
	// Platinum client type.
	public final static char TYPE_CLIENT4 = 'P';

	// -----------------------------------------------------------------
	// Atrributes
	// -----------------------------------------------------------------

	// Name of the client company.
	private String nameCompanyClient;
	// Commercial registration number of the client company.
	private String commercialRegisterNum;
	// Registry expedition date of the client company.
	private String registryExpeditionDate;
	// Type of the client company.
	private char typeClient;
	// Quantity of kilos transported over the time by the client company.
	private double kilosTranspOverTime;
	// Amount of money payed over the time by the client company.
	private double moneyPayedOverTime;

	// -----------------------------------------------------------------
	// Methods
  // -----------------------------------------------------------------

	/** Name: Client
	 * Constructor method of a client.
	 * @param nameCompanyClient - name of the client company - nameCompanyClient = String, nameCompanyClient != null, nameCompanyClient != ""
	 * @param commercialRegisterNum - commercial registration number of the client company - commercialRegisterNum = String, commercialRegisterNum != null, commercialRegisterNum != ""
	 * @param registryExpeditionDate - registry expedition date of the client company - registryExpeditionDate = String, registryExpeditionDate != null, registryExpeditionDate != ""
	 * @param typeClient - type of the client company - typeClient = char, typeClient != null, typeClient != ''
	 * @param kilosTranspOverTime - quantity of kilos transported over the time by the client company - kilosTranspOverTime = double
	 * @param moneyPayedOverTime - amount of money payed over the time by the client company - moneyPayedOverTime = double
	 */
	public Client(String nameCompanyClient, String commercialRegisterNum, String registryExpeditionDate, char typeClient, double kilosTranspOverTime, double moneyPayedOverTime) {
		this.nameCompanyClient=nameCompanyClient;
		this.commercialRegisterNum=commercialRegisterNum;
		this.registryExpeditionDate=registryExpeditionDate;
		this.typeClient=typeClient;
		this.kilosTranspOverTime=0;
		this.moneyPayedOverTime=0;
	}

	/** Name: getNameCompanyClient
	 * Method used to get the name of the client company.
	 * @return A String representing the name of the client company.
	 */
	public String getNameCompanyClient() {
		return this.nameCompanyClient;
	}

	/** Name: setNameCompanyClient
	 * Method used to update the name of the client company.
	 * @param nameCompanyClient - name of the client company - nameCompanyClient = String, nameCompanyClient != null, nameCompanyClient != ""
	 */
	public void setNameCompanyClient(String nameCompanyClient) {
		this.nameCompanyClient = nameCompanyClient;
	}

	/** Name: getCommercialRegisterNum
	 * Method used to get the commercial registration number of the client company.
	 * @return A String representing the commercial register number of the client company.
	 */
	public String getCommercialRegisterNum() {
		return this.commercialRegisterNum;
	}

	/** Name: setCommercialRegisterNum
	 * Method used to update the commercial registration number of the client company.
	 * @param commercialRegisterNum - commercial registration number of the client company - commercialRegisterNum = String, commercialRegisterNum != null, commercialRegisterNum != ""
	 */
	public void setCommercialRegisterNum(String commercialRegisterNum) {
		this.commercialRegisterNum = commercialRegisterNum;
	}

	/** Name: getRegistryExpeditionDate
	 * Method used to get the registry expedition date of the client company.
	 * @return A String representing the registry expedition date of the client company.
	 */
	public String getRegistryExpeditionDate() {
		return this.registryExpeditionDate;
	}

	/** Name: setRegistryExpeditionDate
	 * Method used to update the registry expedition date of the client company.
	 * @param registryExpeditionDate - registry expedition date of the client company - registryExpeditionDate = String, registryExpeditionDate != null, registryExpeditionDate != ""
	 */
	public void setRegistryExpeditionDate(String registryExpeditionDate) {
		this.registryExpeditionDate = registryExpeditionDate;
	}

	/** Name: getTypeClient
	 * Method used to get the type of the client company.
	 * @return A char representing the type of the client company.
	 */
	public char getTypeClient() {
		return this.typeClient;
	}

	/** Name: setTypeClient
	 * Method used to update the type of the client company.
	 * @param typeClient - type of the client company - typeClient = char, typeClient != null, typeClient != ''
	 */
	public void setTypeClient(char typeClient) {
		this.typeClient = typeClient;
	}

	/** Name: getKilosTranspOverTime
	 * Method used to get the quantity of kilos transported over the time by the client company.
	 * @return A real number representing the quantity of kilos transported over the time by the client company.
	 */
	public double getKilosTranspOverTime() {
		return this.kilosTranspOverTime;
	}

	/** Name: setKilosTranspOverTime
	 * Method used to update the quantity of kilos transported over the time by the client company.
	 * @param kilosTranspOverTime - quantity of kilos transported over the time - kilosTranspOverTime = double
	 */
	public void setKilosTranspOverTime(double kilosTranspOverTime) {
		this.kilosTranspOverTime = kilosTranspOverTime;
	}

	/** Name: getMoneyPayedOverTime
	 * Method used to get the amount of money payed over the time by the client company.
	 * @return A real number representing the amount of money payed over the time by the client company.
	 */
	public double getMoneyPayedOverTime() {
		return this.moneyPayedOverTime;
	}

	/** Name: setMoneyPayedOverTime
	 * Method used to update the amount of money payed over the time by the client company.
	 * @param moneyPayedOverTime - amount of money payed over the time - moneyPayedOverTime = double
	 */
	public void setMoneyPayedOverTime(double moneyPayedOverTime) {
		this.moneyPayedOverTime = moneyPayedOverTime;
	}

	/** Name: clientCategorization
	 * Method used to categorize a client.
	 * <b>pre: </b> The client began in the Normal category. <br>
	 * <b>post: </b> Client categorized. <br>
	 * @return String with the client company name and its category.
	 */
	public String clientCategorization() {
		String category="";
		String message="";
		boolean updated=false;
		if(getKilosTranspOverTime()>35000 && getTypeClient()!='S'){
			setTypeClient('S');
			category="Silver";
			updated=true;
		}
		if ((getKilosTranspOverTime()>55000 || getMoneyPayedOverTime()>=2000000) && getTypeClient()!='G'){
			setTypeClient('G');
			category="Gold";
			updated=true;
		}
		if (getMoneyPayedOverTime()>=5000000 && getTypeClient()!='P'){
			setTypeClient('P');
			category="Platinum";
			updated=true;
		}
		if(updated==true)
			message="The client "+getNameCompanyClient()+" has reached the category "+category+".";
		return message;
	}
}
