public class Card {

    private CardValue cardValue;
    private String suit;

    public Card(CardValue cardValue, String suit){
        this.cardValue = cardValue;
        this.suit = suit;
    }

    public int getValue() {
        return cardValue.getValue();
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}
