package pkg;

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

    public void pullACard() {
        hand.add(usedDeck.pullACard());
        Collections.sort(hand, Comparator.comparing(Integer::valueOf));
        game.updateDeck(usedDeck);
    }

    public void pullCards(int num) {
        hand.addAll(usedDeck.pullCards(num));
        Collections.sort(hand, Comparator.comparing(Integer::valueOf));
        game.updateDeck(usedDeck);
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

    public boolean askYesOrNo(String question) {
        String answer;
        while (true) {
            System.out.print(question);
            answer = sc.nextLine().toLowerCase();
            switch (answer) {
                case "y", "yes":                   
                    return true;
                case "n", "no":
                    return false;
                default:
                    System.out.println("Invalid input. Please try again");
            }
        }
    }

    public double askDouble(String question) {
        while(true) {
            try {
                System.out.print(question);
                return sc.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again");
            }
        }
    }

    public int askInt(String question) {
        while (true) {
            double answer = this.askDouble(question);
            if (answer - ((int) answer) == 0.0) {
                return (int) answer;
            } else {
                System.out.println("Invalid input. Please try again");
            }
        }
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
