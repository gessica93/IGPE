package view;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageProvider {

	private static Image sfondo;
	
	private static Image singlePlayer;
	
	private static Image giocatoreSingoloGrande;
	
	private static Image multigiocatoreGrande;

	private static Image multigiocatore;

	private static Image esci;

	private static Image esciGrande;

	private static Image inserisciIlTuoNome;

	private static Image trattino;

	private static Image livello;
	
	private static Image facileVerde;

	private static Image difficileVerde;
	
	private static Image difficileGrigio;
	
	private static Image facileGrigio;

	private static Image avanti;
	
	private static Image avantiGrande;
	
	private static Image indietro;
	
	private static Image mare;

	private static Image corazzata;

	private static Image portaerei;

	private static Image incrociatore;

	private static Image sottomarino;

	private static Image cacciatorpediniere;

	private static Image assalto;
	
	private static Image corazzataOrizzontale;

	private static Image portaereiOrizzontale;

	private static Image incrociatoreOrizzontale;

	private static Image sottomarinoOrizzontale;

	private static Image cacciatorpediniereOrizzontale;

	private static Image assaltoOrizzontale;
	
	private static Image frecciaSinistra;
	
	private static Image frecciaDestra;
	
	private static Image frecciaSu;
	
	private static Image frecciaGiu;
	
	private static Image avviaPartitaPiccola;
	
	private static Image avviaPartitaGrande;
	
	private static Image rimuoviPiccola;
	
	private static Image rimuoviGrande;
	
	private static Image resetPiccola;
	
	private static Image resetGrande;
	
	private static Image indietroPiccola;
	
	private static Image indietroGrande;
	
	private static Image spuntaVerde;
	
	private static Image xRossa;


	static {
		try{
			setSfondo(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/sfondo.jpeg")));
			setSinglePlayer(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/giocatoreSingolo.png")));
			setGiocatoreSingoloGrande(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/giocatoreSingoloGrande.png")));
			setMultigiocatoreGrande(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/multigiocatoreGrande.png")));
			setMultigiocatore(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/multigiocatore.png")));
			setEsci(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/esci.png")));
			setEsciGrande(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/esciGrande.png")));
			setInserisciIlTuoNome(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/inserisciIlTuoNome.png")));
			setTrattino(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/trattino.png")));
			setLivello(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/livello.png")));
			setFacileVerde(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/facileVerde.png")));
			setDifficileVerde(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/difficileVerde.png")));
			setDifficileGrigio(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/difficileGrigio.png")));
			setFacileGrigio(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/facileGrigio.png")));
			setAvanti(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/avanti.png")));
			setAvantiGrande(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/avantiGrande.png")));
			setIndietro(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/indietro.png")));
			setMare(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/mare.jpg")));
			setCorazzata(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/corazzata.png")));
			setPortaerei(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/portaerei.png")));
			setIncrociatore(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/incrociatore.png")));
			setSottomarino(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/sottomarino.png")));
			setCacciatorpediniere(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/cacciatorpediniere.png")));
			setAssalto(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/assalto.png")));
			setCorazzataOrizzontale(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/corazzataOrizzontale.png")));
			setPortaereiOrizzontale(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/portaereiOrizzontale.png")));
			setIncrociatoreOrizzontale(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/incrociatoreOrizzontale.png")));
			setSottomarinoOrizzontale(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/sottomarinoOrizzontale.png")));
			setCacciatorpediniereOrizzontale(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/cacciatorpediniereOrizzontale.png")));
			setAssaltoOrizzontale(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/assaltoOrizzontale.png")));
			setFrecciaSinistra(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/frecciaSinistra.png")));
			setFrecciaDestra(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/frecciaDestra.png")));
			setFrecciaSu(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/frecciaSu.png")));
			setFrecciaGiu(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/frecciaGiu.png")));
			setAvviaPartitaPiccola(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/avviaPartitaPiccola.png")));
			setAvviaPartitaGrande(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/avviaPartitaGrande.png")));
			setRimuoviPiccola(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/rimuoviPiccola.png")));
			setRimuoviGrande(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/rimuoviGrande.png")));
			setResetPiccola(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/resetPiccola.png")));
			setResetGrande(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/resetGrande.png")));
			setIndietroPiccola(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/indietroPiccola.png")));
			setIndietroGrande(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/IndietroGrande.png")));
			setSpuntaVerde(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/spuntaVerde.png")));
			setxRossa(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("res/xRossa.png")));



		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static Image getSfondo() {
		return sfondo;
	}

	public static void setSfondo(Image sfondo) {
		ImageProvider.sfondo = sfondo;
	}

	public static Image getSinglePlayer() {
		return singlePlayer;
	}

	public static void setSinglePlayer(Image singlePlayer) {
		ImageProvider.singlePlayer = singlePlayer;
	}

	public static Image getGiocatoreSingoloGrande() {
		return giocatoreSingoloGrande;
	}

	public static void setGiocatoreSingoloGrande(Image giocatoreSingoloGrande) {
		ImageProvider.giocatoreSingoloGrande = giocatoreSingoloGrande;
	}

	public static Image getMultigiocatoreGrande() {
		return multigiocatoreGrande;
	}

	public static void setMultigiocatoreGrande(Image multigiocatoreGrande) {
		ImageProvider.multigiocatoreGrande = multigiocatoreGrande;
	}

	public static Image getMultigiocatore() {
		return multigiocatore;
	}

	public static void setMultigiocatore(Image multigiocatore) {
		ImageProvider.multigiocatore = multigiocatore;
	}

	public static Image getEsci() {
		return esci;
	}

	public static void setEsci(Image esci) {
		ImageProvider.esci = esci;
	}

	public static Image getEsciGrande() {
		return esciGrande;
	}

	public static void setEsciGrande(Image esciGrande) {
		ImageProvider.esciGrande = esciGrande;
	}

	public static Image getInserisciIlTuoNome() {
		return inserisciIlTuoNome;
	}

	public static void setInserisciIlTuoNome(Image inserisciIlTuoNome) {
		ImageProvider.inserisciIlTuoNome = inserisciIlTuoNome;
	}

	public static Image getTrattino() {
		return trattino;
	}

	public static void setTrattino(Image trattino) {
		ImageProvider.trattino = trattino;
	}

	public static Image getLivello() {
		return livello;
	}

	public static void setLivello(Image livello) {
		ImageProvider.livello = livello;
	}

	public static Image getFacileVerde() {
		return facileVerde;
	}

	public static void setFacileVerde(Image facileVerde) {
		ImageProvider.facileVerde = facileVerde;
	}

	public static Image getDifficileVerde() {
		return difficileVerde;
	}

	public static void setDifficileVerde(Image difficileVerde) {
		ImageProvider.difficileVerde = difficileVerde;
	}

	public static Image getDifficileGrigio() {
		return difficileGrigio;
	}

	public static void setDifficileGrigio(Image difficileGrigio) {
		ImageProvider.difficileGrigio = difficileGrigio;
	}

	public static Image getFacileGrigio() {
		return facileGrigio;
	}

	public static void setFacileGrigio(Image facileGrigio) {
		ImageProvider.facileGrigio = facileGrigio;
	}

	public static Image getAvanti() {
		return avanti;
	}

	public static void setAvanti(Image avanti) {
		ImageProvider.avanti = avanti;
	}

	public static Image getAvantiGrande() {
		return avantiGrande;
	}

	public static void setAvantiGrande(Image avantiGrande) {
		ImageProvider.avantiGrande = avantiGrande;
	}

	public static Image getIndietro() {
		return indietro;
	}

	public static void setIndietro(Image indietro) {
		ImageProvider.indietro = indietro;
	}

	public static Image getMare() {
		return mare;
	}

	public static void setMare(Image mare) {
		ImageProvider.mare = mare;
	}

	public static Image getCorazzata() {
		return corazzata;
	}

	public static void setCorazzata(Image corazzata) {
		ImageProvider.corazzata = corazzata;
	}

	public static Image getPortaerei() {
		return portaerei;
	}

	public static void setPortaerei(Image portaerei) {
		ImageProvider.portaerei = portaerei;
	}

	public static Image getIncrociatore() {
		return incrociatore;
	}

	public static void setIncrociatore(Image incrociatore) {
		ImageProvider.incrociatore = incrociatore;
	}

	public static Image getSottomarino() {
		return sottomarino;
	}

	public static void setSottomarino(Image sottomarino) {
		ImageProvider.sottomarino = sottomarino;
	}

	public static Image getCacciatorpediniere() {
		return cacciatorpediniere;
	}

	public static void setCacciatorpediniere(Image cacciatorpediniere) {
		ImageProvider.cacciatorpediniere = cacciatorpediniere;
	}

	public static Image getAssalto() {
		return assalto;
	}

	public static void setAssalto(Image assalto) {
		ImageProvider.assalto = assalto;
	}

	public static Image getCorazzataOrizzontale() {
		return corazzataOrizzontale;
	}

	public static void setCorazzataOrizzontale(Image corazzataOrizzontale) {
		ImageProvider.corazzataOrizzontale = corazzataOrizzontale;
	}

	public static Image getPortaereiOrizzontale() {
		return portaereiOrizzontale;
	}

	public static void setPortaereiOrizzontale(Image portaereiOrizzontale) {
		ImageProvider.portaereiOrizzontale = portaereiOrizzontale;
	}

	public static Image getIncrociatoreOrizzontale() {
		return incrociatoreOrizzontale;
	}

	public static void setIncrociatoreOrizzontale(
			Image incrociatoreOrizzontale) {
		ImageProvider.incrociatoreOrizzontale = incrociatoreOrizzontale;
	}

	public static Image getSottomarinoOrizzontale() {
		return sottomarinoOrizzontale;
	}

	public static void setSottomarinoOrizzontale(Image sottomarinoOrizzontale) {
		ImageProvider.sottomarinoOrizzontale = sottomarinoOrizzontale;
	}

	public static Image getCacciatorpediniereOrizzontale() {
		return cacciatorpediniereOrizzontale;
	}

	public static void setCacciatorpediniereOrizzontale(
			Image cacciatorpediniereOrizzontale) {
		ImageProvider.cacciatorpediniereOrizzontale = cacciatorpediniereOrizzontale;
	}

	public static Image getAssaltoOrizzontale() {
		return assaltoOrizzontale;
	}

	public static void setAssaltoOrizzontale(Image assaltoOrizzontale) {
		ImageProvider.assaltoOrizzontale = assaltoOrizzontale;
	}

	public static Image getFrecciaSinistra() {
		return frecciaSinistra;
	}

	public static void setFrecciaSinistra(Image frecciaSinistra) {
		ImageProvider.frecciaSinistra = frecciaSinistra;
	}

	public static Image getFrecciaDestra() {
		return frecciaDestra;
	}

	public static void setFrecciaDestra(Image frecciaDestra) {
		ImageProvider.frecciaDestra = frecciaDestra;
	}

	public static Image getFrecciaSu() {
		return frecciaSu;
	}

	public static void setFrecciaSu(Image frecciaSu) {
		ImageProvider.frecciaSu = frecciaSu;
	}

	public static Image getFrecciaGiu() {
		return frecciaGiu;
	}

	public static void setFrecciaGiu(Image frecciaGiu) {
		ImageProvider.frecciaGiu = frecciaGiu;
	}

	public static Image getAvviaPartitaPiccola() {
		return avviaPartitaPiccola;
	}

	public static void setAvviaPartitaPiccola(Image avviaPartitaPiccola) {
		ImageProvider.avviaPartitaPiccola = avviaPartitaPiccola;
	}

	public static Image getAvviaPartitaGrande() {
		return avviaPartitaGrande;
	}

	public static void setAvviaPartitaGrande(Image avviaPartitaGrande) {
		ImageProvider.avviaPartitaGrande = avviaPartitaGrande;
	}

	public static Image getRimuoviPiccola() {
		return rimuoviPiccola;
	}

	public static void setRimuoviPiccola(Image rimuoviPiccola) {
		ImageProvider.rimuoviPiccola = rimuoviPiccola;
	}

	public static Image getRimuoviGrande() {
		return rimuoviGrande;
	}

	public static void setRimuoviGrande(Image rimuoviGrande) {
		ImageProvider.rimuoviGrande = rimuoviGrande;
	}

	public static Image getResetPiccola() {
		return resetPiccola;
	}

	public static void setResetPiccola(Image resetPiccola) {
		ImageProvider.resetPiccola = resetPiccola;
	}

	public static Image getResetGrande() {
		return resetGrande;
	}

	public static void setResetGrande(Image resetGrande) {
		ImageProvider.resetGrande = resetGrande;
	}

	public static Image getIndietroPiccola() {
		return indietroPiccola;
	}

	public static void setIndietroPiccola(Image indietroPiccola) {
		ImageProvider.indietroPiccola = indietroPiccola;
	}

	public static Image getIndietroGrande() {
		return indietroGrande;
	}

	public static void setIndietroGrande(Image indietroGrande) {
		ImageProvider.indietroGrande = indietroGrande;
	}

	public static Image getSpuntaVerde() {
		return spuntaVerde;
	}

	public static void setSpuntaVerde(Image spuntaVerde) {
		ImageProvider.spuntaVerde = spuntaVerde;
	}

	public static Image getxRossa() {
		return xRossa;
	}

	public static void setxRossa(Image xRossa) {
		ImageProvider.xRossa = xRossa;
	}
	
}
