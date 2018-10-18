package view;

public class CasellaGui {

	private int partenzaX;
	private int partenzaY;
	private int arrivoX;
	private int arrivoY;
	private int coordinataX;
	private int coordinataY;
	
	public CasellaGui(int partenzaX,int partenzaY,int coordinataX,int coordinataY) {
		
		this.partenzaX=partenzaX;
		this.partenzaY=partenzaY;
		this.coordinataX=coordinataX;
		this.coordinataY=coordinataY;
		this.arrivoX=partenzaX+70;
		this.arrivoY=partenzaY+70;
	}
	
	@Override
	public String toString() {
		String s="La cella ("+coordinataX+","+coordinataY+")"+"/n"+"Parte da ("+ partenzaX + ","+partenzaY+")"+"/n"+"Fino a ("+arrivoX+","+arrivoY+")";
		return s;
		
		
	}
	
	public int getPartenzaX() {
		return partenzaX;
	}
	public void setPartenzaX(int partenzaX) {
		this.partenzaX = partenzaX;
	}
	public int getPartenzaY() {
		return partenzaY;
	}
	public void setPartenzaY(int partenzaY) {
		this.partenzaY = partenzaY;
	}
	public int getArrivoX() {
		return arrivoX;
	}
	public void setArrivoX(int arrivoX) {
		this.arrivoX = arrivoX;
	}
	public int getArrivoY() {
		return arrivoY;
	}
	public void setArrivoY(int arrivoY) {
		this.arrivoY = arrivoY;
	}
	public int getCoordinataX() {
		return coordinataX;
	}
	public void setCoordinataX(int coordinataX) {
		this.coordinataX = coordinataX;
	}
	public int getCoordinataY() {
		return coordinataY;
	}
	public void setCoordinataY(int coordinataY) {
		this.coordinataY = coordinataY;
	}
}
