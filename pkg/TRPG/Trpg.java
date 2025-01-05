package pkg.TRPG;

//=======  (??? what are these equal signs for ???)
public class Trpg {
    //public int first=(int)(Math.random()*6+1);
    //public int second=(int)(Math.random()*6+1);
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

    public static int rollDice(){ // the random number must be either static or defined within the method in order to be used in static method
        int first = (int)(Math.random()*6+1);
        int second = (int)(Math.random()*6+1);
        System.out.println(Trpg.returnDiceStr(first));
        System.out.println(Trpg.returnDiceStr(second));        
        int x = first + second;
        return x;
    }
}
