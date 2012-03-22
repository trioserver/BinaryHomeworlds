public class Ship{
	Color color;
	int size;
	int player;
	
	public Ship(Color colorIn, int sizeIn, int playerIn){
		color = colorIn;
		size = sizeIn;
		player = playerIn;
	}
	public Color getColor(){
		return color;
	}
	public int getSize(){
		return size;
	}
	public int getPlayer(){
		return player;
	}
}