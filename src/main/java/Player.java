import java.util.ArrayList;

public class Player {
    public Deck deck;
    public ArrayList<Card> hand;
    public int total;

    public Player(ArrayList<Card> hand, int total) {
        this.hand = new ArrayList<>();
        this.total = total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
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
