package pkg;

public class Board {
    private Deck dealer; 
    private double pool;

    public Board() {
        dealer = new Deck();
        pool = 0.0;
    }

    public Board(int decks) {
        dealer = new Deck(decks);
        pool = 0.0;
    }

    public void bet(double bet) {
        pool += bet;
    }

    public double prizeMoney() {
        double temp = pool;
        pool = 0.0;
        return temp;
    } 

    public void modifyPool(int power) {
        pool *= power;
    }

    public void modifyPool(double money) {
        pool += money;
    }

    public Deck usingDeck() {
        return this.dealer;
    }
}
