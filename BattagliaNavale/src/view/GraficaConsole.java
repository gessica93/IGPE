package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.Controller;

import model.Casella;
import model.GestoreGioco;
import model.Griglia;
import model.Nave;

public class GraficaConsole extends Grafica {

	public GraficaConsole() {
		super();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String giocatore1 = null;
		String giocatore2 = null;
		int dimensione = 0;
		String pulsanteDimensione = null;
		
		try{
			
			System.out.println("inserisci nome del primo giocatore\n");
			giocatore1=br.readLine();
			System.out.println("inserisci nome del secondo giocatore\n");
			giocatore2=br.readLine();
			System.out.println("inserisci la dimensione della griglia\n");
			do{
				System.out.println("premere il pulsante d se vuoi una griglia 10X10 o premere il pulsante v se vuoi una griglia 22X22");
				pulsanteDimensione = br.readLine();
			}while(!pulsanteDimensione.equals("d") && !pulsanteDimensione.equals("v"));
			
			if(pulsanteDimensione.equals("d")) dimensione = 10;
			else if(pulsanteDimensione.equals("v")) dimensione = 22;
			
		} catch( IOException e ){
			e.printStackTrace();
		}
		
		gestore = new GestoreGioco(dimensione, giocatore1, giocatore2);
		gestore.addObserver(this);
		mostraBattagliaNavale(0);
		acquisisciInputFase0();
		acquisisciInputFase1();
	}
	

	private void mostraBattagliaNavale(int faseDiGioco) {
		char riga='a';
		
		System.out.println("GIOCATORE: "+ gestore.getGiocatoreCorrente().getNome());
		
		for(int i=0;i<gestore.getGiocatore1().getDimensione();i++){
			if(i<11){
					System.out.print("  "+i);
			}
			else{
					
			System.out.print(" "+i);
			}
		}

		
		System.out.println();
		for(int i=0;i<gestore.getGiocatoreCorrente().getDimensione();i++){
			System.out.print(riga+"|");
			riga++;
			
			for(int j=0;j<gestore.getGiocatoreCorrente().getDimensione();j++){
				if(faseDiGioco==1){
					Griglia avversario=null;
					if(gestore.getGiocatoreCorrente().equals(gestore.getGiocatore1()))
						avversario=gestore.getGiocatore2();
					else
						avversario=gestore.getGiocatore1();	
				
					Casella c=gestore.getCasella(avversario.getNome(), i, j);
					if(!c.isColpita())
						System.out.print("__|"); //non colpita
					else{
						if(c.getNave()!= null && c.getNave().getDanno()<c.getNave().getLunghezza()){
							System.out.print(" X|"); //colpito pezzo di nave
						}
						else if(c.getNave()!= null && c.getNave().getDanno()==c.getNave().getLunghezza()){
							System.out.print(" $|");//nave affondata
						}
						else if(c.getNave() == null){
							System.out.print(" @|"); //colpo mancato
						}
					}
					
				}
				
				else if(faseDiGioco==0){
					
					Casella c=gestore.getCasella(gestore.getGiocatoreCorrente().getNome(), i, j);
					if(c.getNave()!=null){
						System.out.print(" O|");
					}
					else{
						System.out.print("__|");
					}
				}
			}
			System.out.println();
		}	
	}   


