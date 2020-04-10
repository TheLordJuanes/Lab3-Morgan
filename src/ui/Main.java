/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Subject: Algorithms and Programming I
 * Laboratory Unit 3
 * Student Code: A00365977
 * @Author: Juan Esteban Caicedo A.
 * @Date: April, 8th 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ui;

import model.Company;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

  public static Company mainCompany;
  public static Scanner lector;

  // -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

  public static void main(String[] args){
    createCompany();
    lector=new Scanner(System.in);
    boolean menu=true;
    while (menu){
      System.out.println();
      System.out.println("---------------------------");
      System.out.println("Welcome to Morgan software!");
      System.out.println("---------------------------");
      System.out.println();
      System.out.println("Type 1 to register a client.");
      System.out.println("Type 2 to load the ship.");
      System.out.println("Type 3 to determine the ship departure.");
      System.out.println("Type 4 to discharge the ship.");
      System.out.println("Type 5 to know the total weight of the cargo carried by the ship currently.");
      System.out.println("Type 6 to exit the menu.");
      System.out.println();
      try{    // This "try" makes the menu restart from the beginning after the user has finished using one of the menu functions completely, different from number 4 option "Exit the menu" //
      int opt;
      opt=lector.nextInt();
      lector.nextLine();
      switch(opt){
        case 1:
          registerClient();
          break;
        case 2:
          toLoadTheShip();
          break;
        case 3:
          determineDepartureShip();
          break;
        case 4:
          dischargeMorganShip();
          break;
        case 5:
          totalWeightInTheShip();
          break;
        case 6:
          menu=false;
          System.out.println();
          System.out.print("Leaving the menu...");
          System.out.println();
          System.out.println();
          System.out.println("End of menu.");
          System.out.print("Goodbye!");
          System.out.println();
          System.out.println();
          break;
        default:
          System.out.println("Option not available ");
          break;
      }
    }catch(InputMismatchException e){     // This is from the "try" used before. If the user doesn't enter a whole number but a word or a letter or something different, a message with an error will appear in his/her screen //
      System.out.println();
      System.out.println("Error! You must enter a whole number. Try again.");
      lector.next();
    }
    }
  }

  /** Name: createCompany
   * Method used to create a company.
   */
  public static void createCompany(){
    String nameCompany="Morgan®";
    System.out.println();
    System.out.print(nameCompany);
    System.out.println();
    String chief="Morgan";
    mainCompany=new Company(nameCompany,chief);
  }

  /** Name: registerClient
   * Method used to evoke the addition of a new client determined in class Company.
   */
  public static void registerClient(){
    System.out.print("Name of the client company: ");
    String nameCompanyClient=lector.nextLine();
    System.out.print("Commercial registration Number: ");
    String commercialRegisterNum=lector.nextLine();
    System.out.print("Registry Expedition Date: ");
    String registryExpeditionDate=lector.nextLine();
    System.out.print("Type of client: ");
    System.out.println("Type 'N' if it is a Normal client.");
    System.out.println("Type 'S' if it is a Silver client.");
    System.out.println("Type 'G' if it is a Gold client.");
    System.out.println("Type 'P' if it is a Platinum client.");
    char typeClient=lector.nextLine().toUpperCase().charAt(0);;
    System.out.println();
    double kilosTranspOverTime=0;
    double moneyPayedOverTime=0;
    String message1 = mainCompany.addClient(nameCompanyClient, commercialRegisterNum, registryExpeditionDate, typeClient, kilosTranspOverTime, moneyPayedOverTime);
    System.out.println(message1);
  }

  /** Name: toLoadTheShip
   * Method used to evoke the loading of a load determined in class Company and also in class Ship before.
   */
  public static void toLoadTheShip(){
    System.out.print("Number of boxes to transport: ");
    int numBoxesToTransp=lector.nextInt();
    System.out.print("Boxes weight in grams: ");
    double boxWeight=lector.nextDouble();
    lector.nextLine();
    System.out.println("Type of load:");
    System.out.println("Type 'P' if it is a Perishable load.");
    System.out.println("Type 'N' if it is a No Perishable load.");
    System.out.println("Type 'D' if it is a Dangerous load.");
    char typeLoad=lector.nextLine().toUpperCase().charAt(0);
    System.out.print("Commercial register number of the client company: ");
    String commercialRegisterNum=lector.nextLine();
    String message2 = mainCompany.loadShip(numBoxesToTransp,boxWeight,typeLoad,commercialRegisterNum);
    System.out.println(message2);
  }

  /** Name: dischargeMorganShip
   * Method used to evoke the unloading of the ship determined in class Ship and evoked in class Company before.
   */
  public static void dischargeMorganShip(){
    String message3=mainCompany.dischargeShip();
    System.out.println(message3);
  }

  /** Name: totalWeightInTheShip
   * Method used to evoke the current total weight in the ship determined in class Ship and evoked in class Company before.
   */
  public static void totalWeightInTheShip(){
    String message4=mainCompany.totalWeightShip();
    System.out.println(message4);
  }

  /** Name: determineDepartureShip
   * Method used to evoke the ship's departure determination determined in class Ship and evoked in class Company before.
   */
  public static void determineDepartureShip(){
    String message5=mainCompany.determineDeparture();
    System.out.println(message5);
  }
}
