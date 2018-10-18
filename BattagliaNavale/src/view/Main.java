package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	
	
	public static void main(String[] args) {
		System.out.println("Con quale grafica preferisci giocare?\n");
		System.out.println("Grafica Console. Premere il pulsante c\nGrafica 2D. Premere il pulsante d\n");
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String risposta=null;
		try {
			risposta =br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(risposta.equals("c")){
			Grafica console=new GraficaConsole();
		}
		else if(risposta.equals("d")){
			Grafica dueD= new Grafica2D();
		}
		
	}

}
