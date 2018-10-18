package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public class PannelloIniziale extends JPanel {
	
	private static final int HEIGHT=768;
	private static final int WIDTH=1366;
	
	private PanelSwitcher switcher;
	
	private JLabel singlePlayer;
	private JLabel multigiocatore;
	private JLabel esci;
	
	public PannelloIniziale(PanelSwitcher switcher, Controller controller){
		this.switcher = switcher;
		init(controller);
		
	}
	private void init( final Controller controller){
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setLayout(null);
		singlePlayer=new JLabel();
		singlePlayer.setSize(543,73);
		singlePlayer.setIcon(new ImageIcon(ImageProvider.getSinglePlayer()));
		singlePlayer.setBounds(463,300,543 , 73);
		this.add(singlePlayer);
		
		singlePlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				
				controller.pannelloImpostazioneSinglePlayer();
				singlePlayer.setIcon(new ImageIcon(ImageProvider.getSinglePlayer()));
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				singlePlayer.setIcon(new ImageIcon(ImageProvider.getGiocatoreSingoloGrande()));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				singlePlayer.setIcon(new ImageIcon(ImageProvider.getSinglePlayer()));
			}
		});
		
		
		multigiocatore=new JLabel();
		multigiocatore.setSize(559,73);
		multigiocatore.setIcon(new ImageIcon(ImageProvider.getMultigiocatore()));
		multigiocatore.setBounds(463,400,559 , 73);
		this.add(multigiocatore);
		
		multigiocatore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				
//				controller.inserire il pannello giusto
				multigiocatore.setIcon(new ImageIcon(ImageProvider.getMultigiocatore()));
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				multigiocatore.setIcon(new ImageIcon(ImageProvider.getMultigiocatoreGrande()));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				multigiocatore.setIcon(new ImageIcon(ImageProvider.getMultigiocatore()));
			}
		});
		
		
		
		esci=new JLabel();
		esci.setSize(131,73);
		esci.setIcon(new ImageIcon(ImageProvider.getEsci()));
		esci.setBounds(463,500,131 , 73);
		this.add(esci);
		
		esci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				
				System.exit(0);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				esci.setIcon(new ImageIcon(ImageProvider.getEsciGrande()));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				esci.setIcon(new ImageIcon(ImageProvider.getEsci()));
			}
		});
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ImageProvider.getSfondo(),0,0,null);
		
	}
}
