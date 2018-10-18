package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import model.GestoreGioco;

import controller.Controller;

public class PannelloImpostazioneSinglePlayer extends JPanel {

	private static final int HEIGHT=768;
	private static final int WIDTH=1366;
	
	private PanelSwitcher switcher;
	
	private JTextField inserisciNome;
	
	private JLabel facile;
	
	private JLabel difficile;
	
	private JLabel avanti;
	
	private JLabel indietro;	
	
	private String nome=null;
	
	private int livello=-1;
	
	private Controller controller;
	
	
	public PannelloImpostazioneSinglePlayer(PanelSwitcher switcher, Controller controller){
		this.switcher = switcher;
		this.controller=controller;
		init();
		
	}
	private void init(){
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setLayout(null);
		inserisciNome=new JTextField();
		inserisciNome.setOpaque(false);
		inserisciNome.setCaretColor(Color.RED);
		inserisciNome.setBounds(430,200,500,50);
		inserisciNome.setForeground(Color.WHITE);
		Font font=new Font("SansSerif", Font.BOLD, 20);
		inserisciNome.setFont(font);
		this.add(inserisciNome);
		
		facile=new JLabel();
		facile.setBounds(300, 500, 261, 96);
		facile.setIcon(new ImageIcon(ImageProvider.getFacileGrigio()));
		this.add(facile);
		
		facile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				difficile.setIcon(new ImageIcon(ImageProvider.getDifficileGrigio()));
				facile.setIcon(new ImageIcon(ImageProvider.getFacileVerde()));
				controller.getGestore().setDimensione(10);
				
			}
		});
		
		difficile=new JLabel();
		difficile.setBounds(800, 500, 381, 96);
		difficile.setIcon(new ImageIcon(ImageProvider.getDifficileGrigio()));
		this.add(difficile);
		
		difficile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				facile.setIcon(new ImageIcon(ImageProvider.getFacileGrigio()));
				difficile.setIcon(new ImageIcon(ImageProvider.getDifficileVerde()));
				controller.getGestore().setDimensione(20);
				
			}
		});
		
		
		avanti=new JLabel();
		avanti.setBounds(560,670,273,67);
		avanti.setIcon(new ImageIcon(ImageProvider.getAvanti()));
		this.add(avanti);
		
		avanti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				setNome(inserisciNome.getText());
				if(controller.getGestore().getDimensione()!=-1 && !getNome().equals(null) && !getNome().equals("")){
					controller.pannelloImpostazioneGriglia();
					System.out.println("LIVELLO= "+ getLivello());
					System.out.println("NOME GIOCATORE="+ getNome());
				}
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				avanti.setIcon(new ImageIcon(ImageProvider.getAvantiGrande()));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				avanti.setIcon(new ImageIcon(ImageProvider.getAvanti()));
			}
		});
		
		indietro=new JLabel();
		indietro.setBounds(0,0,106,50);
		indietro.setIcon(new ImageIcon(ImageProvider.getIndietro()));
		this.add(indietro);
	
		indietro.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				controller.pannelloIniziale();
				reset();
			}
		});
	}
	
	
	protected void reset() {
		setLivello(-1);
		setNome(null);
		facile.setIcon(new ImageIcon(ImageProvider.getFacileGrigio()));
		difficile.setIcon(new ImageIcon(ImageProvider.getDifficileGrigio()));
		inserisciNome.setText("");
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ImageProvider.getSfondo(),0,0,null);
		g.drawImage(ImageProvider.getInserisciIlTuoNome(),396,50,null);
		g.drawImage(ImageProvider.getLivello(),346,350,null);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getLivello() {
		return livello;
	}
	public void setLivello(int livello) {
		this.livello = livello;
	}
	
}
