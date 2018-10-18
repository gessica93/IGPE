package view;

import java.util.Observable;
import java.util.Observer;

import model.GestoreGioco;

public abstract class Grafica extends Observable implements Observer, PanelSwitcher{

	protected GestoreGioco gestore;
	
	public Grafica() {}
	
	public abstract void update(Observable arg0, Object arg1);

	public GestoreGioco getGestore() {
		return gestore;
	}

	public void setGestore(GestoreGioco gestore) {
		this.gestore = gestore;
	}
}