import java.util.ArrayList;
import java.util.Random;

public class BlackJack {

	public int dealervalue;
	public int playervalue;
	public Deck d;
	public Random card;
	public Card dealerfacedown;
	public ArrayList<Card> playerhand;
	public ArrayList<Card> dealerhand;
	public boolean dealerblackjack;
	public boolean playerblackjack;

	public BlackJack() {
		d = new Deck();
		playerhand = new ArrayList<Card>();
		dealerhand = new ArrayList<Card>();
		dealervalue = 0;
		playervalue = 0;
		deal();
	}

	public int ranNum() {
		card = new Random();
		return card.nextInt(d.deck.size());
	}

	public Card randomCard() {
		return d.getCard(ranNum());
	}

	public void deal() {
		playerhand.add(randomCard());
		dealerhand.add(randomCard());

		playerhand.add(randomCard());
		dealerfacedown = randomCard();
	}

	public void playerHit() {
		playerhand.add(randomCard());
	}

	public void dealerHit() {
		dealerhand.add(randomCard());
	}

	public int playerHandValue() {
		playervalue = 0;
		for (int i = 0; i < playerhand.size(); i++) {
			playervalue += playerhand.get(i).value;
		}
		return playervalue;
	}

	public int dealerHandValue() {
		dealervalue = 0;
		for (int i = 0; i < dealerhand.size(); i++) {
			dealervalue += dealerhand.get(i).value;
		}
		return dealervalue;
	}

	public void addFaceDown() {
		dealerhand.add(dealerfacedown);
	}
	

	public boolean playerBlackJack() {
		if ((playerHandValue() == 21) && (dealervalue + dealerfacedown.value != 21)) {
			playerblackjack = true;
			return playerblackjack;
		} 
		playerblackjack = false;
		return playerblackjack;
	}
	
	public boolean dealerBlackJack(){
		if ((playervalue != 21) && (dealervalue + dealerfacedown.value == 21)) {
			dealerblackjack = true;
			return dealerblackjack;
	}
		dealerblackjack = false;
		return false;
	}
}
