package baconInvaders;

public class Kitchen{

	boolean inside;

	Kitchen(){
		inside = false;	
	}

	//Script for entering room
	public void Enter(){
		this.inside = true;
		//System.out.println("Inside the Kitchen");
		System.out.println("*********************************************************");
		System.out.println("You slowly open the pantry door. You see a large human " +
							"\nsized hamburger rumbling in the fridge. ");
		//System.out.println("However on the table you see some sort of gun type item."); //Future version with weapon
		System.out.println("*********************************************************");
		System.out.println("What do you do: \n 1: Beat this bun with fists of steel \n 2: Run");
	}

	//Script to move to next room
	public void NextRoom(){
		inside = false;
		System.out.println("You have left the Kitchen");
	}
	public void Run()
	{
		System.out.println("*********************************************************");
		System.out.println("\n\t# Really you ran \n");
		System.out.println(" This creature realizes your figure as you try to run. " +
							"\n Before you can save your own skin, the monster " +
							"\n a fury of hard patty scented blows on your body. ");
		System.out.println("As your life slips away you realize, you " +
				"\nmade the wrong choice. ");

	}
}
