import java.util.HashSet;

public class GameState{
	private int[][] bank;
	private HashSet<Star> stars;
	private int numPlayers;
	private int turn;
	public GameState(){
		numPlayers = 2;
		turn = 1; //random mod 2
		setBank();
	}
	public void addStar(Star starIn){
		stars.add(starIn);
	}
	public HashSet<Star> getStars(){
		return stars;
	}
	public int getTurn(){
		return turn;
	}
	public int nextTurn(){
		turn = (turn%numPlayers) +1;
		return turn;
	}
	public void setBank(){
		bank = new int[4][3];
		for(int i=0; i < 4; i++){
			for(int j = 0; j < 3; j++){
				bank[i][j] = 3;
			}
		}
	}
	public void addPiece(Color color, int size) {
		bank[color.getCode()][size-1] += 1;
	}
	public boolean removePiece(Color color, int size) {
		if(isThere(color, size)) {
			bank[color.getCode()][size-1] -= 1;
			return true;
		} else {
			return false;
		}
	}
	public int removeSmallest(Color color) {
		for(int x = 0; x < 3; x++) {
			if(bank[color.getCode()][x] != 0) {
				bank[color.getCode()][x] -= 1;
				return (x+1);
			}
		}
		return 0;
	}
	public boolean isThere(Color color, int size){
		if(bank[color.getCode()][size-1] > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public void trade(Star star, Ship ship, Color color, GameState state){
		Ship newShip = new Ship(color, ship.getSize(), ship.getPlayer());
		state.removePiece(color, ship.getSize());
		star.addShip(newShip);
		state.addPiece(ship.getColor(), ship.getSize());
		star.removeShip(ship);
	}
	public void build(Star star, Color color, GameState state){
		Ship newShip = new Ship(color, state.removeSmallest(color), state.getTurn());
		star.addShip(newShip);
	}
	public void attack(Ship ship){
		ship.setPlayer((ship.getPlayer()%numPlayers) + 1);
	}
	public void move(Star from, Star to, Ship ship){
		from.removeShip(ship);
		to.addShip(ship);
	}
}