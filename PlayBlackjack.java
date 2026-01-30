import java.util.*;
public class PlayBlackjack {

    //PRE:  accepts scanner input from main
    //POST: Setps up the deck for users
    //      should loop while the player wants to play
    //      selecting a random word from wordList & allowing the user
    //      to guess letters to fill in the words (see assignment for more detail)
    public static void playBlackjack(Scanner scanner) {
        System.out.println("\nWELCOME TO BLACKJACK!!\n");
        List<Integer> deck = new ArrayList<>();

        // Initialize deck
        for (int i = 1; i <= 52; i++) {
            deck.add(i);
        }

        boolean keepPlaying = true;
        while (keepPlaying) {
            Collections.shuffle(deck);
            int deckIndex = 0;
            List<Integer> playerHand = new ArrayList<>();
            List<Integer> dealerHand = new ArrayList<>();

            // Deal initial two cards each
            // Player turn

            boolean playerBust = false;

            // Dealer turn

            // Determine winner
        }

        System.out.println("Thanks for playing!");
    }

    //PRE:  accepts the # of the card (0-51)
    //POST: determines the 'value' of the card based on position in the deck
    //      NOTE: cards 2-10 are face value, 11-13 (J, Q, K) are worth 10 each
    //           
    public static int getCardValue(int cardNumber) {
        int faceValue = (cardNumber - 1) % 13 + 1;
        if (faceValue >= 10) return 10; 
        return faceValue;
    }

    //PRE:  accepts the card values for a hand
    //POST: returns the equivalent hand in string form ("Ace of Hearts")
    public static String getHandString(List<Integer> hand) {
        List<String> cards = new ArrayList<>();
        for (int card : hand) {
            cards.add(cardToString(card));
        }
        return String.join(", ", cards);
    }

    //PRE:  Accepts the cardnumber
    //POST: Converts a card number to suit and face (e.g., "Ace of Hearts")
    public static String cardToString(int cardNumber) {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] faces = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        int faceIndex = (cardNumber - 1) % 13;
        int suitIndex = (cardNumber - 1) / 13;  //could use % 4 as well

        return faces[faceIndex] + " of " + suits[suitIndex];
    }

    //PRE:  accepts the hand
    //POST: computes the Blackjack hand value with Ace handling (1 or 11)
    //      can use the getCardValue method to do this
    //      and returns the hand total (ex: if user has J and 10 the total is 20)
    public static int getHandValue(List<Integer> hand) {
        return 0;
    }
}