package baconInvaders;

public class Health{

	int health;

	Health(){
		health = 100;
	}

	//Set health Not valid for health potions or restores
	public void setHealth(int heal)
	{
		health = heal;	
	}

	//Return current health variable
	public int getHealth()
	{
		return health;
	}

	//Update function for fighting method in Main
	public int recieveDamage(int damage)
	{
		return health -= damage;
	}
}
