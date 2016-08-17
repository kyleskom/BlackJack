
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
			valuestring = RANKS[0];
			value = 2;
		} else if (cvalue == 1) {
			valuestring = RANKS[1];
			value = 3;
		} else if (cvalue == 2) {
			valuestring = RANKS[2];
			value = 4;
		} else if (cvalue == 3) {
			valuestring = RANKS[3];
			value = 5;
		} else if (cvalue == 4) {
			valuestring = RANKS[4];
			value = 6;
		} else if (cvalue == 5) {
			valuestring = RANKS[5];
			value = 7;
		} else if (cvalue == 6) {
			valuestring = RANKS[6];
			value = 8;
		} else if (cvalue == 7) {
			valuestring = RANKS[7];
			value = 9;
		} else if (cvalue == 8) {
			valuestring = RANKS[8];
			value = 10;
		} else if (cvalue == 9) {
			valuestring = RANKS[9];
			value = 10;
		} else if (cvalue == 10) {
			valuestring = RANKS[10];
			value = 10;
		} else if (cvalue == 11) {
			valuestring = RANKS[11];
			value = 10;
		} else {
			valuestring = RANKS[12];
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
