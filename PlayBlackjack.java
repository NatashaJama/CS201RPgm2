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
            playerHand.add(deck.get(deckIndex++));
            dealerHand.add(deck.get(deckIndex++));
            playerHand.add(deck.get(deckIndex++));
            dealerHand.add(deck.get(deckIndex++));

            // Player turn
            boolean playerBust = false;
            char choice = 'y';

            while(choice == 'y'){
                System.out.println("Your Hand: " + getHandString(playerHand));
                System.out.println("Total: " + getHandValue(playerHand));
                System.out.print("Hit? (y/n): ");
                choice = scanner.next().charAt(0);

                if(choice == 'y'){
                    playerHand.add(deck.get(deckIndex++));
                    if(getHandValue(playerHand) > 21){
                        playerBust = true;
                        break;
                    }
                }
            }

            // Dealer turn
            while(getHandValue(dealerHand) <= 17){
                dealerHand.add(deck.get(deckIndex++));
            }

            // Determine winner
            int playerTotal = getHandValue(playerHand);
            int dealerTotal = getHandValue(dealerHand);

            System.out.println("Dealer Hand: " + getHandString(dealerHand));
            System.out.println("Dealer Total: " + dealerTotal);

            if(playerBust){
                System.out.println("You lose!");
            }
            else if(dealerTotal > 21 || playerTotal > dealerTotal){
                System.out.println("You win!");
            }
            else if(playerTotal == dealerTotal){
                System.out.println("Push!");
            }
            else{
                System.out.println("You lose!");
            }

            System.out.print("Play again? (y/n): ");
            char again = scanner.next().charAt(0);
            if(again == 'n' || again == 'N'){
                keepPlaying = false;
            }
        }

        System.out.println("Thanks for playing!");
    }

    public static int getCardValue(int cardNumber) {
        int faceValue = (cardNumber - 1) % 13 + 1;
        if (faceValue >= 10) return 10; 
        return faceValue;
    }

    public static String getHandString(List<Integer> hand) {
        List<String> cards = new ArrayList<>();
        for (int card : hand) {
            cards.add(cardToString(card));
        }
        return String.join(", ", cards);
    }

    public static String cardToString(int cardNumber) {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] faces = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        int faceIndex = (cardNumber - 1) % 13;
        int suitIndex = (cardNumber - 1) / 13;

        return faces[faceIndex] + " of " + suits[suitIndex];
    }

    public static int getHandValue(List<Integer> hand) {
        int total = 0;
        int aceCount = 0;

        for(int card : hand){
            int value = getCardValue(card);

            if(value == 1){
                aceCount++;
                total += 11;
            }
            else{
                total += value;
            }
        }

        while(total > 21 && aceCount > 0){
            total -= 10;
            aceCount--;
        }

        return total;
    }
}
