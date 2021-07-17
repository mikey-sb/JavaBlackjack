import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Deck {
    private ArrayList<Card> cards;
    private ArrayList<Card> playerCards;
    private ArrayList<Card> dealerCards;
    private Card newCard;
    private ArrayList<String> suitList;
    private CardValue cardValue;
    private Player player;
    private Player dealer;


    public Deck(ArrayList<Card> cards) {
        this.cards = cards;
        this.suitList = new ArrayList<String>();
        this.playerCards = new ArrayList<>();
        this.dealerCards = new ArrayList<>();
        this.player = new Player(null, 0);
        this.dealer = new Player(null, 0);
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
        for (CardValue value : CardValue.values()) {
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

        this.playerCards.add(this.cards.remove(0));
        this.playerCards.add(this.cards.remove(0));

        this.dealerCards.add(this.cards.remove(0));
        this.dealerCards.add(this.cards.remove(0));

        this.player.setHand(this.playerCards);
        this.dealer.setHand(this.dealerCards);
    }

    public void twist(){
        this.playerCards.add(this.cards.remove(0));
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

    public void getPlayerTotal(){
        int playerTotal = 0;
        for(int i = 0; i < getPlayerHand().size(); i++){
            playerTotal += this.player.hand.get(i).getValue();
        }
        player.setTotal(playerTotal);
    };

    public void getDealerTotal(){
        int dealerTotal = 0;
        for(int i = 0; i < getDealerHand().size(); i++){
            dealerTotal += this.dealer.hand.get(i).getValue();
        }
        dealer.setTotal(dealerTotal);
    };

    public boolean compareHands(){

        getPlayerTotal();
        getDealerTotal();

        int playerTotal = player.getTotal();
        int dealerTotal = dealer.getTotal();

        if(playerTotal > dealerTotal)
        { return true; }
        else
        { return false; }

    }

    public void setPlayerCards(ArrayList<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public void playerDrawACard(){
        Card card = this.cards.remove(0);
        this.playerCards.add(card);
        this.player.setHand(this.playerCards);
    }
}
