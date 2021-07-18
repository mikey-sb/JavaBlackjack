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

    public void assembleDeck() {
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

    public void twist() {
        this.playerCards.add(this.cards.remove(0));

        this.player.setHand(this.playerCards);
    }

    public void printHands() {
        System.out.println("PLAYER HAND");
        for (int i = 0; i < player.getHandLength(); i++) {
            System.out.println(this.player.hand.get(i).getValue());
            System.out.println(this.player.hand.get(i).getSuit());
        }

        System.out.println("DEALER HAND");
        for (int i = 0; i < dealer.getHandLength(); i++) {
            System.out.println(this.dealer.hand.get(i).getValue());
            System.out.println(this.dealer.hand.get(i).getSuit());
        }
    }

    public ArrayList<Card> getPlayerHand() {
        return this.player.hand;
    }

    public ArrayList<Card> getDealerHand() {
        return this.dealer.hand;
    }

    public int getPlayerTotal() {
        int playerTotal = 0;
        for (int i = 0; i < getPlayerHand().size(); i++) {
            playerTotal += this.player.hand.get(i).getValue();
        }
        player.setTotal(playerTotal);
        return playerTotal;
    }

    ;

    public int getDealerTotal() {
        int dealerTotal = 0;
        for (int i = 0; i < getDealerHand().size(); i++) {
            dealerTotal += this.dealer.hand.get(i).getValue();
        }
        dealer.setTotal(dealerTotal);
        return dealerTotal;
    }

    ;
    public void getHandStatus(){

        getPlayerTotal();
        getDealerTotal();

        int playerTotal = player.getTotal();
        int dealerTotal = dealer.getTotal();

        if (playerTotal > 21) {
            System.out.println("PLAYER IS BUST!!");
        } else if (playerTotal == 21) {
            System.out.println("PLAYER GETS BLACKJACK!!");
        }

        if (dealerTotal > 21) {
            System.out.println("DEALER IS BUST!!");
        } else if (dealerTotal == 21) {
            System.out.println("DEALER GETS BLACKJACK!!");
        }

    }
    public void compareHands() {

        getPlayerTotal();
        getDealerTotal();

        int playerTotal = player.getTotal();
        int dealerTotal = dealer.getTotal();

        getHandStatus();


        if (playerTotal > dealerTotal && playerTotal <= 21) {
            System.out.println("PLAYER is the winner!!");
        } else if (playerTotal == dealerTotal && playerTotal <= 21) {
            System.out.println("TIE GAME");
        } else if (dealerTotal > playerTotal && dealerTotal <= 21) {
            System.out.println("DEALER is the winner!!");
        } else if (dealerTotal > 21 && playerTotal > 21) {
            System.out.println("DOUBLE BUST!!");
        }

    }

    public void setPlayerCards(ArrayList<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public void playerDrawACard() {
        Card card = this.cards.remove(0);

        ArrayList<Card> newCard = new ArrayList<Card>();

        newCard.add(card);

        this.playerCards.add(card);
        this.player.setHand(newCard);

    }

    public void dealerDrawACard() {
        Card card = this.cards.remove(0);

        ArrayList<Card> newCard = new ArrayList<Card>();

        newCard.add(card);

        this.dealerCards.add(card);
        this.dealer.setHand(newCard);
    }

    public void deal() {
        assembleDeck();
        shuffleDeck();
        dealCards();

    }

    public void runPlayer() {

        while (getPlayerTotal() < 16) {
            playerDrawACard();
//            printHands();
        }

    }

    public void runDealer() {

        while (getDealerTotal() < 16) {
            dealerDrawACard();
        }
    }
}



//        printHands();

//        if (getDealerHand().size() < 16){
//                dealerDrawACard();
//                run();
//            }
//
//
//        if (compareHands()){
//            System.out.println("Player is the winner!");
//        } else {
//            System.out.println("Dealer is the winner!");
//        };


