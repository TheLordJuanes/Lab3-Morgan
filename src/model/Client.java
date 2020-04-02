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

public class Client {

	// -----------------------------------------------------------------
	// Atrributes
	// -----------------------------------------------------------------

	private String nameClient="";
	private String commercialRegisterNum="";
	private String registryExpeditionDate="";
	private String typeClient="";

	// -----------------------------------------------------------------
	// Methods
  // -----------------------------------------------------------------

	/**
	 * Constructor method of a client.
	 * @param nameClient - name of the client company - pNameClient != null
	 * @param commercialRegisterNum - commercial register number of the client to enter - pCommercialRegisterNum != null
	 * @param registryExpeditionDate - registry expedition date of the client company - pregistryExpeditionDate != null
	 * @param typeClient - type of client - pTypeClient != null
	 */
	public void Client(String nameClient, String commercialRegisterNum, String registryExpeditionDate, String typeClient) {
		this.nameClient=nameClient;
		this.commercialRegisterNum=commercialRegisterNum;
		this.registryExpeditionDate=registryExpeditionDate;
		this.typeClient=typeClient;
	}

	public String getNameClient() {
		return this.nameClient;
	}

	/**
	 *
	 * @param nameClient
	 */
	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public String getCommercialRegisterNum() {
		return this.commercialRegisterNum;
	}

	/**
	 *
	 * @param commercialRegisterNum
	 */
	public void setCommercialRegisterNum(String commercialRegisterNum) {
		this.commercialRegisterNum = commercialRegisterNum;
	}

	public String getregistryExpeditionDate() {
		return this.registryExpeditionDate;
	}

	/**
	 *
	 * @param registryExpeditionDate
	 */
	public void setregistryExpeditionDate(String registryExpeditionDate) {
		this.registryExpeditionDate = registryExpeditionDate;
	}

	public String getTypeClient() {
		return this.typeClient;
	}

	/**
	 *
	 * @param typeClient
	 */
	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}

	public String clientCategorization() {
		String category="";
		return category;
	}

	/**
	 *
	 * @param pTypeFreight
	 */
	public String surpriseDiscountAssignment(String pTypeFreight) {
		String surprise="";
		return surprise;
	}

	/**
	 *
	 * @param pCalculateTotalWeightFreight
	 */
	public double quantKilosTransp(double pCalculateTotalWeightFreight) {
		double kilos=0;
		return kilos;
	}

	/**
	 *
	 * @param pCalculateTotalPriceFreightTransportation
	 */
	public double totalMoneyPayed(double pCalculateTotalPriceFreightTransportation) {
		double money=0;
		return money;
	}
}
