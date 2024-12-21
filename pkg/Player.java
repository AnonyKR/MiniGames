package pkg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Player {
    private double money;
    private Board game;
    private Deck usedDeck;
    private ArrayList<Integer> hand;

    public Player() {
        money = 0.0;
        game = new Board();
        usedDeck = this.game.usingDeck();
    }

    public Player(double money, Board game) {
        this.money = money;
        this.game = game;
        usedDeck = this.game.usingDeck();
    }

    public void gain(double money) {
        this.money += money;
    }

    public void pullACard() {
        hand.add(usedDeck.pullACard());
        Collections.sort(hand, Comparator.comparing(Integer::valueOf));
    }

    public void pullCards(int num) {
        hand.addAll(usedDeck.pullCards(num));
        Collections.sort(hand, Comparator.comparing(Integer::valueOf));
    }

    public void returnHand() {
        usedDeck.returnCards(hand);
        hand.clear();
    }

    public void bet(double money) {
        this.money -= money;
        game.bet(money);
    }

    public void win() {
        money += game.prizeMoney();
    }

    public double getMoney() {
        return money;
    }

    public ArrayList<Integer> getHand() {
        return hand;
    }
}
