package pkg.blackjack;

import java.util.ArrayList;
import pkg.pokerBasic.*;
import pkg.Tools;

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
        int roundBet = Tools.askInt("How much would you like to bet? (int)", player.getMoney());
        player.lose(roundBet);
        //2. cards given
        sets = new Split[4]; // this 4 is due to 4 splits being the limitation for the splits for blackjack
        currentSet = 0;
        sets[0] = new Split(roundBet, deck.pullCards(2));
        dealer.addAll(deck.pullCards(2));
        this.display();
        //3. split (*1 if 21 immediate) (4 max) or blackjack (*1.5)
        if (sets[0].isBlackjack()) {
            System.out.println("You got a blackjack!");
            if (Blackjack.isBlackjack(dealer)) {
                System.out.println("\nDealer also got blackjack...");
                System.out.println("It is a tie");
                player.gain(roundBet);
                return;
            }
            System.out.println("\nYou won!");
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
            System.out.print("Dealer: " + Deck.cardIntToStr(dealer.get(0)) + " ??");
            int loc = 0;
            while (true) { 
                if (loc + 1 > sets.length || sets[loc] == null) {
                    break;
                }
                ArrayList<String> toPrint = Deck.cardsIntToStr(sets[loc].getCards());
                System.out.print("\nSplit " + currentSet + ": ");
                for (int i = 0; i < toPrint.size(); i++) {
                    System.out.print(toPrint.get(i) + " ");
                }
                System.out.print(" Sum: " + Blackjack.sum(sets[loc].getCards()));
                if (loc == currentSet - 1) {
                    System.out.print("<<< Current Set");
                }
                loc++;
            }
        } else {
            ArrayList<String> toPrint = Deck.cardsIntToStr(dealer);
            System.out.print("Dealer: ");
            for (int i = 0; i < toPrint.size(); i++) {
                System.out.print(toPrint.get(i) + " ");
            }
            System.out.println(" Sum: " + Blackjack.sum(dealer));
            int loc = 0;
            while(sets[loc] != null) {
                System.out.println("Split " + (loc + 1) + " Sum : " + Blackjack.sum(sets[loc].getCards()));
            }
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