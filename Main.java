package greatagain.com;

public class Main {


    public static void main(String[] args) {
        DigitalAssistant.welcome();
        String username = DigitalAssistant.initialiseUsername();
        double milestodrive = DigitalAssistant.initialiseMilesToDrive();
        double budget = DigitalAssistant.initialiseBudget(); // bij de start invoeren van gegevens
        DriveAssistant driveAssistant = new DriveAssistant(milestodrive);
        DigitalWallet digitalWallet = new DigitalWallet(budget);
        ConversionAssistant conversionAssistant = new ConversionAssistant();
        DigitalDiary digitalDiary = new DigitalDiary();
        DigitalAssistant assistant = new DigitalAssistant(username, driveAssistant, digitalWallet, conversionAssistant, digitalDiary);

        assistant.startAssistant();

        boolean quit = false;
        while (!quit) { // bewust een while loop die niet sluit. programma sluit via het main menu
            assistant.mainMenu();
        }
    }
}
