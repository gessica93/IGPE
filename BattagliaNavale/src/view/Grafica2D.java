package view;

import java.util.Observable;

import javax.swing.JComponent;
import javax.swing.JFrame;

import model.GestoreGioco;
import model.Griglia;
import model.Stato;

import controller.Controller;

public class Grafica2D extends Grafica{

	private JFrame frame;
	private PannelloIniziale pannelloIniziale;
	private PannelloImpostazioneSinglePlayer pannelloImpostazioneSinglePlayer;
	private PannelloImpostazioneGriglia pannelloImpostazioneGriglia;
	
	public Grafica2D() {
		
		
		gestore=new GestoreGioco(0, "", "");
		Controller controller = new Controller(this, gestore);
		this.gestore.addObserver(this);
		
		frame=new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setTitle("Battaglia Navale");
		pannelloIniziale=new PannelloIniziale(this, controller);
		pannelloImpostazioneSinglePlayer = new PannelloImpostazioneSinglePlayer(this, controller);
		pannelloImpostazioneGriglia= new PannelloImpostazioneGriglia(this, controller,gestore);
		frame.setContentPane(pannelloIniziale);
		frame.setUndecorated(true);
		frame.pack();
		frame.setVisible(true);
	}
	
	@Override
	public void pannelloImpostazioneSinglePlayer() {
		switchTo(pannelloImpostazioneSinglePlayer);
	}
	
	
	private void switchTo(final JComponent component) {
		frame.setContentPane(component);
		frame.pack();
	}


	
	@Override
	public void update(Observable arg0, Object arg1) {
		Stato stato = (Stato)arg1;
		
		int azione = stato.getAzione();
		
		switch(azione){
		case 0:{
			pannelloImpostazioneGriglia.setSpuntaVerdeRosso(stato.isPuoiInserire());
			break;
		}
		case 1:{
			pannelloImpostazioneGriglia.inserisciNave();
			break;
		}
		
		case 2:{
			pannelloImpostazioneGriglia.rimuovi();
			break;
		}
		
		case 3:{
			pannelloImpostazioneGriglia.reset();
			break;
		}
		}
		
	}

	@Override
	public void pannelloIniziale() {
		switchTo(pannelloIniziale);
		
	}

	@Override
	public void pannelloImpostazioneGriglia() {
		
		gestore.setGiocatore1(new Griglia(getGestore().getDimensione(), pannelloImpostazioneSinglePlayer.getNome()));
		System.err.println("METODO PANNELLO IMPOSTAZIONE GRIGLIA IL GET NOME E' "+ pannelloImpostazioneSinglePlayer.getNome());
		gestore.setGiocatore2(new Griglia(getGestore().getDimensione(), "PC"));
		gestore.setGiocatoreCorrente(gestore.getGiocatore1());
		switchTo(pannelloImpostazioneGriglia);
		
	}

	public void resetColor(int i, int j) {
//		this.pannelloImpostazioneGriglia.getGriglia()[i][j].setBackground(new Color(22,50,121,0));
	}
	

}
