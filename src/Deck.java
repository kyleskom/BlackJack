import java.util.ArrayList;

public class Deck {
	ArrayList<Card> deck = new ArrayList<Card>();

	public Deck() {
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				deck.add(new Card(j, i));
			}
		}
		// System.out.println(deck.toString());
	}

	public Card getCard(int index) {
		Card c = deck.get(index);
		deck.remove(index);
		return c;
	}
}
