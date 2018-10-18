package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import model.GestoreGioco;
import model.Nave;

import controller.Controller;

public class PannelloImpostazioneGriglia extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int HEIGHT=768;
	private static final int WIDTH=1366;
	
	private PanelSwitcher switcher;
	
	private Controller controller;
	
	private JLabel corazzata;
	
	private JLabel portaerei;
	
	private JLabel incrociatore;
	
	private JLabel sottomarino;
	
	private JLabel cacciatorpediniere;
	
	private JLabel assalto;
	
	private JLabel corazzataOrizzontale;
	
	private JLabel portaereiOrizzontale;
	
	private JLabel incrociatoreOrizzontale;
	
	private JLabel sottomarinoOrizzontale;
	
	private JLabel cacciatorpediniereOrizzontale;
	
	private JLabel assaltoOrizzontale;
	
	private JLabel avviaPartita;
	
	private JLabel rimuovi;
	
	private JLabel reset;
	
	private JLabel indietro;
	
	private JLabel spuntaVerde;

	private JLabel xRossa;
	
	private JGradientButton frecciaSinistra;
	
	private JGradientButton frecciaDestra;
	
	private JGradientButton frecciaSu;
	
	private JGradientButton frecciaGiu;
	
	private int direzione=-1;
	
	private String nomeNave="";
	
	private int dimensione=0;
	
	private JLabel naveSelezionata=new JLabel();
	
	private ArrayList<CasellaGui> griglia= new ArrayList<>();
	
	private int posizioneCorrente;
	
	private GestoreGioco gestore;
	
	private Border yellow=BorderFactory.createLineBorder(Color.yellow, 5);
		
	public PannelloImpostazioneGriglia(PanelSwitcher switcher, Controller controller,GestoreGioco gestore) {
	
		this.switcher=switcher;
		this.controller=controller;
		this.gestore=gestore;
		
		init();
		
	}


	private void init() {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setLayout(null);
		
		this.spuntaVerde=new JLabel();
		this.spuntaVerde.setIcon(new ImageIcon(ImageProvider.getSpuntaVerde()));
		
		this.xRossa=new JLabel();
		this.xRossa.setIcon(new ImageIcon(ImageProvider.getxRossa()));
		
		int partenzaX=40;
		int partenzaY=30;
		
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				
				griglia.add(new CasellaGui(partenzaX, partenzaY, i, j));
				partenzaX+=70;
			}
			partenzaY+=70;
			partenzaX=40;
		}
		
		
		for(int i=0;i<griglia.size();i++){
			System.out.println(griglia.get(i).toString());
		}			
		
		addMouseMotionListener(new MouseAdapter() {
			
			public void mouseMoved(MouseEvent e) {
				
				for(int i=0;i<griglia.size();i++){
					
					if(nomeNave!="" && direzione != -1){
						
						if(e.getX()>= griglia.get(i).getPartenzaX() && e.getX() <= griglia.get(i).getArrivoX()){
							if(e.getY()>=griglia.get(i).getPartenzaY() && e.getY() <= griglia.get(i).getArrivoY()){
								posizioneCorrente = i;
								controller.controllaInserimento(gestore.getGiocatoreCorrente().getNome(), new Nave(nomeNave), direzione, griglia.get(i).getCoordinataX(), griglia.get(i).getCoordinataY());
							}
						}	
					}
				}
			}
		});
		
		addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				
				for(int i=0;i<griglia.size();i++){
					
					if(nomeNave!="" && direzione != -1){
						
						if(e.getX()>= griglia.get(i).getPartenzaX() && e.getX() <= griglia.get(i).getArrivoX()){
							if(e.getY()>=griglia.get(i).getPartenzaY() && e.getY() <= griglia.get(i).getArrivoY()){
								if(controller.controllaInserimento(gestore.getGiocatoreCorrente().getNome(), new Nave(nomeNave), direzione, griglia.get(i).getCoordinataX(), griglia.get(i).getCoordinataY())){
																	
									repaint();
									posizioneCorrente = i;
									controller.inserisciNave(gestore.getGiocatoreCorrente().getNome(), new Nave(nomeNave), direzione, griglia.get(i).getCoordinataX(), griglia.get(i).getCoordinataY());
									nomeNave="";
									direzione=-1;
									remove(spuntaVerde);
									frecciaSu.setBorder(null);
									frecciaGiu.setBorder(null);
									frecciaSinistra.setBorder(null);
									frecciaDestra.setBorder(null);
									
								}
							}
						}
					}
				}
			}
		
		});
		
		corazzata=new JLabel();
		corazzata.setIcon(new ImageIcon(ImageProvider.getCorazzata()));
		corazzata.setSize(70,280);
		
		corazzata.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				
				naveSelezionata=corazzata;
				naveSelezionata.setBorder(yellow);
				
				portaerei.setBorder(null);
				sottomarino.setBorder(null);
				incrociatore.setBorder(null);
				cacciatorpediniere.setBorder(null);
				assalto.setBorder(null);
				
				nomeNave="corazzata";
			}
			
		});
		
		corazzataOrizzontale=new JLabel();
		corazzataOrizzontale.setIcon(new ImageIcon(ImageProvider.getCorazzataOrizzontale()));
		corazzataOrizzontale.setSize(280,70);
		corazzataOrizzontale.setBounds(750,170,280, 70);
		this.add(corazzataOrizzontale);
		
		corazzataOrizzontale.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				
				corazzataOrizzontale.setBorder(yellow);
				
				portaereiOrizzontale.setBorder(null);
				incrociatoreOrizzontale.setBorder(null);
				sottomarinoOrizzontale.setBorder(null);
				cacciatorpediniereOrizzontale.setBorder(null);
				assaltoOrizzontale.setBorder(null);
				
				if(direzione!=-1){
					
					if(direzione==1 || direzione==0){
						naveSelezionata=corazzata;
					}
					else if(direzione==2||direzione==3){
						naveSelezionata=corazzataOrizzontale;
					}
					
				}
				nomeNave="corazzata";

			}
		});
		
		portaerei=new JLabel();
		portaerei.setIcon(new ImageIcon(ImageProvider.getPortaerei()));
		portaerei.setSize(70,350);
		
		
		
		portaerei.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				
				naveSelezionata=portaerei;
				naveSelezionata.setBorder(yellow);
				
				corazzata.setBorder(null);
				sottomarino.setBorder(null);
				incrociatore.setBorder(null);
				cacciatorpediniere.setBorder(null);
				assalto.setBorder(null);
				
				nomeNave="portaerei";
			}
			
		});
		
		
		portaereiOrizzontale=new JLabel();
		portaereiOrizzontale.setIcon(new ImageIcon(ImageProvider.getPortaereiOrizzontale()));
		portaereiOrizzontale.setSize(350,70);
		portaereiOrizzontale.setBounds(750,30, 350, 70);
		this.add(portaereiOrizzontale);
		
		portaereiOrizzontale.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				
				
				portaereiOrizzontale.setBorder(yellow);
				
				corazzataOrizzontale.setBorder(null);
				incrociatoreOrizzontale.setBorder(null);
				sottomarinoOrizzontale.setBorder(null);
				cacciatorpediniereOrizzontale.setBorder(null);
				assaltoOrizzontale.setBorder(null);
				
				if(direzione!=-1){
					
					if(direzione==1 || direzione==0){
						naveSelezionata=portaerei;
					}
					else if(direzione==2||direzione==3){
						naveSelezionata=portaereiOrizzontale;
					}
					
				}
				nomeNave="portaerei";

			}
		});
		
		incrociatore=new JLabel();
		incrociatore.setIcon(new ImageIcon(ImageProvider.getIncrociatore()));
		incrociatore.setSize(70,210);
		
		incrociatore.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				
				naveSelezionata=incrociatore;
				naveSelezionata.setBorder(yellow);
				
				corazzata.setBorder(null);
				sottomarino.setBorder(null);
				portaerei.setBorder(null);
				cacciatorpediniere.setBorder(null);
				assalto.setBorder(null);
				
				nomeNave="incrociatore";
			}
			
		});
		

		incrociatoreOrizzontale=new JLabel();
		incrociatoreOrizzontale.setIcon(new ImageIcon(ImageProvider.getIncrociatoreOrizzontale()));
		incrociatoreOrizzontale.setSize(210,70);
		incrociatoreOrizzontale.setBounds(750, 310,210,70);
		this.add(incrociatoreOrizzontale);
		
		incrociatoreOrizzontale.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				
				incrociatoreOrizzontale.setBorder(yellow);
				
				portaereiOrizzontale.setBorder(null);
				corazzataOrizzontale.setBorder(null);
				sottomarinoOrizzontale.setBorder(null);
				cacciatorpediniereOrizzontale.setBorder(null);
				assaltoOrizzontale.setBorder(null);
				
				if(direzione!=-1){
					
					if(direzione==1 || direzione==0){
						naveSelezionata=incrociatore;
					}
					else if(direzione==2||direzione==3){
						naveSelezionata=incrociatoreOrizzontale;
					}
					
				}
				nomeNave="incrociatore";

			}
		});
		
		sottomarino=new JLabel();
		sottomarino.setIcon(new ImageIcon(ImageProvider.getSottomarino()));
		sottomarino.setSize(70,210);
		
		sottomarino.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				
				naveSelezionata=sottomarino;
				naveSelezionata.setBorder(yellow);
				
				corazzata.setBorder(null);
				incrociatore.setBorder(null);
				portaerei.setBorder(null);
				cacciatorpediniere.setBorder(null);
				assalto.setBorder(null);
				
				nomeNave="sottomarino";
			}
			
		});
		
		sottomarinoOrizzontale=new JLabel();
		sottomarinoOrizzontale.setIcon(new ImageIcon(ImageProvider.getSottomarinoOrizzontale()));
		sottomarinoOrizzontale.setSize(210,70);
		sottomarinoOrizzontale.setBounds(750,450,210,70);
		this.add(sottomarinoOrizzontale);
		
		sottomarinoOrizzontale.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				
				sottomarinoOrizzontale.setBorder(yellow);
				
				portaereiOrizzontale.setBorder(null);
				incrociatoreOrizzontale.setBorder(null);
				corazzataOrizzontale.setBorder(null);
				cacciatorpediniereOrizzontale.setBorder(null);
				assaltoOrizzontale.setBorder(null);
				
				if(direzione!=-1){
					
					if(direzione==1 || direzione==0){
						naveSelezionata=sottomarino;
					}
					else if(direzione==2||direzione==3){
						naveSelezionata=sottomarinoOrizzontale;
					}
				}
				nomeNave="sottomarino";
			}
		});
		
		cacciatorpediniere=new JLabel();
		cacciatorpediniere.setIcon(new ImageIcon(ImageProvider.getCacciatorpediniere()));
		cacciatorpediniere.setSize(70,140);
		
		cacciatorpediniere.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				
				naveSelezionata=cacciatorpediniere;
				naveSelezionata.setBorder(yellow);
				
				corazzata.setBorder(null);
				sottomarino.setBorder(null);
				portaerei.setBorder(null);
				incrociatore.setBorder(null);
				assalto.setBorder(null);
				
				nomeNave="cacciatorpediniere";
			}
			
		});
		
		
		cacciatorpediniereOrizzontale=new JLabel();
		cacciatorpediniereOrizzontale.setIcon(new ImageIcon(ImageProvider.getCacciatorpediniereOrizzontale()));
		cacciatorpediniereOrizzontale.setSize(140,70);
		cacciatorpediniereOrizzontale.setBounds(750,590,140,70);
		this.add(cacciatorpediniereOrizzontale);
		
		cacciatorpediniereOrizzontale.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				
				cacciatorpediniereOrizzontale.setBorder(yellow);
				
				
				portaereiOrizzontale.setBorder(null);
				incrociatoreOrizzontale.setBorder(null);
				sottomarinoOrizzontale.setBorder(null);
				corazzataOrizzontale.setBorder(null);
				assaltoOrizzontale.setBorder(null);
				
				if(direzione!=-1){
					
					if(direzione==1 || direzione==0){
						naveSelezionata=cacciatorpediniere;
					}
					else if(direzione==2||direzione==3){
						naveSelezionata=cacciatorpediniereOrizzontale;
					}
				}
				nomeNave="cacciatorpediniere";
			}
		});
