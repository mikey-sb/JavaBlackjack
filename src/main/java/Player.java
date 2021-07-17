import java.util.ArrayList;

public class Player {
    public Deck deck;
    public ArrayList<Card> hand;

    public Player(ArrayList<Card> hand) {
        this.hand = new ArrayList<>();
    }

    public void setHand(ArrayList<Card> cards) {
        for(int i = 0; i < cards.size(); i++){
            this.hand.add(cards.get(i));
        }
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getHandLength() {
        return hand.size();
    }

}
