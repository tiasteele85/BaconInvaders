package baconInvaders;
import java.util.*;
import java.util.Scanner;

public class BaconInvaders {

    public static void main(String args[]) {

        Player player1 = new Player("Player 1", "Human", 100);
        //Enemy invader = new Enemy(); 
        //Enemy invaders[]; //old holder for enemy count
        ArrayList<Enemy> invaders = new ArrayList<Enemy>();
        Scanner in = new Scanner(System.in);
        String choice = "PANTRY";

        System.out.println("Welcome to Bacon Invaders");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        while (!choice.toUpperCase().equals("GAMEOVER") || !choice.toUpperCase().equals("EXIT")){
            if (choice.toUpperCase().equals("PANTRY")) {
                choice = PantryRoom(in);
            }
            if (choice.toUpperCase().equals("KITCHEN")) {
            	
            	int maxEnemies = 4;
            	invaders = generateEnemies(maxEnemies);
                choice = KitchenRoom(in, player1, invaders);
            }
        }
        in.close();
    }
    
    	//Method to populate enemy arrayList 
    	//needs to be reusable    	   	
	    private static ArrayList<Enemy> generateEnemies(int max) {
	    	Random rand = new Random();
	    	int count = rand.nextInt(max) + 2;//initialize random enemy generation
	    	
	    	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	    	for(int i = 0; i < count; i++)
	    	{
	    		enemies.add(new Enemy());
	    	}
	    	return enemies;
	    	
	    }

        /*
        * Method to Handle individual rooms within the game
        * Allows game to flow properly
        *
         */
        public static String PantryRoom(Scanner userInput)
        {
            Pantry pantry = new Pantry();
            String choice;
            //timesHere = 0; //possible re-entry variable


                pantry.BeginningStory();
                choice = userInput.nextLine();
                if (choice.equals("1")) {
                    pantry.Stay();
                    gameOver();
                    return choice = "GAMEOVER";
                } else if (choice.equals("2")) {
                    pantry.NextRoom();
                    return choice = "Kitchen";
                } else if (choice.equals("3")) {
                    return choice = "EXIT";
                } else {
                    System.out.println("You don't follow the rules. So we will just exit.");
                    return choice = "Exit";
                }



        }

        /*
        *Method to handle Kitchen room in game play
        *
         */
        public static String KitchenRoom(Scanner userInput, Player player, ArrayList<Enemy> invaders)
        {
            Kitchen kitchen = new Kitchen();
            String choice;

            kitchen.Enter();
            choice = userInput.nextLine();
            if(choice.equals("1"))
            {
                //kitchen.NextRoom();
                handleFightScene(player, invaders);
                if(player.getHealthBar() <= 0)
                {
                    return choice = "Gameover";
                }
                winner();
                return choice = "DiningRoom";
            }
            else if(choice.equals("2"))
            {
                kitchen.Run();
                gameOver();
                return choice = "Gameover";
            }
            else
            {
                return choice = "EXIT";
            }
        }
        
        
        //Handle fight scene for enemy array //this is dumb needs better handling
        public static void handleFightScene(Player one, ArrayList<Enemy> them) 
        
        {
        	for(int i = 0; i < them.size(); i++)
        	{
        		
        		fightScenes(one, them.get(i));
        		if(one.getHealthBar()==0)
        		{
        			//i = (them.size()-1);
        			break;
        		}
        	}
        	//better handling
        	//int enemiesInRoom = them.size();
        	
        	
        	
        }

        //Handle fight scene scripting
        public static void fightScenes(Player one, Enemy two)
        {
            Random rand = new Random();
            int maxDamageRecieved = 25;
            int damageRecieved = 0;
            int userInput = 0;
            Scanner in = new Scanner(System.in);

            System.out.println("You are ready to Fight");

            //Handle Fight Mechanics
            while(one.getHealthBar() > 0 && two.getHealthBar() > 0 && userInput !=2)
            {
                System.out.println("*********************************************************");
                System.out.println("Your Health: " + one.getHealthBar());
                System.out.println(two.getName() + "'s Health: " + two.getHealthBar());
                System.out.println("*********************************************************");

                damageRecieved = rand.nextInt(maxDamageRecieved);
                System.out.println("You throw a punch: \n\t#Damage given: " + damageRecieved + " #");
                two.updateHealth(damageRecieved);
                if(two.getHealthBar() > 0){
                	damageRecieved = rand.nextInt(maxDamageRecieved);
                	System.out.println(two.getName() + " threw a punch: \n\t#Damage received: " + damageRecieved +" #");
                	one.updateHealth(damageRecieved);
                	System.out.println("*********************************************************");
                    System.out.println("What do you do: \n 1: Continue Fighting\n 2: Run");
                    userInput = in.nextInt();
                }                              
            }
            //Handle Run Choice
            if(userInput == 2)
            {
                System.out.println("No man, you got beat up by a Hamburger");
                one.setTheHealth(0);
            }
            
            //check if player died
            if(one.getHealthBar() <= 0)
            {
                gameOver();

            }            
            if(two.getHealthBar()<=0)
            {
            	System.out.println("\nHAHA, HOHO, You beat it.");
            	System.out.println("Now time to canabalize this giant meat patty.\n" +
            						"You open your mouth as wide as you can and bite deep,\n" +
            						"receiving a delicious perfect burger bite.");
            	int regain = rand.nextInt(25)+1;            	
            	System.out.println("You receive " + regain + " health points!\n");
            	one.setTheHealth((one.getHealthBar() + regain));
            }

        }
        
        //Default Win Message
        public static void winner()
        {
            System.out.println("\t$# Congratulations, You Won!! #$");
        }

        //End Game Script, default message for all methods and classes
        public static void gameOver(){

            System.out.println("\t# I'm sorry, You Lose. #");
        }

}
