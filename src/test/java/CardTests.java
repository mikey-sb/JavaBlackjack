import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTests {

    Card card;
    Deck deck;

    @Before
    public void setUp(){
        card = new Card(CardValue.ACE, "spades");
    }


    @Test
    public void cardHasValue() {
        assertEquals(1, card.getValue());
    }

    @Test
    public void cardHasSuit() {
        assertEquals("spades", card.getSuit());
    }




}
