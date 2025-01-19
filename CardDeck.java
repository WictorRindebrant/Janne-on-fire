import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
    ArrayList<Card> cardDeck = new ArrayList<>();

    public CardDeck() {}

    public void addCard(Card card) {
        this.cardDeck.add(card);
    }

    public Card getCard(int number) {
        return cardDeck.get(number - 1);
    }

    public ArrayList<Card> getDeck() {
        return this.cardDeck;
    }

    public void sortDeck() {
        this.cardDeck.sort((card1, card2) -> card1.getType().compareTo(card2.getType()));
    }

    public void scrambleDeck() {
        Collections.shuffle(this.cardDeck);
    }

    public void drawCard() {
        if(cardDeck.size() != 0) {
            cardDeck.get(0);
            cardDeck.remove(0);
        } else {
            System.out.println("GAME OVER");
        }
    }
}
