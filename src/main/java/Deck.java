import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;
    private Card newCard;
    private ArrayList<String> suitList;
    private CardValue cardValue;




    public Deck(ArrayList<Card> cards) {
        this.cards = cards;
        this.suitList = new ArrayList<String>();
        this.suitList.add("spades");
        this.suitList.add("diamonds");
        this.suitList.add("clubs");
        this.suitList.add("hearts");
    }

    public void assembleDeck () {
        for (CardValue value : this.cardValue.values()) {
            for (String suit : this.suitList) {
                this.newCard = new Card(value, suit);
                this.cards.add(this.newCard);
            }
        }
    }

    public int getDeckSize() {
        return cards.size();
    }
}
