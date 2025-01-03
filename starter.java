import pkg.TRPG.*;

class starter {
	public static void main(String args[]) {
        int first=(int)(Math.random()*6+1);
        int second=(int)(Math.random()*6+1);
        System.out.println(Trpg.rollDice(first, second));        
	}
}
