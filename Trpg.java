package pkg.*;
import java.util.*;

class Trpg {
    public static void main(Static args[]){-
        int first=(math.random()*9)+1;
        int second=(math.random()*9)+1;
        System.out.println(rollDice(first,second));
        
    }

    public static String returnDiceStr(int eyes) {
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

    public int rollDice(int first, int second){
        if(first==1&&second==1){
            System.out.println("--------------");
            System.out.pirntln("|            |");
            System.out.println("|      @     |");
            System.out.println("|            |");
            System.out.println("--------------");
            System.out.println("--------------");
            System.out.pirntln("|            |");
            System.out.println("|      @     |");
            System.out.println("|            |");
            System.out.println("--------------");

        }
        if(first==1&&second==2){
            System.out.println("--------------");
            System.out.pirntln("|            |");
            System.out.println("|      @     |");
            System.out.println("|            |");
            System.out.println("--------------");
            System.out.println("--------------");
            System.out.pirntln("|            |");
            System.out.println("|   @    @   |");
            System.out.println("|            |");
            System.out.println("--------------");

        }
        if(first==2&&second==1){
            System.out.println("--------------");
            System.out.pirntln("|            |");
            System.out.println("|   @    @   |");
            System.out.println("|            |");
            System.out.println("--------------");
            System.out.println("--------------");
            System.out.pirntln("|            |");
            System.out.println("|      @     |");
            System.out.println("|            |");
            System.out.println("--------------");
        }
        if(first==2&&second==2){
            System.out.println("--------------");
            System.out.pirntln("|            |");
            System.out.println("|   @    @   |");
            System.out.println("|            |");
            System.out.println("--------------");
            System.out.println("--------------");
            System.out.pirntln("|            |");
            System.out.println("|   @    @   |");
            System.out.println("|            |");
            System.out.println("--------------");
        }
        if(first==1&&second==3){
            System.out.println("--------------");
            System.out.pirntln("|            |");
            System.out.println("|      @     |");
            System.out.println("|            |");
            System.out.println("--------------");
            System.out.println("--------------");
            System.out.pirntln("|   @     @  |");
            System.out.println("|            |");
            System.out.println("|      @     |");
            System.out.println("--------------");

        }
        if(first==3&&second==1){
            System.out.println("--------------");
            System.out.pirntln("|   @     @  |");
            System.out.println("|            |");
            System.out.println("|      @     |");
            System.out.println("--------------");
            System.out.println("--------------");
            System.out.pirntln("|            |");
            System.out.println("|      @     |");
            System.out.println("|            |");
            System.out.println("--------------");

        }
        int x=0;
        x=first+second;
        return x;

        
    }
}
