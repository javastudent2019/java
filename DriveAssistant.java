package greatagain.com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DriveAssistant {
    private double milesToDrive;
    private double milesDriven;
    private double remainingMiles;

    private Scanner scanner = new Scanner(System.in);

    public DriveAssistant(double milesToDrive) {
        this.milesToDrive = milesToDrive;
        this.milesDriven = 0;
        this.remainingMiles = 0;
    }

    public double getMilesToDrive() {
        return milesToDrive;
    }


    public double getMilesdriven() {
        return milesDriven;
    }

    public void setMilesdriven(double milesdriven) {
        this.milesDriven = milesdriven;
    }

    public double getRemainingmiles() {
        return remainingMiles;
    }

    public void setRemainingmiles(double remainingmiles) {
        this.remainingMiles = remainingmiles;
    }

    public void driveAssistantMenu() {
        boolean quit = false;
        int choice;


        while (!quit) {
            System.out.println("\n==== Drive Assistant ==== ");
            System.out.println("\nPress ");
            System.out.println("\t 1 - To update miles driven.");
            System.out.println("\t 2 - To get the remaining miles");
            System.out.println("\t 3 - To go back to the main menu");
            System.out.println(" ");
            System.out.println("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addMilesdriven();
                        break;
                    case 2:
                        RemainingMiles();
                        break;
                    case 3:
                        quit = true;
                        break;
                    default:
                        System.err.println("please press a number from te menu 1-3");
                        continue;
                }
            }
            catch (InputMismatchException e) {
                System.err.println("please press a number from te menu 1-3");
                scanner.next(); // clear scanner wrong input
                continue;
            }
        }
    }

    public void addMilesdriven() {
        System.out.println("please put in the miles driven in today's trip");
        double todaystrip = scanner.nextDouble();
        scanner.nextLine();
        double temp = getMilesdriven() + todaystrip;
        setMilesdriven(temp);
        double temp2 = getMilesToDrive() - getMilesdriven();
        setRemainingmiles(temp2);
        System.out.println("the " + todaystrip + " miles" + " are added to your total amount of driven miles");
    }

    public void RemainingMiles() {
        if (getRemainingmiles() >= 0) {
            String numberAsString = String.format ("%.2f", getRemainingmiles()); //afronding 2 decimalen
            System.out.println("You have driven " + getMilesdriven() +" miles in total");
            System.out.println("Your road trip has " + numberAsString + " miles left");
        } else {
            double temp = getRemainingmiles() * -1;  // om het weer een positief nummber te maken
            String numberAsString = String.format ("%.2f", temp); //afronding 2 decimalen
            System.out.println("You have driven " + getMilesdriven() +" miles in total");
            System.out.println("You have driven " + numberAsString + " miles more than expected");
        }
    }
}
