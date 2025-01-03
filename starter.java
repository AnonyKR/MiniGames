import pkg.TRPG.*;
import java.util.Random;
import java.util.Scanner;

class starter {
	public static void main(String args[]) {
        int first=(int)(Math.random()*6+1);
        int second=(int)(Math.random()*6+1);
        System.out.println(Trpg.rollDice(first, second));
        
        //setting up character
        Scanner sc=new Scanner(System.in);
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
        if(a.equals(job)||b.equals(job)){
                job="archer";
                System.out.println("You chose a archer");
        }
        else if(c.equals(job)||d.equals(job)){
                job="warrior";
                System.out.println("You chose a warrior");
        }
        else if(e.equals(job)||f.equals(job)){
                job="knight";
                System.out.println("You chose a knight");

        }



	}
}
