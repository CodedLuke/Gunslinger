import java.util.Arrays;


public class Slinger {
	private int health = 2;
	private Gun revolver = new Gun(4);
	private String name;
	
	public Slinger(String name){
		this.name = name;
	}
	
	///////////// PUBLIC METHODS
	
	// adds bullets to cylinder
	public void loadGun(){
		System.out.println(name + " loads gun");
		revolver.reload();
		revolver.shuffle();
	}
	
	// returns true if health is above 0
	public boolean isAlive(){
		boolean alive;
		if (health > 0){
			alive = true;
		}
		else{
			alive = false;
		}
		return alive;
	}
	
	// player targets opponent
	// if there is a bullet fired the opponent loses health and a checker is called to see whether opponent is dead
	public boolean drawGun(Slinger enemy){
		System.out.println(name + " prepares to take a shot");
		boolean success = revolver.fire();
		if (success){
			enemy.takeDamage();
			boolean critical = enemy.isAlive();
			if (!critical){
				System.out.println(enemy.getName() + " falls to his knees");
			}
			else{
				System.out.println(enemy.getName() + " staggers but doesn't give in");
			}
		}
		else{
			System.out.println(name + " fires a blank!");
		}
		return success;
	}
	
	////////////// GETTERS
	
	// returns name
	public String getName(){
		return name;
	}
	
	// returns health
	public int getHealth(){
		return health;
	}
	
	////////////// PRIVATE METHODS
	
	// returns true if damage inflicted is smaller than health 
	// ie returns true if player is still alive
	private void takeDamage(){
		health--;
	}

}
