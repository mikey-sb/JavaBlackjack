import java.util.ArrayList;

public class Player {
    public Deck deck;
    public ArrayList<Card> hand;

    public Player(ArrayList<Card> hand) {
        this.hand = new ArrayList<>();
    }

    public void setHand(Card card1, Card card2) {
        this.hand.add(card1);
        this.hand.add(card2);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getHandLength() {
        return hand.size();
    }

}
