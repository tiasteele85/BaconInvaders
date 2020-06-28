package baconInvaders;

public class Pantry{

	boolean inside;

	Pantry(){
		inside = false;
	}

	public void Stay(){
		inside = true;
		System.out.println("*********************************************************");
		System.out.println("You cower in the pantry. Then you hear something " +
							"\ngetting close to the pantry. Next you hear " +
							"\n\n\t# CHULA IS THE BEEEEEEF # \n" +
							"\nthe pantry door swings open. A human sized " +
							"\nhamburger points a gun at you and fires.");
		System.out.println("As your life slips away you realize, you " +
							"\nmade the wrong choice. ");
	}

	public void NextRoom(){
		inside = false;
		System.out.println("Leaving the Pantry");
	}

	//The initial story for the game, should only be called once
	public void BeginningStory()
	{

		System.out.println("You have awakened inside your kitchen pantry." +
							"\nYou have a package of bacon clinging to your bosom." +
							"\nSuddenly you remember a news report about hamburger" +
							"\nshaped invaders stealing bacon all over the planet." +
							"\nAs you sit there you hear noises in the kitchen.");
		System.out.println("*********************************************************");
		System.out.println("What do you do: \n 1: Stay in the Pantry \n 2: Exit to Kitchen \n 3: Exit");
	}



}

