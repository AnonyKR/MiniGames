import pkg.TRPG.*;
import java.util.Random;
import java.util.Scanner;

class starter {
	public static void main(String args[]) {
        
        //System.out.println(Trpg.rollDice(first, second));
        
        //setting up character
        Scanner sc=new Scanner(System.in);
        //stats
        int HP=0;
        int MP=0;
        int dexterity=0;
        int agility=0;
        int strength=0;
        int intelligence=0;
        //rolls
        String a=new String("archer");
        String b=new String("Archer");
        String c=new String("Warrior");
        String d=new String("warrior");
        String e=new String("Knight");
        String f=new String("knight");
        System.out.println("We are going to start by choosing job");
        System.out.println("What job do you want?");
        System.out.print("Choose from archer, warrior, or a knight");
        String job=sc.nextLine();
        while(true){
                if(a.equals(job)||b.equals(job)){
                        job="archer";
                        System.out.println("You chose a archer");
                        break;
                }
                else if(c.equals(job)||d.equals(job)){
                        job="warrior";
                        System.out.println("You chose a warrior");
                        break;
                }
                else if(e.equals(job)||f.equals(job)){
                        job="knight";
                        System.out.println("You chose a knight");
                        break;
        
                }
                else{
                        System.out.println("Choose your job again");
                }

        }
        
        System.out.println("Now it's time to get your stat");
        System.out.println("You can start with each stat of 14 points at most");
        System.out.println("Roll the dice say 'roll' ");
        String roll_cmd=sc.nextLine();
        int roll_num=0;
        if(job=archer){
                dexterity=2;
                if(roll_cmd.equals("roll")){
                        dexterity= Trpg.rollDice();
                        System.out.println();

                }

        }
        else if(job=warrior){

        }
        else



	}
}
