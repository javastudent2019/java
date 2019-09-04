package greatagain.com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversionAssistant {

    public static Scanner scanner = new Scanner(System.in);


    public static void conversionMenu() {
        boolean quit = false;
        int choice;


        while (!quit) {
            System.out.println("\n==== Conversion Assistant ==== ");
            System.out.println("\nPress ");
            System.out.println("\t 1 - To use miles to kilometers conversion");
            System.out.println("\t 2 - To use kilometers to miles conversion");
            System.out.println("\t 3 - To use gallons to liters conversion");
            System.out.println("\t 4 - To use pounds to kilos conversion.");
            System.out.println("\t 5 - To use ounces to grams conversion.");
            System.out.println("\t 6 - To use dollar to euro conversion.");
            System.out.println("\t 7 - To use euro to dollar conversion.");
            System.out.println("\t 8 - To use fahrenheit to celcius conversion.");
            System.out.println("\t 9 - To use celsius to fahrenheit conversion");
            System.out.println("\t 10 - To go to the main menu");
            System.out.println(" ");
            System.out.println("Enter your choice: ");

            try {
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    milesToKilometers();
                    break;
                case 2:
                    kilometersToMiles();
                    break;
                case 3:
                    gallonsToliters();
                    break;
                case 4:
                    poundstoKilos();
                    break;
                case 5:
                    ounceToGrams();
                    break;
                case 6:
                    dollarsToEuros();
                    break;
                case 7:
                    eurosToDollars();
                    break;
                case 8:
                    fahrenheitTocelsius();
                    break;
                case 9:
                    celsiusToFarhenheit();
                    break;
                case 10:
                    quit = true;
                    break;

                default:
                    System.err.println("Wrong input: please pick a number from te menu 1-10"); //check voor getallen buiten scope
                    continue;
            }
        }
            catch (InputMismatchException e) { // check voor verkeerde input
                System.err.println("Wrong input: please press a number from te menu 1-10");
                scanner.next(); // clear scanner verkeerde input
                continue;
            }
        }
    }


    public static void milesToKilometers() {
        System.out.println("please input the amount of miles");
        double miles = scanner.nextDouble();
        scanner.nextLine();
        double kilometers = miles * 1.609344;
        kilometers = Math.floor(kilometers * 100) / 100; // om af te ronden op 2 decimalen
        System.out.println(miles + " miles = " + kilometers + " kilometers");
    }

    public static void kilometersToMiles() {
        System.out.println("please input the amount of kilometers");
        double kilometers = scanner.nextDouble();
        scanner.nextLine();
        double miles = kilometers / 1.609344;
        miles = Math.floor(miles * 100) / 100; // om af te ronden op 2 decimalen
        System.out.println(kilometers + " kilometers = " + miles + " miles");
    }

    public static void gallonsToliters() {
        System.out.println("please input the amount of gallons");
        double gallons = scanner.nextDouble();
        scanner.nextLine();
        double liters = gallons * 3.78541178;
        liters = Math.floor(liters * 100) / 100; // om af te ronden op 2 decimalen
        System.out.println(gallons + " gallons = " + liters + " liters");
    }

    public static void poundstoKilos() {
        System.out.println("please input the amount of pounds(Ibs) ");
        double pounds = scanner.nextDouble();
        scanner.nextLine();
        double kilos = pounds * 0.45359237;
        kilos = Math.floor(kilos * 100) / 100; // om af te ronden op 2 decimalen
        System.out.println(pounds + " pounds (Ibs) = " + kilos + " kilos");
    }

    public static void ounceToGrams() {
        System.out.println("please input the amount of ounce (oz)");
        double ounce = scanner.nextDouble();
        scanner.nextLine();
        double grams = ounce * 28.3495231;
        grams = Math.floor(grams * 100) / 100; // om af te ronden op 2 decimalen
        System.out.println(ounce + " ounce (oz) = " + grams + " gram");
    }

    public static void dollarsToEuros() {
        System.out.println("please input the amount of dollars ($) ");
        double dollars = scanner.nextDouble();
        scanner.nextLine();
        double euros = dollars * 0.884099037;
        euros = Math.floor(euros * 100) / 100; // om af te ronden op 2 decimalen
        System.out.println(dollars + " Dollars ($) = " + euros + " Euro (€)");
        System.out.println("please note the exchange rate may vary, updated june 12 2019");
    }

    public static void eurosToDollars() {
        System.out.println("please input the amount of euros (€) ");
        double euros = scanner.nextDouble();
        scanner.nextLine();
        double dollars = euros / 0.884099037;
        dollars = Math.floor(dollars * 100) / 100; // om af te ronden op 2 decimalen
        System.out.println(euros + " Euros (€) = " + dollars + " Dollars ($)");
        System.out.println("please note the exchange rate may vary, updated june 12 2019");
    }
    public static void fahrenheitTocelsius(){
        System.out.println("please put in the degrees Farhenheit to convert :");
        double fahrenheit = scanner.nextDouble();
        scanner.nextLine();
        double celcius = (fahrenheit -32) / 1.8;
        celcius = Math.floor(celcius * 100) / 100; // om af te ronden op 2 decimalen
        System.out.println(fahrenheit + " degrees Fahrenheit = " + celcius + " degrees Celsius" );
    }
    public static void celsiusToFarhenheit(){
        System.out.println("please put in the degrees Celsius to convert :");
        double celcius = scanner.nextDouble();
        scanner.nextLine();
        double fahrenheit = (celcius * 1.8) + 32;
        fahrenheit = Math.floor(fahrenheit * 100) / 100; // om af te ronden op 2 decimalen
        System.out.println(celcius +" degrees Celsius = " +fahrenheit +" degrees Fahrenheit");
    }
}
