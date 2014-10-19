
public class Gun {
	public boolean[] cylinder = {false, false, false, false, false, false};
	public int bullets = 6;
	private int position =0;
	
	//////// CONSTRUCTORS
	
	public Gun(){
		
	}
	
	public Gun(int ammo){
		bullets = ammo;
	}
	
	///////// USABLE METHODS
	
	// reloads gun as while there are bullets left
	public void reload(){
		int count = 0;
		if(!checkCylinder()){
			for (int i =0; i <= 5; i ++ ){
				if (bullets > 0){
					cylinder[i]= true;
					count ++;
					bullets --;
				}
			}
			System.out.println(count + " bullets added");
		}
		else{
			System.out.println("Revolver still has bullets");
		}
	}
	
	// fire the revolver
	// moves cylinder along one place
	// returns true if there is a bullet
	public boolean fire(){
		boolean fireGun;
		if (cylinder[position]){
			 fireGun = true;
		}
		else{
			 fireGun = false;
		}
		nextPosition();
		return fireGun;
	}
	
	// spins barrel
	public void shuffle(){
		int newPosition = (int) (Math.random()*10);
		for (int i = 0; i < newPosition; i++){
			nextPosition();
		}
	} 
	
		
	////////// GETTERS/SETTERS
	
	// prints whether each position is empty or taken
	public void countCylinder() {
		for (int i = 0; i <= 5; i++){
			System.out.println(cylinder[i]);
		}
	}

	// returns current position of cylinder
	public int getPosition() {
		return position;
	}

		
	////////// PRIVATE METHODS


	// checks to see if cylinder is empty
	// if there are NO bullets returns false
	private boolean checkCylinder(){
		int count = 0;
		for (boolean bullet:cylinder){
			if (bullet == true){
				count ++;
			}
		}
		if (count > 0){
			System.out.println(count + " bullets remaining");
			return true;
		}
		else{
			return false;
		}
	}
	
	// moves barrel onwards
	private void nextPosition(){
		if (position == 5){
			position = 0;
		}
		else{
			position++;
		}
	}
	
}
