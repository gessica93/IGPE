package controller;

import java.util.Observable;
import java.util.Observer;

import view.Grafica;

import model.GestoreGioco;
import model.Nave;

public class Controller implements Observer{
	
	private GestoreGioco gestore;
	private Grafica grafica;

	public Controller(Grafica grafica, GestoreGioco gestore) {
		this.setGestore(gestore);
		this.grafica = grafica;
		this.grafica.addObserver(this);
	}
	
	public void inserisciNave(String giocatore,Nave n,int direzione, int r, int c){
		this.getGestore().addNave(giocatore, n, direzione, r, c);
	}
	
	public boolean controllaInserimento(String giocatore,Nave n,int direzione, int r, int c){
		return this.getGestore().controllaInserimento(giocatore, n, direzione, r, c);
	}
	
	public void rimuoviNave(String nomeGiocatore, String n){
		this.getGestore().rimuoviNave(nomeGiocatore, n);
	}
	
	public String prossimoGiocatore(int r,int c){
		return this.getGestore().prossimoGiocatore(r, c);
	}
	
	public void pannelloImpostazioneSinglePlayer(){
		grafica.pannelloImpostazioneSinglePlayer();
	}
	
	public void pannelloIniziale(){
		grafica.pannelloIniziale();
	}
	
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	public void pannelloImpostazioneGriglia() {
		grafica.pannelloImpostazioneGriglia();
	}

	public GestoreGioco getGestore() {
		return gestore;
	}

	public void setGestore(GestoreGioco gestore) {
		this.gestore = gestore;
	}

	public void reset(String nome) {
		this.gestore.reset(nome);
	}
	


}
