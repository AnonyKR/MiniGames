package pkg.TRPG;

=======
public class Trpg {
    private Trpg() {
        
    }

    public static String returnDiceStr(int eyes) { //space is returned if it is out of range of (1-6)
        String returnVal = "--------------\n";
        switch (eyes) {
            case 1:
                returnVal += "|            |\n|      @     |\n|            |";
                break;
            case 2:
                returnVal += "|            |\n|   @    @   |\n|            |";
                break;
            case 3:
                returnVal += "|   @     @  |\n|            |\n|      @     |";
                break;
            case 4:
                returnVal += "|   @     @  |\n|            |\n|   @     @  |";
                break;
            case 5:
                returnVal += "|   @     @  |\n|      @     |\n|   @     @  |";
                break;
            case 6:
                returnVal += "|   @    @   |\n|   @    @   |\n|   @    @   |";
                break;
            default:
                return " ";
        }
        returnVal += "\n--------------";
        return returnVal;
    }

    public static int rollDice(int first, int second){
        System.out.println(Trpg.returnDiceStr(first));
        System.out.println(Trpg.returnDiceStr(second));        
        int x=0;
        x=first+second;
        return x;

        
    }
}
