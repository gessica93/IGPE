package model;

public class Stato {
	
	private int azione;
	
	private boolean puoiInserire;
	private int riga;
	private int colonna;
	
	public Stato(int azione, boolean puoiInserire, int riga, int colonna) {
		this.setAzione(azione);
		this.setPuoiInserire(puoiInserire);
		this.setRiga(riga);
		this.setColonna(colonna);
	}
	
	public Stato(int azione) {
		this.setAzione(azione);
	}

	public int getAzione() {
		return azione;
	}

	public void setAzione(int azione) {
		this.azione = azione;
	}

	public boolean isPuoiInserire() {
		return puoiInserire;
	}

	public void setPuoiInserire(boolean puoiInserire) {
		this.puoiInserire = puoiInserire;
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

}
