/*
 *	Author:  
 *  Date: 
*/

package pkg;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;


public class deck {
	ArrayList<Integer> cards;
	ArrayList<Integer> discards;
	public deck() {
		this.cards = new ArrayList<Integer>();
		this.discards = new ArrayList<Integer>();
		for (int i = 0; i < 52; i++) {
			this.cards.add(i);
		}
	}
	
	public deck(int setsOfDecks) {
		this.cards = new ArrayList<Integer>();
		this.discards = new ArrayList<Integer>();
		for (int i = 0; i < 52; i++) {
			for (int j = 0; j < setsOfDecks; j++)
				this.cards.add(i);
		}
	}
	
	public static String cardIntToStr(int card) {
		String shape;
		switch(card / 13) {
			case 0:
				shape = new String("\u2660"); //spade filled
				break;
			case 1:
				shape = new String("\u2663"); //clubs filled
				break;
			case 2:
				shape = new String("\u2661"); //heart empty
				break;
			case 3:
				shape = new String("\u2662"); //diamond empty
				break;
			default:
				shape = new String("error");
		}
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
				shape += (card + 2);
		}
		return shape;
	}
	
	public void shuffle() {
		this.cards.addAll(this.discards);
		this.discards.clear();
		Collections.shuffle(this.cards);
	}

}