	private void acquisisciInputFase0() {
		
		String inputAzione=null;//ci dice se inserire,rimuovere o finire
		String inputAcquisito=null;//ci dice coordinate e direzione se inserisce o se rimuove
		Controller controller = new Controller(this, gestore);

		
		for(int i=0;i<2;i++){
			List<String>listaNavi=new ArrayList<>();
			listaNavi.add("portaerei");
			listaNavi.add("corazzata");
			listaNavi.add("incrociatore");
			listaNavi.add("sottomarino");
			listaNavi.add("cacciatorpediniere");
			listaNavi.add("assalto");
			
			do{
		
				System.out.println("Per inserire una nave premere il pulsante i\nPer rimuovere una nave premere r\nPer finire premi il pulsante f");
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				
				try {
					inputAzione=br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				switch(inputAzione){
				case "i":{
					System.out.println("Inserisci la coordinata della casella\n e la direzione in cui vuoi iniziare ad inserire la nave\nscegliendola tra quelle indicate in questo formato: a 0 destra 2");
					System.out.println("Nave Portaerei --> premere tasto 6\nNave Corazzata --> premere tasto 5\nNave Incrociatore --> premere tasto 4\nNave Sottomarino --> premere tasto 3\n Nave Cacciatorpediniere --> premere tasto 2\nNave Assalto --> premere tasto 1\n");
					System.out.println(listaNavi);
					try {
						inputAcquisito=br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Pattern p=null;
					if(gestore.getGiocatoreCorrente().getDimensione()==10){
						 p = Pattern.compile("[a-j][\\s][0-9][\\s](destra|sinistra|su|giu)[\\s][1-6]");
					}
					else if(gestore.getGiocatoreCorrente().getDimensione()==22){
						p = Pattern.compile("[a-v][\\s]([0-9]|1[0-9]|2[0-1])[\\s](destra|sinistra|su|giu)[\\s][1-6]");
					}
						 Matcher m = p.matcher(inputAcquisito);
						 System.out.println(m.matches());
						 
						 if(m.matches()){
							 
							 String[] inputSplit= inputAcquisito.split(" ");
							
							 int riga=inputSplit[0].hashCode()-97;
							 int colonna=Integer.parseInt(inputSplit[1]);
							 int direzione=0;
							 int numeroNaveCorrispondente=Integer.parseInt(inputSplit[3]);
							 Nave n =null;
							 
							 switch(inputSplit[2]){
							 case "su":{
								 direzione=Griglia.NORD;
								 break;
							 }
							 case "giu":{
								 direzione=Griglia.SUD;
								 break;
							 }
							 case "sinistra":{
								 direzione=Griglia.OVEST;
								 break;
							 }
							 case "destra":{
								 direzione = Griglia.EST;
								 break;
							 }
							 }
							 
							 switch(numeroNaveCorrispondente){
							 case 1:{
								 if(listaNavi.contains("assalto")){
									 n=new Nave("assalto");
									 listaNavi.remove("assalto");
								 }
		 						break;
							 }
							 case 2:{
								 if(listaNavi.contains("cacciatorpediniere")){
									 n=new Nave("cacciatorpediniere");
									 listaNavi.remove("cacciatorpediniere");
								 }
								 break;
							 }
							 case 3:{
								 if(listaNavi.contains("sottomarino")){
									 n=new Nave("sottomarino");
									 listaNavi.remove("sottomarino");
								 }
								 break;
							 }
							 case 4:{
								 if(listaNavi.contains("incrociatore")){
									 n=new Nave("incrociatore");
									 listaNavi.remove("incrociatore");
								 }
								 break;
							 }
							 case 5:{
								 if(listaNavi.contains("corazzata")){
									 n=new Nave("corazzata");
									 listaNavi.remove("corazzata");
								 }
								 break;
							 }
							 case 6:{
								 if(listaNavi.contains("portaerei")){
									 n=new Nave("portaerei");
									 listaNavi.remove("portaerei");
								 }
								 break;
							 }
							 }
							 
							controller.inserisciNave(gestore.getGiocatoreCorrente().getNome(),n, direzione, riga, colonna);

						 }					
					
					break; 
				}
				
				case "f":{
					if(!listaNavi.isEmpty()){
						System.out.println("NON HAI FINITO DI AGGIUNGERE LE NAVI!!!");
						inputAzione="";
					}
					else{
						if(gestore.getGiocatoreCorrente().equals(gestore.getGiocatore1())){
							gestore.setGiocatoreCorrente(gestore.getGiocatore2());
							mostraBattagliaNavale(0);
						}
						else
							gestore.setGiocatoreCorrente(gestore.getGiocatore1());
					}
					
					break;
				}
				
				case "r":{
					System.out.println("Inserisci la coordinata della casella per rimuovere la nave");
					try {
						inputAcquisito=br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					 Pattern p=Pattern.compile("[a-j][\\s][0-9]");
					 Matcher m = p.matcher(inputAcquisito);
					 System.out.println(m.matches());
					 
					 if(m.matches()){
						 
						 String[] inputSplit= inputAcquisito.split(" ");
						
						 int riga=inputSplit[0].hashCode()-97;
						 int colonna=Integer.parseInt(inputSplit[1]);
						 Nave n =null;
						 
						 n = gestore.getGiocatoreCorrente().getCasella(riga, colonna).getNave();
						 if(n != null)
							 listaNavi.add(n.getNome());
						 
						 
						controller.rimuoviNave(gestore.getGiocatoreCorrente().getNome(),n.getNome());
	
					 }					
					
					
					
					break;
				}
				
				}
			}while(!inputAzione.equals("f"));
		}
	}
	
	private void acquisisciInputFase1() {
		
		Controller controller = new Controller(this, gestore);
		
		do{
			
			mostraBattagliaNavale(1);
			System.out.println("Inserisci le coordinate della casella che vuoi colpire!");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String inputAzione=null;
			
			
			try {
				inputAzione=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			Pattern p=null;
			if(gestore.getGiocatoreCorrente().getDimensione()==10){
				 p = Pattern.compile("[a-j][\\s][0-9]");
			}
			else if(gestore.getGiocatoreCorrente().getDimensione()==22){
				p = Pattern.compile("[a-v][\\s]([0-9]|1[0-9]|2[0-1])");
			}
			Matcher m = p.matcher(inputAzione);

			if(m.matches()){
				String[] inputSplit= inputAzione.split(" ");
				
				int riga=inputSplit[0].hashCode()-97;
				int colonna=Integer.parseInt(inputSplit[1]);
				
				controller.prossimoGiocatore(riga, colonna);
				
			}
			
			
		}
		while(!gestore.finitaPartita());
		
		System.out.println("HA VINTO "+ gestore.getVincitore());
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		
		int faseDiGioco = (Integer)arg1;
		mostraBattagliaNavale(faseDiGioco);	
	}


	@Override
	public void pannelloImpostazioneSinglePlayer() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void pannelloIniziale() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void pannelloImpostazioneGriglia() {
		// TODO Auto-generated method stub
		
	}

}
