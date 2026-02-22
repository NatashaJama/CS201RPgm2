import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PlayHangman {

    //PRE:  accepts scanner input from main
    //POST: Reads words from an input file into the wordList
    //      should loop while the player wants to play
    //      selecting a random word from wordList & allowing the user
    //      to guess letters to fill in the words (see assignment for more detail)
    public static void playHangman(Scanner input) {
        System.out.println("\nWELCOME TO HANGMAN!!\n");
        Random random = new Random();
        ArrayList<String> wordList = new ArrayList<>();

        //load words into the ArrayList
        try (Scanner fileScanner = new Scanner(new File("words.txt"))) {
            while (fileScanner.hasNextLine()) {
                String word = fileScanner.nextLine().trim().toLowerCase();
                if (!word.isEmpty()) {
                    wordList.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: words.txt file not found.");
            return;
        }

        if (wordList.isEmpty()) {
            System.out.println("The words.txt file is empty.");
            return;
        }            

        boolean keepPlaying = true;

        System.out.println("Welcome to Hangman!");

        while (keepPlaying) {
          
            String word = wordList.get(random.nextInt(wordList.size()));

            char[] guessWord = new char[word.length()];
            Arrays.fill(guessWord, '_');

            int guesses = 6;

            while(guesses > 0){

                System.out.println("Word: " + String.valueOf(guessWord));
                System.out.print("Guess a letter: ");
                char guess = input.next().charAt(0);

                boolean found = false;

                for(int i = 0; i < word.length(); i++){
                    if(word.charAt(i) == guess){
                        guessWord[i] = guess;
                        found = true;
                    }
                }

                if(!found){
                    guesses--;
                    System.out.println("Wrong! Guesses left: " + guesses);
                }

                if(String.valueOf(guessWord).equals(word)){
                    System.out.println("You guessed it!");
                    break;
                }
            }

            System.out.print("Play again? (y/n): ");
            char again = input.next().charAt(0);

            if(again == 'n' || again == 'N'){
                keepPlaying = false;
            }
        }

        System.out.println("Thanks for playing Hangman!");
    }
}
