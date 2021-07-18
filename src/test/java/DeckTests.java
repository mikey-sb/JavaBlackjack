import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DeckTests {

    Deck deck;
    Player player;


    @Before
    public void setUp() {
        ArrayList<Card> cards = new ArrayList<>();
        ArrayList<Card> hand = new ArrayList<>();

        deck = new Deck(cards);
        player = new Player(null, 0);

    }

    @Test
    public void deckCanBeAssembled() {
        deck.assembleDeck();
        assertEquals(52, deck.getDeckSize());
    }

    @Test
    public void deckIsInInitOrder() {
        deck.assembleDeck();
        assertEquals(1, deck.getFirstCardValue());
        assertEquals("spades", deck.getFirstCardSuit());
        assertEquals(1, deck.getSecondCardValue());
        assertEquals("diamonds", deck.getSecondCardSuit());
    }

    @Test
    public void deckCanBeShuffled(){
        deck.assembleDeck();
        deck.shuffleDeck();
        assertNotEquals(1, deck.getFirstCardValue());
    }

    @Test
    public void cardsCanBeDealtToPlayer(){
        deck.assembleDeck();
        deck.shuffleDeck();
        deck.dealCards();
        assertEquals(2, deck.getPlayerHand().size());
    }

    @Test
    public void cardsCanBeDealtToDealer(){
        deck.assembleDeck();
        deck.shuffleDeck();
        deck.dealCards();
        assertEquals(2, deck.getDealerHand().size());
    }

    @Test
    public void playerCanDrawCard() {
        deck.assembleDeck();
        deck.shuffleDeck();
        deck.dealCards();
        deck.playerDrawACard();
        assertEquals(3, deck.getPlayerHand().size());
    }

    @Test
    public void playerCanDrawTwoCards() {
        deck.assembleDeck();
        deck.shuffleDeck();
        deck.dealCards();
        deck.playerDrawACard();
        deck.playerDrawACard();
        assertEquals(4, deck.getPlayerHand().size());
    }

    @Test
    public void dealerCanDrawACard(){
        deck.assembleDeck();
        deck.shuffleDeck();
        deck.dealCards();
        deck.dealerDrawACard();
        assertEquals(3, deck.getDealerHand().size());
    }

    @Test
    public void play(){
        deck.deal();
        deck.runPlayer();
        deck.runDealer();
        deck.printHands();
        deck.compareHands();
    }

}





