package greatagain.com;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DigitalDiary {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<String> placesVisited = new ArrayList<String>();

    public DigitalDiary() {
    }

    public void digitalDiaryMenu() {
        boolean quit = false;
        int choice;

        while (!quit) {
            System.out.println("\n==== Digital Diary ==== ");
            System.out.println("\nPress ");
            System.out.println("\t 1 - Add a place visited");
            System.out.println("\t 2 - To print places visited");
            System.out.println("\t 3 - To go back to the main menu ");
            System.out.println(" ");
            System.out.println("Enter your choice: ");
            try{
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPlaceVisited();
                    break;
                case 2:
                    printPlacesVisitedList();
                    break;
                case 3:
                    quit = true;
                    break;

                default:
                    System.err.println("please pick a number from te menu 1-3"); //check voor getallen buiten scope
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

    public void addPlaceVisited() {
        System.out.println("Please put in the name of the place visited");
        String place = scanner.nextLine();
        placesVisited.add(place);
    }

    public void printPlacesVisitedList() {
        System.out.println("You have " + placesVisited.size() + " places visited");
        for (int i = 0; i < placesVisited.size(); i++) {
            System.out.println((i + 1) + ". " + placesVisited.get(i));
        }
    }
}






