import java.util.Scanner;
import pkg.TRPG.*;

class starter {
	public static void main(String args[]) {
        
        //System.out.println(Trpg.rollDice(first, second));
        
        //setting up character
        Scanner sc=new Scanner(System.in);
        //stats
        //Not neccessary now changed to array
        // int HP=0;
        // int MP=0;
        // int dexterity=0;
        // int agility=0;
        // int strength=0;
        // int intelligence=0;
        //roles
        //roles are going to be able to change by book later with wizards
		String[] jobs = {"archer", "warrior", "knight"}; //The roles reference is too frequent => make it to array
		
        /*String a=new String("archer");
        String b=new String("Archer");
        String c=new String("Warrior");
        String d=new String("warrior");
        String e=new String("Knight");
        String f=new String("knight");
	*/	
        System.out.println("We are going to start by choosing job");
        System.out.println("What job do you want?: ");
		String job = "placeholder";
		boolean validJob = false;
        while(!validJob /*true*/){ //The loop conditions is changed in order to leave more easily
			if (!job.equals("placeholder")) {
				System.out.println("Choose your job again"); //This condition ensure that "again" sector only runs after first iteration
			}
			System.out.print("Choose from archer, warrior, or a knight: ");
        	job = sc.nextLine(); //These lines need to be inside the loop if you want to ask again
			//These lines only check if it matches with the given role, if that is a case, it can be changed into this form (since jobs are now in array)
			for (int i = 0; i < jobs.length; i++) {
				if (jobs[i].equals(job.toLowerCase())) {
					validJob = true;
					job = jobs[i];
					System.out.println("You chose a " + jobs[i]);
					break;
				}
			}
        }
        
        System.out.println("Now it's time to get your stat");
        System.out.println("You can start with each stat of 14 points at most");
        System.out.println("Roll the dice say 'roll' ");
        String roll_cmd=sc.nextLine();
        roll_cmd=roll_cmd.toLowerCase();
        int roll_num=0;
        //boolean statement to check the loop of the stat
        boolean statroll=false;
        //Please check if this works as right declaration array
        int []stat_result={0,0,0,0,0,0};
        
        if(job.equals(jobs[0])){ //Use equals method not random name that's not even a string... (also array can be referenced)
        // Base stat of archer will have little dexterity and health with little mp
        //Order will be HP,MP,dex,agil,str,int
                
                
                
                while(!statroll){
                        if(roll_cmd.equals("roll")){
                                //I believe this is right way to call array
                                
                                statroll=true;
                                //I personally prefer using prinln than \n so please do not change to \n
                                stat_result={Trpg.rollDice(),Trpg.rollDice(),Trpg.rollDice(),Trpg.rollDice(),Trpg.rollDice(),Trpg.rollDice()};
                                stat_result[0]=stat_result[0]+3;
                                stat_result[1]=stat_result[1]+3;
                                stat_result[2]=stat_result[2]+2;
                                stat_result[3]=stat_result[3]+1;
                                stat_result[5]=stat_result[5]+1;
                                System.out.println("Your stat is HP of "+stat_result[0]);
                                System.out.println("MP of "+stat_result[1]);
                                System.out.println("Dexterity of "+stat_result[2]);
                                System.out.println("Agility of "+stat_result[3]);
                                System.out.println("Strength of "+stat_result[4]);
                                System.out.println("Intelligence of "+stat_result[5]);
                                break;
                                

        
                        }
                        else{
                                System.out.print("Error, Please type again.");
                        }
                }
                

        }
        else if(job.equals(jobs[1])){
                // Base stat of warrior will have +2 str and +1 agil with -2 int, +5 HP, -1 dex and +1 MP.
                //Order will be HP,MP,dex,agil,str,int

                while(!statroll){
                        if(roll_cmd.equals("roll")){
                                //I believe this is right way to call array
                                
                                statroll=true;
                                //I personally prefer using prinln than \n so please do not change to \n
                                stat_result={Trpg.rollDice(),Trpg.rollDice(),Trpg.rollDice(),Trpg.rollDice(),Trpg.rollDice(),Trpg.rollDice()};
                                stat_result[0]=stat_result[0]+5;
                                stat_result[1]=stat_result[1]+1;
                                stat_result[2]=stat_result[2]-1;
                                stat_result[3]=stat_result[3]+1;
                                stat_result[4]=stat_result[4]+2;
                                stat_result[5]=stat_result[5]-2;
                                
                                System.out.println("Your stat is HP of "+stat_result[0]);
                                System.out.println("MP of "+stat_result[1]);
                                System.out.println("Dexterity of "+stat_result[2]);
                                System.out.println("Agility of "+stat_result[3]);
                                System.out.println("Strength of "+stat_result[4]);
                                System.out.println("Intelligence of "+stat_result[5]);
                                break;
                                

        
                        }
                        else{
                                System.out.print("Error, Please type again.");
                        }
                }
                

        }
        else if(job.equals(jobs[2])){
                while(!statroll){
                        if(roll_cmd.equals("roll")){
                                //I believe this is right way to call array
                                
                                statroll=true;
                                // Base stat of knight will have +4 HP, +1 MP, +1 dex, +2 agil, +2 str, -1 int
                                //Order will be HP,MP,dex,agil,str,int

                                stat_result={Trpg.rollDice(),Trpg.rollDice(),Trpg.rollDice(),Trpg.rollDice(),Trpg.rollDice(),Trpg.rollDice()};
                                stat_result[0]=stat_result[0]+4;
                                stat_result[1]=stat_result[1]+1;
                                stat_result[2]=stat_result[2]+1;
                                stat_result[3]=stat_result[3]+2;
                                stat_result[4]=stat_result[4]+2;
                                stat_result[5]=stat_result[5]-1;
                                
                                System.out.println("Your stat is HP of "+stat_result[0]);
                                System.out.println("MP of "+stat_result[1]);
                                System.out.println("Dexterity of "+stat_result[2]);
                                System.out.println("Agility of "+stat_result[3]);
                                System.out.println("Strength of "+stat_result[4]);
                                System.out.println("Intelligence of "+stat_result[5]);
                                break;
                                

        
                        }
                        else{
                                System.out.print("Error, Please type again.");
                        }
                }

        }
        else {
                System.out.println("There has been Error while choosing the job. Please restart the game.");

		}
	}
}
