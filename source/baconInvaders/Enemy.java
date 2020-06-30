package baconInvaders;


import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Player {

    int maxEnemyHealth = 75;
    // int maxNumRooms = 8; //available number of rooms for final
    Random rand = new Random();
    LocationSpawn where = new LocationSpawn();


    Enemy()
    {
        super("Chula", "Hamburger", 0);
        setTheHealth(rand.nextInt(maxEnemyHealth));
        where.setRoom(1);
    }

    //First iteration auto set location to Kitchen
    public void setLocation(int x)
    {
        where.setRoom(x);
    }

    //return spawned location to test for fight scene method
    public String getSpawn()
    {
        return  where.getRoom();
    }

 
}