//		eliminare assalto verticale
//		assalto=new JLabel();
//		assalto.setIcon(new ImageIcon(ImageProvider.getAssalto()));
//		assalto.setSize(70,70);
//	
//		assalto.addMouseListener(new MouseAdapter() {
//			
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				super.mouseReleased(e);
//				
//				naveSelezionata=assalto;
//				naveSelezionata.setBorder(yellow);
//				
//				corazzata.setBorder(null);
//				sottomarino.setBorder(null);
//				portaerei.setBorder(null);
//				cacciatorpediniere.setBorder(null);
//				incrociatore.setBorder(null);
//				nomeNave="assalto";
//			}
//			
//		});
//		
		
		assaltoOrizzontale=new JLabel();
		assaltoOrizzontale.setIcon(new ImageIcon(ImageProvider.getAssaltoOrizzontale()));
		assaltoOrizzontale.setSize(70,70);
		assaltoOrizzontale.setBounds(950,600, 70, 70);
		this.add(assaltoOrizzontale);
		
		assaltoOrizzontale.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				
				
				assaltoOrizzontale.setBorder(yellow);
				
				portaereiOrizzontale.setBorder(null);
				incrociatoreOrizzontale.setBorder(null);
				sottomarinoOrizzontale.setBorder(null);
				cacciatorpediniereOrizzontale.setBorder(null);
				corazzataOrizzontale.setBorder(null);
				
				if(direzione!=-1){
					
//					if(direzione==1 || direzione==0){
//						naveSelezionata=assalto;
//					}
//					else if(direzione==2||direzione==3){
						naveSelezionata=assaltoOrizzontale;
//					}
				}
				nomeNave="assalto";
			}
		});
		
		
		frecciaSinistra=JGradientButton.newInstance();
		frecciaSinistra.setIcon(new ImageIcon(ImageProvider.getFrecciaSinistra()));
		frecciaSinistra.setBounds(1143, 90, 60,60);
		this.add(frecciaSinistra);
		
		frecciaSinistra.addMouseListener(new MouseAdapter() {
		
				@Override
				public void mouseReleased(MouseEvent e) {
					super.mouseReleased(e);
					direzione=2;
					Border border = BorderFactory.createBevelBorder (BevelBorder.RAISED, Color.YELLOW,Color.YELLOW);
					frecciaSinistra.setBorder (border);
					frecciaSinistra.setBorderPainted (true);
					
					frecciaDestra.setBorderPainted(false);
					frecciaGiu.setBorderPainted(false);
					frecciaSu.setBorderPainted(false);

				}
		});
		
		frecciaDestra=JGradientButton.newInstance();
		frecciaDestra.setIcon(new ImageIcon(ImageProvider.getFrecciaDestra()));
		frecciaDestra.setBounds(1263,90,60,60);
		this.add(frecciaDestra);
		
		frecciaDestra.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				direzione=3;
				Border border = BorderFactory.createBevelBorder (BevelBorder.RAISED, Color.YELLOW,Color.YELLOW);
				frecciaDestra.setBorder (border);
				frecciaDestra.setBorderPainted (true);
				
				frecciaSinistra.setBorderPainted(false);
				frecciaGiu.setBorderPainted(false);
				frecciaSu.setBorderPainted(false);
			}
		});
		
		frecciaSu=JGradientButton.newInstance();
		frecciaSu.setIcon(new ImageIcon(ImageProvider.getFrecciaSu()));
		frecciaSu.setBounds(1203,30, 60,60);
		this.add(frecciaSu);
		
		frecciaSu.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				direzione=0;
				
				Border border = BorderFactory.createBevelBorder (BevelBorder.RAISED, Color.YELLOW,Color.YELLOW);
				frecciaSu.setBorder (border);
				frecciaSu.setBorderPainted (true);
				
				frecciaSinistra.setBorderPainted(false);
				frecciaGiu.setBorderPainted(false);
				frecciaDestra.setBorderPainted(false);
			}
		});
		
		frecciaGiu=JGradientButton.newInstance();
		frecciaGiu.setIcon(new ImageIcon(ImageProvider.getFrecciaGiu()));
		frecciaGiu.setBounds(1203, 150, 60,60);
		this.add(frecciaGiu);
		
		frecciaGiu.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				direzione=1;
				
				Border border = BorderFactory.createBevelBorder (BevelBorder.RAISED, Color.YELLOW,Color.YELLOW);
				frecciaGiu.setBorder (border);
				frecciaGiu.setBorderPainted (true);
				
				frecciaSinistra.setBorderPainted(false);
				frecciaDestra.setBorderPainted(false);
				frecciaSu.setBorderPainted(false);
			}
		});
		
		avviaPartita=new JLabel();
		avviaPartita.setIcon(new ImageIcon(ImageProvider.getAvviaPartitaPiccola()));
		avviaPartita.setSize(287,59);
		avviaPartita.setBounds(1097, 300,287,59);
		this.add(avviaPartita);
		
		avviaPartita.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				avviaPartita.setIcon(new ImageIcon(ImageProvider.getAvviaPartitaGrande()));

			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				avviaPartita.setIcon(new ImageIcon(ImageProvider.getAvviaPartitaPiccola()));

			}
		});
		
		rimuovi=new JLabel();
		rimuovi.setIcon(new ImageIcon(ImageProvider.getRimuoviPiccola()));
		rimuovi.setSize(172,57);
		rimuovi.setBounds(1097, 400,172,57);
		this.add(rimuovi);
		
		rimuovi.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				
				controller.rimuoviNave(gestore.getGiocatoreCorrente().getNome(), nomeNave);
			}
			
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				rimuovi.setIcon(new ImageIcon(ImageProvider.getRimuoviGrande()));

			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				rimuovi.setIcon(new ImageIcon(ImageProvider.getRimuoviPiccola()));

			}
		});
		
		reset=new JLabel();
		reset.setIcon(new ImageIcon(ImageProvider.getResetPiccola()));
		reset.setSize(121,57);
		reset.setBounds(1097, 500,121,57);
		this.add(reset);
		
		reset.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				System.out.println("STAMPA PRIMA DEL RESET");
				controller.reset(gestore.getGiocatoreCorrente().getNome());
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				reset.setIcon(new ImageIcon(ImageProvider.getResetGrande()));

			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				reset.setIcon(new ImageIcon(ImageProvider.getResetPiccola()));

			}
		});
		
		indietro=new JLabel();
		indietro.setIcon(new ImageIcon(ImageProvider.getIndietroPiccola()));
		indietro.setSize(181,57);
		indietro.setBounds(1097, 600,181,57);
		this.add(indietro);
		
		indietro.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				controller.pannelloImpostazioneSinglePlayer();
				controller.reset(gestore.getGiocatoreCorrente().getNome());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				indietro.setIcon(new ImageIcon(ImageProvider.getIndietroGrande()));

			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				indietro.setIcon(new ImageIcon(ImageProvider.getIndietroPiccola()));

			}
		});
		
		
		
	}
	
	public void setSpuntaVerdeRosso(boolean puoiSpuntare) {
		if(puoiSpuntare){
			spuntaVerde.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY(), 70, 70);
			add(spuntaVerde);
			remove(xRossa);
			repaint();
		}
		else{
			xRossa.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY(), 70, 70);
			add(xRossa);
			remove(spuntaVerde);
			repaint();
		}
	}
	
	public void inserisciNave() {
		
		switch(nomeNave){
		
		case("portaerei"):{
			
			if(direzione==0){//su
				portaerei.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY()-(70*4), 70, 70*5);
				add(portaerei);
				remove(portaereiOrizzontale);
				
			}
			else if(direzione==1){//giu
				portaerei.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY(), 70, 70*5);
				add(portaerei);
				remove(portaereiOrizzontale);
			}
			
			else if(direzione==2){//sinistra
				portaereiOrizzontale.setBounds(griglia.get(posizioneCorrente).getPartenzaX()-(70*4), griglia.get(posizioneCorrente).getPartenzaY(), 70*5, 70);
				portaereiOrizzontale.setBorder(null);
				add(portaereiOrizzontale);
			}
			else{//destra
				portaereiOrizzontale.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY(), 70*5, 70);
				portaereiOrizzontale.setBorder(null);
				add(portaereiOrizzontale);
			}
			break;
		}
		
			case("corazzata"):{
			
			if(direzione==0){//su
				corazzata.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY()-(70*3), 70, 70*4);
				add(corazzata);
				remove(corazzataOrizzontale);
				
			}
			else if(direzione==1){//giu
				corazzata.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY(), 70, 70*4);
				add(corazzata);
				remove(corazzataOrizzontale);
			}
			
			else if(direzione==2){//sinistra
				corazzataOrizzontale.setBounds(griglia.get(posizioneCorrente).getPartenzaX()-(70*3), griglia.get(posizioneCorrente).getPartenzaY(), 70*4, 70);
				corazzataOrizzontale.setBorder(null);
				add(corazzataOrizzontale);
			}
			else{//destra
				corazzataOrizzontale.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY(), 70*4, 70);
				corazzataOrizzontale.setBorder(null);
				add(corazzataOrizzontale);
			}
			break;
		}
			
			case("incrociatore"):{
				
				if(direzione==0){//su
					incrociatore.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY()-(70*2), 70, 70*3);
					add(incrociatore);
					remove(incrociatoreOrizzontale);
					
				}
				else if(direzione==1){//giu
					incrociatore.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY(), 70, 70*3);
					add(incrociatore);
					remove(incrociatoreOrizzontale);
				}
				
				else if(direzione==2){//sinistra
					incrociatoreOrizzontale.setBounds(griglia.get(posizioneCorrente).getPartenzaX()-(70*2), griglia.get(posizioneCorrente).getPartenzaY(), 70*3, 70);
					incrociatoreOrizzontale.setBorder(null);
					add(incrociatoreOrizzontale);
				}
				else{//destra
					incrociatoreOrizzontale.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY(), 70*3, 70);
					incrociatoreOrizzontale.setBorder(null);
					add(incrociatoreOrizzontale);
				}
				break;
			}
			
			case("sottomarino"):{
				
				if(direzione==0){//su
					sottomarino.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY()-(70*2), 70, 70*3);
					add(sottomarino);
					remove(sottomarinoOrizzontale);
					
				}
				else if(direzione==1){//giu
					sottomarino.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY(), 70, 70*3);
					add(sottomarino);
					remove(sottomarinoOrizzontale);
				}
				
				else if(direzione==2){//sinistra
					sottomarinoOrizzontale.setBounds(griglia.get(posizioneCorrente).getPartenzaX()-(70*2), griglia.get(posizioneCorrente).getPartenzaY(), 70*3, 70);
					sottomarinoOrizzontale.setBorder(null);
					add(sottomarinoOrizzontale);
				}
				else{//destra
					sottomarinoOrizzontale.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY(), 70*3, 70);
					sottomarinoOrizzontale.setBorder(null);
					add(sottomarinoOrizzontale);
				}
				break;
			}
			
			case("cacciatorpediniere"):{
				
				if(direzione==0){//su
					cacciatorpediniere.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY()-(70), 70, 70*2);
					add(cacciatorpediniere);
					remove(cacciatorpediniereOrizzontale);
					
				}
				else if(direzione==1){//giu
					cacciatorpediniere.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY(), 70, 70*2);
					add(cacciatorpediniere);
					remove(cacciatorpediniereOrizzontale);
				}
				
				else if(direzione==2){//sinistra
					cacciatorpediniereOrizzontale.setBounds(griglia.get(posizioneCorrente).getPartenzaX()-(70), griglia.get(posizioneCorrente).getPartenzaY(), 70*2, 70);
					cacciatorpediniereOrizzontale.setBorder(null);
					add(cacciatorpediniereOrizzontale);
				}
				else{//destra
					cacciatorpediniereOrizzontale.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY(), 70*2, 70);
					cacciatorpediniereOrizzontale.setBorder(null);
					add(cacciatorpediniereOrizzontale);
				}
				break;
			}
			
			case("assalto"):{
				
//				if(direzione==0){//su
//					assalto.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY(), 70, 70);
//					add(assalto);
//					remove(assaltoOrizzontale);
//					
//				}
//				else if(direzione==1){//giu
//					assaltoOrizzontale.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY(), 70, 70);
//					add(assalto);
//					remove(assaltoOrizzontale);
//				}
				
//				else if(direzione==2){//sinistra
					assaltoOrizzontale.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY(), 70, 70);
					assaltoOrizzontale.setBorder(null);
					add(assaltoOrizzontale);
