package greatagain.com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DigitalAssistant {

    private String username;
    private DriveAssistant driveAssistant;
    private DigitalWallet digitalWallet;
    private ConversionAssistant conversionAssistant;
    private DigitalDiary digitalDiary;

    private static Scanner scanner = new Scanner(System.in);

    public DigitalAssistant(String username, DriveAssistant driveAssistant, DigitalWallet digitalWallet, ConversionAssistant conversionAssistant, DigitalDiary digitalDiary) {
        this.username = username;
        this.driveAssistant = driveAssistant;
        this.digitalWallet = digitalWallet;
        this.conversionAssistant = conversionAssistant;
        this.digitalDiary = digitalDiary;
    }

    public DriveAssistant getDriveAssistant() {
        return driveAssistant;
    }


    public DigitalWallet getDigitalWallet() {
        return digitalWallet;
    }


    public DigitalDiary getDigitalDiary() {
        return digitalDiary;
    }

    public String getUsername() {
        return username;
    }

    public void startAssistant() {
        System.out.println(" ");
        System.out.println("Hello "+ getUsername() + " you are about to drive " + driveAssistant.getMilesToDrive() + " miles");
        System.out.println("Your budget is $ " + digitalWallet.getBudget() + " for this roadtrip");
        System.out.println(" ");
        System.out.println("Your assistant has now been initialised");
    }

    public void mainMenu() {

        boolean quit = false;
        int choice;

        while (!quit) {
            System.out.println("\n==== Main Menu ==== ");
            System.out.println("\nPress ");
            System.out.println("\t 1 - To go to conversion.");
            System.out.println("\t 2 - To use the drive assistant.");
            System.out.println("\t 3 - To use the digital wallet.");
            System.out.println("\t 4 - To use the diary.");
            System.out.println("\t 5 - To quit the application");
            System.out.println(" ");
            System.out.println("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        ConversionAssistant.conversionMenu();
                        break;
                    case 2:
                        getDriveAssistant().driveAssistantMenu();
                        break;
                    case 3:
                        getDigitalWallet().digitalWalletMenu();
                        break;
                    case 4:
                        getDigitalDiary().digitalDiaryMenu();
                        break;
                    case 5:
                        quit = true;
                        exit();
                        System.exit(0);
                        break;

                        default:
                        System.err.println("please press a number from te menu 1-5");
                        continue;

                }
            } catch (InputMismatchException e) {
                System.err.println("please press a number from te menu 1-5");
                scanner.next(); // clear scanner wrong input
                continue;
            }
        }
    }

    public static void welcome() {
        System.out.println(" ");
        System.out.println("==================================");
        System.out.println("Welcome to your roadtrip compagion");
        System.out.println(" Make your roadtrip great again   ");
        System.out.println("         Version 1.0              ");
        System.out.println("==================================");
        System.out.println(" ");
    }

    public static String initialiseUsername() {
        System.out.println(" <--- We are now initialising the assistant --->");
        System.out.println(" ");
        System.out.println("Please enter your username:");
        String username = scanner.nextLine(); // geen controle nodig username mag alles zijn.
        return username;
    }

    public static double initialiseMilesToDrive() {
        System.out.println("Please enter your expected miles to drive for this roadtrip:");
        boolean quit = false;
        while (!quit) {
            try {
                double milestodrive = scanner.nextDouble();
                scanner.nextLine();
                if (milestodrive >= 1 && milestodrive <= 99999) { // check of er een logisch getal wordt ingevoerd
                    return milestodrive;
                } else {
                    System.err.println("please put in a number between 1 and 9999: ");
                }

            } catch (InputMismatchException e) {
                System.err.println("please put in a number between 1 and 9999:");
                scanner.next(); // clear scanner verkeerde input

            }
        }
        return -1; // return statement omdat het moet maar wordt niet gebruikt
    }

    public static double initialiseBudget() {
        System.out.println("Please enter your expected budget for this roadtrip $:");
        boolean quit = false;
        while (!quit) { // bewust een while loop die niet sluit
            try {
                double budget = scanner.nextDouble();
                scanner.nextLine();
                if (budget >= 1 && budget <= 99999) { // check of er een logisch getal wordt ingevoerd
                    return budget;
                } else {
                    System.err.println("please put in a number between 1 and 9999: ");
                }

            } catch (InputMismatchException e) {
                System.err.println("please put in a number between 1 and 9999:");
                scanner.next(); // clear scanner verkeerde input
                continue;
            }
        }
        return -1; // return statement omdat het moet maar wordt niet gebruikt
    }
    public void exit(){
        System.out.println(" ");
        System.out.println("==================================");
        System.out.println("        Thank you for using       ");
        System.out.println(" Make your roadtrip great again   ");
        System.out.println("          Version 1.0             ");
        System.out.println("          Now exiting             ");
        System.out.println("==================================");
        System.out.println(" ");
    }
}