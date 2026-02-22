import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n\nWELCOME TO YOUR GAMES!!");
        Scanner scanInput = new Scanner(System.in);
        char choice = 'Z';
        
        while (choice != 'Q'){
            
            choice = menu(scanInput);

            if(choice == '1'){
                Games.lotteryGame(scanInput);
            }
            else if(choice == '2'){
                Games.playCraps(scanInput);
            }
            else if(choice == '3'){
                Games.playScraps(scanInput);
            }
            else if(choice == '6'){
                PlayBlackjack.playBlackjack(scanInput);
            }
            else if(choice == '7'){
                PlayHangman.playHangman(scanInput);
            }
        }

        scanInput.close();

    }

    public static char menu(Scanner input){
        char choice = 'Z';
        String inputString;

        //menu loop
        //   print menu
        //   get response & convert to upper case

        System.out.println("\nChoose a game:");
        System.out.println("1 - Lottery");
        System.out.println("2 - Craps");
        System.out.println("3 - Scraps");
        System.out.println("6 - Blackjack");
        System.out.println("7 - Hangman");
        System.out.println("Q - Quit");

        inputString = input.nextLine().toUpperCase();
 
        if(inputString.length() > 0){
            choice = inputString.charAt(0);
        }

        return choice;
    }
}

