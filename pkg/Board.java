package pkg;

public class Board {
    private Deck dealer; 
    private int pool;

    public Board() {
        dealer = new Deck();
        pool = 0;
    }

    public Board(int decks) {
        dealer = new Deck(decks);
        pool = 0;
    }

    public void bet(int bet) {
        pool += bet;
    }

    public double prizeMoney() {
        int temp = pool;
        pool = 0;
        return temp;
    } 

    public void modifyPoolMult(int power) {
        pool *= power;
    }

    public void modifyPoolAdd(int money) {
        pool += money;
    }

    public Deck usingDeck() {
        return this.dealer;
    }

    public void updateDeck(Deck editedDeck) {
        this.dealer = editedDeck;
    }
}
