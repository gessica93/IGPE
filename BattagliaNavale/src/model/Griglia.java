package model;

public class Griglia {

	private int naviAffondate;
	private String nome;
	private int dimensione;
	public static final int NORD=0;
	public static final int SUD=1;
	public static final int OVEST=2;
	public static final int EST=3;
	private Casella caselle[][];
	
	//aggiunto da me
	private int naviAggiunte;
	
	
	public Griglia(int d,String nome){
		setDimensione(d);
		naviAggiunte=0;
		naviAffondate=0;
		setCaselle(new Casella[d][d]);
		for(int i=0;i<d;i++){
			for(int j=0;j<d;j++){
				getCaselle()[i][j]=new Casella(i,j);
			}
		}
		
		this.nome=nome;
	}
	
	public int getNaviAggiunte() {
		return naviAggiunte;
	}

	public void setNaviAggiunte(int naviAggiunte) {
		this.naviAggiunte = naviAggiunte;
	}

	public int getNaviAffondate() {
		return naviAffondate;
	}
	
	public void setNaviAffondate(int naviAffondate) {
		this.naviAffondate = naviAffondate;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDimensione() {
		return dimensione;
	}

	public void setDimensione(int dimensione) {
		this.dimensione = dimensione;
	}
	
	public boolean sconfitto(){
		return naviAffondate==naviAggiunte;
	}
	
	public void addNave(Nave n,int direzione,int r,int c){
		
		if(controllaInserimento(n, direzione, r, c)){
			
			switch(direzione){
			
			case EST:{
				for(int i=c;i<(c+n.getLunghezza());i++){
					getCaselle()[r][i].setNave(n);
				}
				naviAggiunte++;
				break;
			}
			
			case OVEST:{
				for(int i=(c-n.getLunghezza())+1;i<=c;i++){
					getCaselle()[r][i].setNave(n);
				}
				naviAggiunte++;
				break;
			}
			
			case SUD:{
				for(int i=r;i<(r+n.getLunghezza());i++){
					getCaselle()[i][c].setNave(n);
				}
				naviAggiunte++;
				break;
			}
			
			case NORD:{
				for(int i=(r-n.getLunghezza())+1;i<=r;i++){
					getCaselle()[i][c].setNave(n);
				}
				naviAggiunte++;
				break;
			}
			}
		}
		
	}
	
	public boolean controllaInserimento(Nave n,int direzione,int r,int c){
		boolean libera=true;
		if(n != null)
			switch(direzione){
				case EST:{//caso destra
					if((c+n.getLunghezza())<=dimensione){
						for(int i=c;i<(c+n.getLunghezza());i++){
							if(getCaselle()[r][i].getNave()!=null){
								libera=false;
							}
						}
					}
					else return false;
					break;
				}
				
				case OVEST:{//sinistra
					if(((c+1)-n.getLunghezza())>=0){
						for(int i=(c-n.getLunghezza())+1;i<=c;i++){
							if(getCaselle()[r][i].getNave()!=null){
								libera=false;
							}
						}
					}
					else return false;
					break;
				}
				
				case NORD:{//sopra
					if(((r+1)-n.getLunghezza())>=0){
						for(int i=(r-n.getLunghezza())+1;i<=r;i++){
							if(getCaselle()[i][c].getNave()!=null){
								libera=false;
							}
						}
					}
					else
						return false;
					break;
				}
				
				case SUD:{//sotto
					if((r+n.getLunghezza())<=dimensione){
						for(int i=r;i<(r+n.getLunghezza());i++){
							if(getCaselle()[i][c].getNave()!=null){
								libera=false;
							}
						}
					}
					else return false;
					break;
				}
	
			}
		return libera;
	}
	
	public void rimuoviNave(String n){
		if(n!=null){
			for(int i=0;i<dimensione;i++){
				for(int j=0;j<dimensione;j++){
					if((getCaselle()[i][j].getNave()!=null)){
						if(getCaselle()[i][j].getNave().getNome().equals(n)){
							getCaselle()[i][j].setNave(null);
							System.out.println("TROVATO IN "+ i+ " " + j);
						}
					}
				}
			}
			naviAggiunte--;
		}
	}
	
	public boolean colpisci(int r,int c){
		boolean trovata=false;
		Casella casella = getCaselle()[r][c];
		casella.setColpita(true);
		if(casella.getNave()!=null){
			trovata=true;
			Nave n=casella.getNave();
			n.addDanno();
			if(n.affondato()){
				naviAffondate++;
			}
		}
		return trovata;
		
	}

	public Casella[][] getCaselle() {
		return caselle;
	}

	public void setCaselle(Casella caselle[][]) {
		this.caselle = caselle;
	}
	
	public Casella getCasella(int i,int j) {
		return this.caselle[i][j];
	}
	
	public void reset(){
		naviAffondate=0;
		naviAggiunte=0;
		for(int i=0;i<dimensione;i++){
			for(int j=0;j<dimensione;j++){
				if(caselle[i][j].getNave()!= null)
					caselle[i][j].setNave(null);				
			}
		}
	}	
}

