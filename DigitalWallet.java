package greatagain.com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DigitalWallet {
    private Scanner scanner = new Scanner(System.in);

    private double budget;
    private double spend;
    private double earned;


    public DigitalWallet(double budget) {
        this.budget = budget;
        this.spend = 0;

    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getSpend() {
        return spend;
    }

    public void setSpend(double spend) {
        this.spend = spend;
    }

    public double getEarned() {
        return earned;
    }

    public void setEarned(double earned) {
        this.earned = earned;
    }

    public void digitalWalletMenu() {
        boolean quit = false;
        int choice;


        while (!quit) {
            System.out.println("\n==== Digital Wallet ==== ");
            System.out.println("\nPress ");
            System.out.println("\t 1 - To update expenses");
            System.out.println("\t 2 - To update earned money");
            System.out.println("\t 3 - To receive remaining budget ");
            System.out.println("\t 4 - To go back to the main menu  ");
            System.out.println(" ");
            System.out.println("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        useBudget();
                        break;
                    case 2:
                        earnings();
                        break;
                    case 3:
                        getRemainingbudget();
                        break;
                    case 4:
                        quit = true;
                        break;
                    default:
                        System.out.println("please pick a number from te menu 1-3");
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


    public void useBudget() {
        System.out.println("please input the amount spend: $ ");
        try {

            double expenses = scanner.nextDouble();
            scanner.nextLine();
            if (expenses> 0 && expenses < 99999) {
                double newbudget = getBudget() - expenses;
                double totalspend = getSpend() + expenses;
                setSpend(totalspend);
                setBudget(newbudget);
                System.out.println("your spending has been updated by " + expenses + " dollar ");
            }
            else{
                System.err.println("please put in a number between 1 and 99999: ");
            }
        }
        catch (InputMismatchException e) {
            System.err.println("please use a number as an input for the amount spend");
            scanner.next(); // clear scanner wrong input

        }
    }



    public void earnings() {
        System.out.println("please input the amount of the earnings: $ ");
        try {

            double earnings = scanner.nextDouble();
            scanner.nextLine();
            if (earnings > 0){
            System.out.println("remaining budget raised by $ " + earnings + " dollar");
            double newbudget = getBudget() + earnings;
            setBudget(newbudget);
            double totalEarned = getEarned() + earnings;
            setEarned(totalEarned);}
            else{
                System.err.println("please put in a number between 1 and 99999: ");
            }
        } catch (InputMismatchException e) {
            System.err.println("please use a number as an input for the amount earned");
            scanner.next(); // clear scanner wrong input

        }
    }

    public void getRemainingbudget() {
        if (getBudget()< 0){
            double temp = getBudget() * -1;  // om het weer een positief nummber te maken
            String numberAsString = String.format ("%.2f", temp); //afronding 2 decimalen
            System.out.println("You spend $ " + getSpend() +" dollars in total");
            System.out.println("You have earned $ " + getEarned() + " dollar in total");
            System.out.println("You have spend $ " + numberAsString + " dollar more than your budget");
        }
        else {
            String numberAsString = String.format ("%.2f", getBudget()); //afronding 2 decimalen
            System.out.println("You have spend $ " + getSpend() +" dollar in total");
            System.out.println("You have earned $ " + getEarned() + " dollar in total");
            System.out.println("the remaining budget for this roadtrip = $ " + numberAsString);
        }
    }
}