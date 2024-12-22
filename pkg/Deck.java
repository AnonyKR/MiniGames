package pkg;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	ArrayList<Integer> cards;
	ArrayList<Integer> discards;
	public Deck() {
		this.cards = new ArrayList<>();
		this.discards = new ArrayList<>();
		for (int i = 0; i < 52; i++) {
			this.cards.add(i);
		}
		this.shuffle();
	}
	
	public Deck(int setsOfDecks) {
		this.cards = new ArrayList<>();
		this.discards = new ArrayList<>();
		for (int i = 0; i < 52; i++) {
			for (int j = 0; j < setsOfDecks; j++)
				this.cards.add(i);
		}
		this.shuffle();
	}
	
	public static String cardIntToStr(int card) {
		String shape;
		switch(card / 13) {
			case 0:
				shape = "\u2660"; //spade filled
				break;
			case 1:
				shape = "\u2663"; //clubs filled
				break;
			case 2:
				shape = "\u2661"; //heart empty
				break;
			case 3:
				shape = "\u25C7"; //diamond empty
				break;
			default:
				shape = "error";
		}
		shape += " ";
		switch(card % 13) {
			case 9:
				shape += "J";
				break;
			case 10:
				shape += "Q";
				break;
			case 11:
				shape += "K";
				break;
			case 12:
				shape += "A";
				break;
			default:
				shape += (card % 13 + 2);
		}
		return shape;
	}
	
	public void shuffle() {
		this.cards.addAll(this.discards);
		this.discards.clear();
		Collections.shuffle(this.cards);
	}

	public int pullACard() {
		if (this.cards.size() < 1) {
			this.shuffle();
		}
		int holdIntTemp = this.cards.get(0);
		this.cards.remove(0);
		return holdIntTemp;
	}

	public ArrayList<Integer> pullCards(int numOfCards) {
		ArrayList<Integer> returnCards = new ArrayList<>();
		while(returnCards.size() != numOfCards) {
			returnCards.add(this.pullACard());
		}
		return returnCards;
	}

	public void returnCard(int cardReturned) {
		this.discards.add(cardReturned);
	}

	public void returnCards(ArrayList<Integer> cardsReturned) {
		this.discards.addAll(cardsReturned);
	}

}
