
public class Card {
	String type;
	int value;
	String valuestring;
	String[] SUITS = { "♠", "♦", "♥", "♣" };
	String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

	public Card(int suit, int cvalue) {
		if (suit == 0) {
			type = SUITS[0];
		} else if (suit == 1) {
			type = SUITS[1];
		} else if (suit == 2) {
			type = SUITS[2];
		} else {
			type = SUITS[3];
		}

		if (cvalue == 0) {
			valuestring = "2";
			value = 2;
		} else if (cvalue == 1) {
			valuestring = "3";
			value = 3;
		} else if (cvalue == 2) {
			valuestring = "4";
			value = 4;
		} else if (cvalue == 3) {
			valuestring = "5";
			value = 5;
		} else if (cvalue == 4) {
			valuestring = "6";
			value = 6;
		} else if (cvalue == 5) {
			valuestring = "7";
			value = 7;
		} else if (cvalue == 6) {
			valuestring = "8";
			value = 8;
		} else if (cvalue == 7) {
			valuestring = "9";
			value = 9;
		} else if (cvalue == 8) {
			valuestring = "10";
			value = 10;
		} else if (cvalue == 9) {
			valuestring = "Jack";
			value = 10;
		} else if (cvalue == 10) {
			valuestring = "Queen";
			value = 10;
		} else if (cvalue == 11) {
			valuestring = "King";
			value = 10;
		} else {
			valuestring = "Ace";
			value = 11;
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int x) {
		value = x;
	}

	@Override
	public String toString() {
		return valuestring + type;

	}
}
