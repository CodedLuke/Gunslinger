import java.util.Scanner;


public class StandOff {
	private Slinger player;;
	private Slinger opponent;
	private Scanner in= new Scanner(System.in);
	
	public StandOff(){
		player = new Slinger("player");
		opponent = new Slinger("opponent");
	}
	
	public StandOff(String player, String opponent) {
		this.player = new Slinger(player);
		this.opponent = new Slinger(opponent);		
	}
	
	
	public void battle(){
		player.loadGun();
		opponent.loadGun();
		boolean game = true;
		while (game){
			if (player.isAlive() && game){
				player.drawGun(opponent);
				System.out.println(opponent.getHealth());
			}
			else{
				game = false;
			}
			if (opponent.isAlive() && game){
				opponent.drawGun(player);
				System.out.println(player.getHealth());
			}
			else{
				game = false;
			}

		}
	}
	
	public void smarterBattle() {
		
	}
	
	
	
	
}
