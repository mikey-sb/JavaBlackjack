import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;
    private Card newCard;
    private ArrayList<String> suitList;
    private CardValue cardValue;
    private Player player;
    private Player dealer;


    public Deck(ArrayList<Card> cards) {
        this.cards = cards;
        this.suitList = new ArrayList<String>();
        this.player = new Player(null);
        this.dealer = new Player(null);
        this.suitList.add("spades");
        this.suitList.add("diamonds");
        this.suitList.add("clubs");
        this.suitList.add("hearts");
    }

    public int getDeckSize() {
        return cards.size();
    }

    public int getFirstCardValue() {
        Card firstCard = cards.get(0);
        return firstCard.getValue();
    }

    public String getFirstCardSuit() {
        Card firstCard = cards.get(0);
        return firstCard.getSuit();
    }

    public int getSecondCardValue() {
        Card firstCard = cards.get(1);
        return firstCard.getValue();
    }

    public String getSecondCardSuit() {
        Card firstCard = cards.get(1);
        return firstCard.getSuit();
    }


    public void assembleDeck () {
        for (CardValue value : this.cardValue.values()) {
            for (String suit : this.suitList) {
                this.newCard = new Card(value, suit);
                this.cards.add(this.newCard);
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public void dealCards() {
        Card card1 = this.cards.remove(0);
        Card card2 = this.cards.remove(0);
        Card card3 = this.cards.remove(0);
        Card card4 = this.cards.remove(0);

        this.player.setHand(card1, card2);
        this.dealer.setHand(card3, card4);

        // HANDOUTS


    }

    public void printHands(){
        System.out.println("PLAYER HAND");
        System.out.println(this.player.hand.get(0).getValue());
        System.out.println(this.player.hand.get(0).getSuit());
        System.out.println(this.player.hand.get(1).getValue());
        System.out.println(this.player.hand.get(1).getSuit());

        System.out.println("DEALER HAND");
        System.out.println(this.dealer.hand.get(0).getValue());
        System.out.println(this.dealer.hand.get(0).getSuit());
        System.out.println(this.dealer.hand.get(1).getValue());
        System.out.println(this.dealer.hand.get(1).getSuit());
    }

    public ArrayList<Card> getPlayerHand(){
        return this.player.hand;
    }
    public ArrayList<Card> getDealerHand(){
        return this.player.hand;
    }

    public boolean compareHands(){
        int playerTotal = 0;
        int dealerTotal = 0;
        for(int i = 0; i < getPlayerHand().size(); i++){
            playerTotal += this.player.hand.get(i).getValue();
        }
        for(int i = 0; i < getDealerHand().size(); i++){
            dealerTotal += this.dealer.hand.get(i).getValue();
        }

        System.out.println(playerTotal);
        System.out.println(dealerTotal);

        if(playerTotal > dealerTotal)
        { return true; }
        else
        { return false; }

    }
}
