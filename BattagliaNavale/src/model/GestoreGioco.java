package model;

import java.util.Observable;


public class GestoreGioco extends Observable implements Runnable{

	private Griglia giocatore1;
	private Griglia giocatore2;
	private Griglia giocatoreCorrente;
	private String vincitore;
	private int dimensione;
	
	public GestoreGioco(int d,String nome1,String nome2){
		setDimensione(d);
		setGiocatore1(new Griglia(d,nome1));
		setGiocatore2(new Griglia(d,nome2));
		giocatoreCorrente=giocatore1;
		setVincitore(null);
		Thread t=new Thread(this);
		t.start();
		
	}
	
	public void addNave(String n,Nave nave,int direzione,int r,int c){
		
		if(giocatore1.getNome().equals(n)){
			giocatore1.addNave(nave, direzione, r, c);
			setChanged();
			notifyObservers(new Stato(1));
		}
		else if(giocatore2.getNome().equals(n)){
			giocatore2.addNave(nave, direzione, r, c);
			setChanged();
			notifyObservers(new Stato(1));
		}
	}
	
	public boolean controllaInserimento(String n,Nave nave,int direzione,int r,int c){
		
		boolean risultato=false;
		if(giocatore1.getNome().equals(n)){
			risultato=giocatore1.controllaInserimento(nave, direzione, r, c);
			setChanged();
			notifyObservers(new Stato(0,risultato,r,c));
		}
		else if(giocatore2.getNome().equals(n)){
			risultato=giocatore2.controllaInserimento(nave, direzione, r, c);
			setChanged();
			notifyObservers(new Stato(0,risultato,r,c));
		}
		return risultato;
		
	}
	
	public void rimuoviNave(String nome,String nave){
		
		if(giocatore1.getNome().equals(nome)){
			giocatore1.rimuoviNave(nave);
			setChanged();
			notifyObservers(new Stato(2));
		}
		else if(giocatore2.getNome().equals(nome)){
			giocatore2.rimuoviNave(nave);
			setChanged();
			notifyObservers(new Stato(2));
		}
	}
	
	private boolean colpisci(String n,int r,int c){
		//ritorna true quando ha trovato la nave
		if(giocatore1.getNome().equals(n)){
			return giocatore2.colpisci(r, c);
		}
		else if(giocatore2.getNome().equals(n)){
			return giocatore1.colpisci(r, c);
		}
		return false;
	}
	
	public String prossimoGiocatore(int r,int c){
		
		if(colpisci(giocatoreCorrente.getNome(), r, c))
			return giocatoreCorrente.getNome();
		else{
			if(giocatoreCorrente.getNome().equals(giocatore1.getNome())){
				giocatoreCorrente=giocatore2;
			}
			else
				giocatoreCorrente=giocatore1;
		}
			return giocatoreCorrente.getNome();		
	}
	
	public boolean finitaPartita(){
		
		if(giocatore1.sconfitto()){
			vincitore=giocatore2.getNome();
			setChanged();
			notifyObservers(1);
			return true;
		}
		else if(giocatore2.sconfitto()){
			vincitore=giocatore1.getNome();
			setChanged();
			notifyObservers(1);
			return true;
		}
		
		return false;
	}
	
	private void partita(){
		
//		while(!finitaPartita()){
//			setChanged();
//			notifyObservers();
//		}
//		System.out.println("RUN!!!");
		
	}

	public Griglia getGiocatore1() {
		return giocatore1;
	}

	public void setGiocatore1(Griglia giocatore1) {
		this.giocatore1 = giocatore1;
	}

	public Griglia getGiocatore2() {
		return giocatore2;
	}

	public void setGiocatore2(Griglia giocatore2) {
		this.giocatore2 = giocatore2;
	}

	public Griglia getGiocatoreCorrente() {
		return giocatoreCorrente;
	}

	public void setGiocatoreCorrente(Griglia giocatoreCorrente) {
		this.giocatoreCorrente = giocatoreCorrente;
	}

	public void run() {
		
		partita();
		
	}
	
	public Casella getCasella(String nome,int i,int j){
		if(giocatore1.getNome().equals(nome)){
			return giocatore1.getCasella(i, j);
		}
		else if(giocatore2.getNome().equals(nome)){
			return giocatore2.getCasella(i, j);
		}
		return null;
	}

	public String getVincitore() {
		return vincitore;
	}

	public void setVincitore(String vincitore) {
		this.vincitore = vincitore;
	}

	public int getDimensione() {
		return dimensione;
	}

	public void setDimensione(int dimensione) {
		this.dimensione = dimensione;
	}

	public void reset(String nome) {
		
		if(giocatore1.getNome().equals(nome)){
			giocatore1.reset();
			setChanged();
			notifyObservers(new Stato(3));
		}
		else{
			giocatore2.reset();
			setChanged();
			notifyObservers(new Stato(3));
		}
		
	}	
}