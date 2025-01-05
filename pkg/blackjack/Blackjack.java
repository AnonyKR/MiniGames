package pkg.blackjack;

import java.util.ArrayList;
import pkg.pokerBasic.*;

public class Blackjack{
    private Player player;
    private Board board;
    private ArrayList<Integer> dealer;
    private Deck deck;
    private Split[] sets;
    private int currentSet;

    public Blackjack() {
        player = new Player();
        board = new Board(6);
        player.updateBoard(board);
        deck = board.usingDeck();
        dealer = new ArrayList<>();
    }

    public Blackjack(Player player) {
        this.player = player;
        board = new Board(6);
        player.updateBoard(board);
        deck = board.usingDeck();
        dealer = new ArrayList<>();
    }

    public Player getPlayer() {
        return player;
    }

    public void updatePlayer(Player player) {
        this.player = player;
    }

    public void playRound() {
        //1. betting
        int roundBet = Tools.askInt("How much would you like to bet? (int)");
        //2. cards given
        sets = new Split[4]; // this 4 is due to 4 splits being the limitation for the splits for blackjack
        currentSet = 0;
        sets[0] = new Split(roundBet, deck.pullCards(2));
        dealer.addAll(deck.pullCards(2));
        //Do the display here
        //3. split (*1 if 21 immediate) (4 max) or blackjack (*1.5)
        if (sets[0].isBlackjack()) {
            //Show player have blackjack
            if (Blackjack.isBlackjack(dealer)) {
                //Show it is a tie
                //Give money back
                return;
            }
            //Show player won
            // *1.5 and give money back
            return;
        }
        if (Blackjack.isBlackjack(dealer)) {
            //Show dealer have blackjack
            //Show player lost
            //Take money and gone
            return;
        }
        //4. hit, stay, double down, surrender (*0.5)

        //5. dealer gets card (17+ stay)

        //6. get money
    }

    public void display() {
        if (currentSet != 0) {

        }
    }

    public void play() {
        while(true) {
            this.playRound();
            if(!Tools.askYesOrNo("Play again? (Y/N)")) {
                break;
            }
        }
    }

    public static int sum(ArrayList<Integer> cards) { // -1 is returned if it is bust
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
        if (sum > 21) {
            return -1;
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

    public static int maxSum (ArrayList<Integer> cards) { // -1 is returned if it is bust
        int sum = Blackjack.sum(cards);
        int aces = Blackjack.aces(cards);
        if (sum == -1) {
            return -1;
        }
        while(aces > 0 && sum <= 21) {
            sum += 10;
            aces--;
            if (sum > 21) {
                sum -= 10;
                break;
            }
        }
        return sum;
    }

    public static int maxSum (int minSum, int acesNum) { // -1 is returned if it is bust
        int sum = minSum;
        int aces = acesNum;
        if (sum == -1) {
            return -1;
        }
        while(aces > 0 && sum <= 21) {
            sum += 10;
            aces--;
            if (sum > 21) {
                sum -= 10;
                break;
            }
        }
        return sum;
    }

    public static boolean isBlackjack(ArrayList<Integer> cards) {
        return Blackjack.maxSum(cards) == 21 && cards.size() == 2;
    }

    public static boolean splitPoss(ArrayList<Integer> cards) {
        return cards.size() == 2 && cards.get(0) % 13 == cards.get(1) % 13;
    }
}