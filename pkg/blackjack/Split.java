package pkg.blackjack;
import java.util.ArrayList;

public class Split {
    private ArrayList<Integer> hand;
    private int bet;

    public Split() {
        hand = new ArrayList<>();
        bet = 0;
    }

    public Split(int money) {
        hand = new ArrayList<>();
        bet = money;
    }

    public Split(ArrayList<Integer> cards) {
        hand = cards;
        bet = 0;
    }

    public Split(int money, ArrayList<Integer> cards) {
        hand = cards;
        bet = money;
    }

    public void addBet(int bet) {
        this.bet = bet;
    }

    public void newHand(ArrayList<Integer> cards) {
        hand = cards;
    }
}
