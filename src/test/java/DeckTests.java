import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DeckTests {

    Deck deck;
    Card card;

    @Before
    public void setUp() {
        ArrayList<Card> cards = new ArrayList<>();
        deck = new Deck(cards);
    }

    @Test
    public void deckCanBeAssembled() {
        deck.assembleDeck();
        assertEquals(52, deck.getDeckSize());
    }



}
