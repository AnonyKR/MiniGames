import pkg.LetterToWord.*;

class starter {
        public static void main(String args[]) {
                listWord testAll = new listWord(5, 4);
                String[] anList = {"a", "a", "an", "an"};
                String[] bnList = {"l", "la", "r", "ra"};
                String[] cnList = {"s", "se", "n", "ne"};
                String[] dnList = {"f", "fr", "p", "pr"};
                String[] enList = {"d", "d", "do", "do"};
                testAll.fillLetter(anList, 0);
                testAll.fillLetter(bnList, 1);
                testAll.fillLetter(cnList, 2);
                testAll.fillLetter(dnList, 3);
                testAll.fillLetter(enList, 4);
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                testAll.checkAll();
                System.out.println();
                testAll.printSave();
        }

	// public static void main(String args[]) {
        
        // //System.out.println(Trpg.rollDice(first, second));
        
        // //setting up character
        // Scanner sc=new Scanner(System.in);
        // //stats
        // int HP=0;
        // int MP=0;
        // int dexterity=0;
        // int agility=0;
        // int strength=0;
        // int intelligence=0;
        // //rolls
	// 	String[] jobs = {"archer", "warrior", "knight"}; //The roles reference is too frequent => make it to array
	// 	/* 
        // String a=new String("archer");
        // String b=new String("Archer");
        // String c=new String("Warrior");
        // String d=new String("warrior");
        // String e=new String("Knight");
        // String f=new String("knight");
	// 	*/
        // System.out.println("We are going to start by choosing job");
        // System.out.println("What job do you want?");
	// 	String job = "placeholder";
	// 	boolean validJob = false;
        // while(!validJob /*true*/){ //The loop conditions is changed in order to leave more easily
	// 		if (!job.equals("placeholder")) {
	// 			System.out.println("Choose your job again"); //This condition ensure that "again" sector only runs after first iteration
	// 		}
	// 		System.out.print("Choose from archer, warrior, or a knight: ");
        // 	job = sc.nextLine(); //These lines need to be inside the loop if you want to ask again
	// 		/*
        //         if(a.equals(job)||b.equals(job)){
        //                 job="archer";
        //                 System.out.println("You chose a archer");
        //                 break;
        //         }
        //         else if(c.equals(job)||d.equals(job)){
        //                 job="warrior";
        //                 System.out.println("You chose a warrior");
        //                 break;
        //         }
        //         else if(e.equals(job)||f.equals(job)){
        //                 job="knight";
        //                 System.out.println("You chose a knight");
        //                 break;
        
        //         }
        //         else{
        //                 System.out.println("Choose your job again");
        //         }
	// 		*/ //These lines only check if it matches with the given role, if that is a case, it can be changed into this form (since jobs are now in array)
	// 		for (int i = 0; i < jobs.length; i++) {
	// 			if (jobs[i].equals(job.toLowerCase())) {
	// 				validJob = true;
	// 				job = jobs[i];
	// 				System.out.println("You chose a " + jobs[i]);
	// 				break;
	// 			}
	// 		}
        // }
        
        // System.out.println("Now it's time to get your stat");
        // System.out.println("You can start with each stat of 14 points at most");
        // System.out.println("Roll the dice say 'roll' ");
        // String roll_cmd=sc.nextLine();
        // int roll_num=0;
        // if(job.equals(jobs[0])){ //Use equals method not random name that's not even a string... (also array can be referenced)
        //         dexterity=2;
        //         if(roll_cmd.equals("roll")){
        //                 dexterity= Trpg.rollDice();
        //                 System.out.println();

        //         }

        // }
        // else if(job.equals(jobs[1])){

        // }
        // else {

	// 	}
	// }
}
