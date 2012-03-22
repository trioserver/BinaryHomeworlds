public class Homeworld extends Star{
	Color colorPrime;
	int sizePrime;

	public Homeworld(String nameIn, Color colorIn, Color colorInPrime, 
			int sizeIn, int sizeInPrime){
		super(nameIn,colorIn,sizeIn);
		colorPrime = colorInPrime;
		sizePrime = sizeInPrime;
	}
	public int getSizePrime(){
		return sizePrime;
	}
	public Color getColorPrime(){
		return colorPrime;
	}
}