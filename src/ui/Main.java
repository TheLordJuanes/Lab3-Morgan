/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Subject: Algorithms and Programming I
 * Laboratory Unit 3 Solution
 * Student Code: A00365977
 * @Author: Juan Esteban Caicedo A.
 * @Date: April, 8th 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ui;

import java.util.Scanner;
import java.util.Arrays;
import model.Company;

public class Main{

  public static Company mainCompany;
  public static Scanner lector;

  // -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

  public static void main(String[] args){
    createCompany();
    boolean menu=true;
    while (menu){
      System.out.println();
      System.out.println("---------------------------");
      System.out.println("Welcome to Morgan software!");
      System.out.println("---------------------------");
      System.out.println();
      System.out.println("Type 1 to register a client");
      System.out.println("Type 2 to load the ship");
      System.out.println("Type 3 to determine the ship departure");
      System.out.println("Type 4 to discharge the ship");
      System.out.println();
      int option=lector.nextInt();
      switch(option){
        case 1:
          registerClient();
          break;
        case 2:
          registerClient();
          toLoadTheShip();
          System.out.println("Type 1 to show the total weight of the load registered");
          option=lector.nextInt();
          switch(option){
            case 1:
              totalLoadWeight();
              break;
          }
          break;
        case 3:
          determineShipDeparture();
          break;
        case 4:
          dischargeMorganShip();
          break;
        case 5:
          menu=false;
        System.out.println("End of menu");
        default:
          System.out.println("No available option");
          break;
      }
    }
  }
  public static void createCompany(){
    System.out.print("Name of the company:");
    String nameCompany=lector.nextLine();
    mainCompany=new Company(nameCompany);
  }
  public static void registerClient(){
    System.out.print("Name of the client company:");
    String nameClient=lector.nextLine();
    System.out.print("Commercial Register Number:");
    String commercialRegisterNum=lector.nextLine();
    System.out.print("Registration Issue Date:");
    String registryExpeditionDate=lector.nextLine();
    System.out.print("Type of client:");
    String typeClient=lector.nextLine();
    String message1 = mainCompany.addClient(nameClient, commercialRegisterNum, registryExpeditionDate, typeClient);
    System.out.println(message1);
  }
  public static void toLoadTheShip(){
    System.out.print("Number of boxes to transport:");
    int numBoxesToTransp=lector.nextInt();
    double[] boxWeight=new double[numBoxesToTransp];
    for (int i=0; i<numBoxesToTransp; i++){
      System.out.println((i+1)+". Enter the weight of the load:");
      String sameWeight=mainCompany.sameBoxesWeight1(boxWeight);
      boxWeight[i]=lector.nextDouble();
    System.out.print("Type of load:");
    String typeLoad=lector.nextLine();
    String message2 = mainCompany.loadShip(numBoxesToTransp,boxWeight,typeLoad);
    System.out.println(message2);
  }
}
public static void dischargeMorganShip(){
  String message3=mainCompany.dischargeShip();
  System.out.println(message3);

}

  public static void totalLoadWeight(){

  }

  public static void determineShipDeparture(){

  }
}
