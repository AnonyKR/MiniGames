package pkg.pokerBasic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Player {
    private int money;
    private Board game;
    private Deck usedDeck;
    private ArrayList<Integer> hand;
    private Scanner sc;

    public Player() {
        sc = new Scanner(System.in);
        money = 0;
        game = new Board();
        usedDeck = this.game.usingDeck();
        hand = new ArrayList<>();
    }

    public Player(int money, Board game) {
        sc = new Scanner(System.in);
        this.money = money;
        this.game = game;
        usedDeck = this.game.usingDeck();
        hand = new ArrayList<>();
    }

    public void gain(int money) {
        this.money += money;
    }

    public int lose(int money) { // 0 is returned if unable to subtract
        if (money > this.money) {
            return 0;
        }
        this.money -= money;
        return money;
    }

    public boolean betPoss(int money) {
        if (this.money >= money) {
            this.money -= money;
            return true;
        }
        return false;
    }

    public void pullACard() {
        hand.add(usedDeck.pullACard());
        game.updateDeck(usedDeck);
    }

    public void pullCards(int num) {
        hand.addAll(usedDeck.pullCards(num));
        game.updateDeck(usedDeck);
    }

    public void sortHand() {
        Collections.sort(hand, Comparator.comparing(Integer::valueOf));
    }

    public void returnHand() {
        usedDeck.returnCards(hand);
        hand.clear();
    }

    public void showHand() {
        System.out.println("Current hand: ");
        for (int i = 0; i < hand.size(); i++) {
            System.out.print(Deck.cardIntToStr(hand.get(i)) + "  ");
        }
    }
    
    public ArrayList<Integer> getRaw() {
        return hand;
    }

    public void bet(int money) {
        this.money -= money;
        game.bet(money);
    }

    public void win() {
        money += game.prizeMoney();
    }

    public int getMoney() {
        return money;
    }

    public ArrayList<Integer> getHand() {
        return hand;
    }

    public void updateBoard(Board changeBoard) {
        game = changeBoard;
    }

    public Board getBoard() {
        return game;
    }
}
