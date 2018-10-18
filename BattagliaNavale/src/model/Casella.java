package model;

public class Casella {
	private int riga;
	private int colonna;
	private boolean colpita;
	private Nave nave;
	
	public Casella(int r,int c){
		riga=r;
		colonna=c;
		colpita=false;
		setNave(null);
	}
	
	public int getRiga() {
		return riga;
	}
	public void setRiga(int riga) {
		this.riga = riga;
	}
	public int getColonna() {
		return colonna;
	}
	public void setColonna(int colonna) {
		this.colonna = colonna;
	}
	public boolean isColpita() {
		return colpita;
	}
	public void setColpita(boolean colpita) {
		this.colpita = colpita;
	}

	public Nave getNave() {
		return nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}
	
	
	
}