//				}
//				else{//destra
//					assaltoOrizzontale.setBounds(griglia.get(posizioneCorrente).getPartenzaX(), griglia.get(posizioneCorrente).getPartenzaY(), 70, 70);
//					assaltoOrizzontale.setBorder(null);
//					add(assaltoOrizzontale);
//				}
				break;
			}
		}
		
	}
	
	public void reset() {
		
//		this.remove(assalto);
		this.remove(portaerei);
		this.remove(corazzata);
		this.remove(cacciatorpediniere);
		this.remove(incrociatore);
		this.remove(sottomarino);
		
		corazzataOrizzontale.setBounds(750,170,280, 70);
		this.add(corazzataOrizzontale);
		portaereiOrizzontale.setBounds(750,30, 350, 70);
		this.add(portaereiOrizzontale);
		incrociatoreOrizzontale.setBounds(750, 310,210,70);
		this.add(incrociatoreOrizzontale);
		sottomarinoOrizzontale.setBounds(750,450,210,70);
		this.add(sottomarinoOrizzontale);
		cacciatorpediniereOrizzontale.setBounds(750,590,140,70);
		this.add(cacciatorpediniereOrizzontale);
		assaltoOrizzontale.setBounds(950,600, 70, 70);
		this.add(assaltoOrizzontale);
		
		
		
		nomeNave="";
		direzione=-1;
		naveSelezionata=null;
		System.out.println("STAMPA DOPO IL RESET");
		repaint();
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
        Color color1 = this.getBackground();
        Color color2 = color1.darker();
        Color color3 = color2.darker();
        Color color4 = color3.darker();
        GradientPaint gp = new GradientPaint(
            0, 0, color1, 0, HEIGHT, color4);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);
        
        g.drawImage(ImageProvider.getMare(),0,0,null);
		
		int partenzaSfondoBluX=40;
		int partenzaSfondoBluY=30;
		int arrivoSfondoBluX=740;
		int arrivoSfondoBluY=730;
		g2d.setColor(Color.black);
		g2d.setStroke(new BasicStroke(3));
		this.dimensione=gestore.getDimensione();

		if(dimensione==10){
			
			for(int i=0;i<=10;i++){
				g2d.drawLine(partenzaSfondoBluX, partenzaSfondoBluY, arrivoSfondoBluX, partenzaSfondoBluY);
				partenzaSfondoBluY+=70;
				
			}
			partenzaSfondoBluY=30;
			for(int i=0;i<=10;i++){
				g2d.drawLine(partenzaSfondoBluX, partenzaSfondoBluY, partenzaSfondoBluX, arrivoSfondoBluY);
				partenzaSfondoBluX+=70;
			}
			partenzaSfondoBluX=40;

		}
		else{
			for(int i=0;i<=20;i++){
				g2d.drawLine(partenzaSfondoBluX, partenzaSfondoBluY, arrivoSfondoBluX, partenzaSfondoBluY);
				partenzaSfondoBluY+=35;
				
			}
			partenzaSfondoBluY=30;
			for(int i=0;i<=20;i++){
				g2d.drawLine(partenzaSfondoBluX, partenzaSfondoBluY, partenzaSfondoBluX, arrivoSfondoBluY);
				partenzaSfondoBluX+=35;
			}
			partenzaSfondoBluX=40;
			
			
		}
		
		

		
	}
	
	public int getPosizioneCorrente() {
		return posizioneCorrente;
	}


	public void setPosizioneCorrente(int posizioneCorrente) {
		this.posizioneCorrente = posizioneCorrente;
	}

	private static class JGradientButton extends JButton {
       
		private JGradientButton() {
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
        	super.paintComponent(g);

    		Graphics2D g2d = (Graphics2D) g;
            Color color1 = this.getBackground();
            Color color2 = color1.darker();
            Color color3 = color2.darker();
            Color color4 = color3.darker();
            GradientPaint gp = new GradientPaint(
                0, 0, color1, 0, HEIGHT, color4);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, WIDTH, HEIGHT);
//            g2d.dispose();
        }

        public static JGradientButton newInstance() {
            return new JGradientButton();
        }
    }

	public void rimuovi() {
		
		switch (nomeNave){
		
		case("portaerei"):{
			
			if(naveSelezionata.getWidth()<naveSelezionata.getHeight()){
				remove(portaerei);
			}
			portaereiOrizzontale.setBounds(750,30, 350, 70);			
			add(portaereiOrizzontale);
			break;
		}
		
		case("corazzata"):{
			if(naveSelezionata.getWidth()<naveSelezionata.getHeight()){
				remove(corazzata);
			}
			corazzataOrizzontale.setBounds(750,170,280, 70);
			add(corazzataOrizzontale);
			break;
		}
		case("sottomarino"):{
			if(naveSelezionata.getWidth()<naveSelezionata.getHeight()){
				remove(sottomarino);
			}
			sottomarinoOrizzontale.setBounds(750,450,210,70);
			add(sottomarinoOrizzontale);
			break;
		}
		
		case("incrociatore"):{
			if(naveSelezionata.getWidth()<naveSelezionata.getHeight()){
				remove(incrociatore);
			}
			incrociatoreOrizzontale.setBounds(750, 310,210,70);
			add(incrociatoreOrizzontale);
			break;
		}
		
		case("cacciatorpediniere"):{
			if(naveSelezionata.getWidth()<naveSelezionata.getHeight()){
				remove(cacciatorpediniere);
			}
			cacciatorpediniereOrizzontale.setBounds(750,590,140,70);
			add(cacciatorpediniereOrizzontale);
			break;
		}
		
		case("assalto"):{
			if(naveSelezionata.getWidth()<naveSelezionata.getHeight()){
				remove(assalto);
			}
			assaltoOrizzontale.setBounds(950,600, 70, 70);
			add(assaltoOrizzontale);
			break;
			
		}
		}
		repaint();
	}


	
}


