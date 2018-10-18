package model;

public class Nave {

	private int lunghezza;
	private int danno;
	private String nome;
	
	public Nave(String n){
		this.nome=n;
		
		if(nome.equals("portaerei")){
			this.lunghezza=5;
		}
		else if(nome.equals("corazzata")){
			this.lunghezza=4;
		}
		else if(nome.equals("incrociatore")){
			this.lunghezza=3;
		}
		else if(nome.equals("sottomarino")){
			this.lunghezza=3;
		}
		else if(nome.equals("cacciatorpediniere")){
			this.lunghezza=2;
		}
		else if(nome.equals("assalto")){
			this.lunghezza=1;
		}
		
		this.danno=0;
	}
	
	public int getLunghezza() {
		return lunghezza;
	}
	public void setLunghezza(int lunghezza) {
		this.lunghezza = lunghezza;
	}
	public int getDanno() {
		return danno;
	}
	public void setDanno(int danno) {
		this.danno = danno;
	}
	
	public void addDanno(){
		danno++;
	}
	
	public boolean affondato(){
		return danno==lunghezza;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
