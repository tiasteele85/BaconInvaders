package baconInvaders;

//import Health.java;

public class Player{

	private String name;
	private String species;
	private Health bar = new Health();
	
	//default constructor	
	Player()
	{
		name = "player 1";
		species = " ";
		bar.setHealth(100);
	}

	//Parameterized Constuctor
	Player(String name, String species, int health)
	{
		this.name = name;
		this.species = species;
		bar.setHealth(health);
	}

	//Method to set the Character Name variable
	void setName(String name)
	{
		this.name = name;		
	}
	
	//Method to set the Character's species
	void setSpecies(String species)
	{
		this.species = species;
	}
	
	/*Method to set the Character's health bar
	* Calls Health Class
	*/	
	void setTheHealth(int health)
	{
		bar.setHealth(health);
	}

	void updateHealth(int dam)
	{
		bar.recieveDamage(dam);
	}
	
	//Method to return the value of the Character's name
	String getName()
	{
		return name;
	}

	//Method to return the value of the Character's species
	String getSpecies()
	{
		return species;
	}

	/*Method to return the value of the Characters's Health Bar
	* Calls Health class
	*/
	int getHealthBar()
	{
		return bar.getHealth();
	}



}
