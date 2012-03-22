import java.util.HashSet;

public class Star{
	Color color;
	int size;
	String name;
	HashSet<Ship> ships;
	HashSet<Ship> p1Ships;
	HashSet<Ship> p2Ships;
	
	
	public Star(String nameIn, Color colorIn, int sizeIn){
		name = nameIn;
		color = colorIn;
		size = sizeIn;
	}
	public void addShip(Ship ship){
		ships.add(ship);
		if(ship.player == 1){
			p1Ships.add(ship);
		}else{
			p2Ships.add(ship);
		}
	}
	public void removeShip(Ship ship){
		ships.remove(ship);
		if(ship.player == 1){
			p1Ships.remove(ship);
		}else{
			p2Ships.remove(ship);
		}
	}
	public Color getColor(){
		return color;
	}
	public String getName(){
		return name;
	}
	public int getSize(){
		return size;
	}
	public HashSet<Ship> getShips(){
		return ships;
	}
	public HashSet<Ship> getShips(int player){
		if(player == 1){
			return p1Ships;
		}else if(player == 2){
			return p2Ships;
		}else{
			return ships;
		}
	}
}