package pkg;

import java.util.ArrayList;

public class Blackjack{
    private Player player;
    private Board board;

    public Blackjack() {
        player = new Player();
        board = new Board(6);
    }

    public Blackjack(Player player) {
        this.player = player;
        board = new Board(6);
    }

    public Player getPlayer() {
        return player;
    }

    public void updatePlayer(Player player) {
        this.player = player;
    }

    public static int sum(ArrayList<Integer> cards) {
        int sum = 0;
        for (int i = 0; i < cards.size(); i++) {
            sum += (
                switch (cards.get(i) % 13) {
                    case 9,10,11 -> 10;
                    case 12 -> 1;
                    default -> cards.get(i) % 13 + 2;
                }
            );
        }
        return sum;
    }

    public static int aces(ArrayList<Integer> cards) {
        int sum = 0;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i) % 13 == 12) {
                sum++;
            }
        }
        return sum;
    }
}