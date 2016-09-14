package main.presentation;

import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*; 
import java.lang.*; 



public class Chrono extends JPanel implements Runnable{ 
	/* deux façons de créer un thread: 
- Création d'un objet qui hérite de la classe Thread 
- Execution de la primitive new Thread() sur un objet qui implémente l'interface Runnable 
(et c'est ce k'on a fait dans ce programme) */ 

	Thread h; //déclaration du thread h 
	public void run() //la méthode vertuelle run() est obligatoire (voir cours "les threads" !!!) 
	{ 
		while(true) 
		{ 
			try{h.sleep(1000);} 

			//méthode sleep de la classe Thread : sleep (en milli-secondes) 
			catch(InterruptedException e){} 
			repaint(); 
		} 

	} 
	//------------------------------ 
	//------------------------------ 

	int x0=500,y0=400;
	int x11,y11;
	int i=0; 
	int rayon = 200;

	double tm=(java.lang.Math.PI)/9; 
	/* -- "tm" c'est l'angle avec lequel les aiguilles bougent,il est calculé en radian. 
cet angle est égale à 6 degrés -- */ 
	double y=tm; 


	//- début de paint() : la méthode qui dessine tout 
	public void paintComponent(Graphics g)
	{ 
		Graphics2D g1 = (Graphics2D) g;
		BasicStroke line = new BasicStroke(4.0f);
		g1.setStroke(line);

		x11=x0+(int)(rayon*(java.lang.Math.cos(tm - (java.lang.Math.PI)/2))); 
		y11=y0+(int)(rayon*(java.lang.Math.sin(tm - (java.lang.Math.PI)/2))); 
		g.setColor(Color.red); 
		g.drawLine(x0,y0,x11,y11); 
		i++; 
		tm+=y; 
		//A chaque fois l'angle de l'aiguille est changé -- 
		//Et on calcule la nouvelle position -- 

		//--- dessin du cercle
		g.setColor(Color.white);
		g.drawOval(x0-rayon,y0-rayon,2*rayon,2*rayon); 
		//g.drawOval(300,200,100,100);
		//g.setColor(Color.white); 
		//g.drawString(i+"s",490,100); //Affichage Numérique
	} 
	//------------fin de la fonction paint()------------------------------------- 

	public void horloge()
	{ 
		//constructeur 
		setVisible(true); //pour que la fenêtre divienne visible ! 
		setSize(800,600); //dimensions de la fenêtre 
		setBackground(Color.black);//couleur du fond(noir) 

		h = new Thread(this); //création 
		h.start(); //méthode de la classe Thread,pour lancer la méthode run() 
	} 
}
