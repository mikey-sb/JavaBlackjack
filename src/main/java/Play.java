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
        Deck deck = new Deck(null);
        Card card = new Card(null, null);
        Player player = new Player(null);
        Play play = new Play(deck, null, null, null);

        play.deal();
        play.run();
    }
    
    public void deal (){
        deck.assembleDeck();
        deck.shuffleDeck();
        deck.dealCards();
        deck.printHands();
    }

    public boolean run (){
        System.out.println("stick or twist?");
        String input = sc.nextLine();
        if (input.equals("twist")) {
            deck.playerDrawACard();
            run();
        }
        return true;
    }
}
