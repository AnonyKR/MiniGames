import pkg.pokerBasic.Player;

class starter {
	public static void main(String args[]) {
		Player me = new Player();
		me.pullCards(5);
		me.showHand();
	}
}
