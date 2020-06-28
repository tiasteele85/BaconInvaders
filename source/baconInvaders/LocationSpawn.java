package baconInvaders;

public class LocationSpawn {

    String[] room = {"Pantry", "Kitchen"};
    String iAmHere;

    //Default Spawn location for first iteration
    //Kitchen is the first available location for Enemies
    LocationSpawn()
    {
        iAmHere = room[1];

    }

    //update settings for invader spawning
    //Can allow spawning to occur randomly in enemy class
    public void setRoom(int x)
    {
        iAmHere = room[x];

    }

    //Text version for room to test fighting method in Main
    public String getRoom()
    {
        return iAmHere;
    }


}
