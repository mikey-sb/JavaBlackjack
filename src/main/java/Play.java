import java.util.ArrayList;
import java.util.Scanner;

public class Play {

    public Deck deck;
    public Player player;
    public Player dealer;
    public Card card;
    Scanner sc= new Scanner(System.in);

    public Play(Deck deck, Player player, Player dealer, Card card) {
        this.deck = deck;
        this.player = player;
        this.dealer = dealer;
        this.card = card;
    }

    public static void main(String[] args){
        ArrayList<Card> cards = new ArrayList<>();
        Deck deck = new Deck(cards);

        deck.deal();
        deck.runPlayer();
        deck.runDealer();
        deck.printHands();
        deck.compareHands();
    }
}
