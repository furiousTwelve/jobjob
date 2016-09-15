package main.metier;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.presentation.FenetrePrincipale;
import main.presentation.panelFin;
import main.presentation.panelQuestion;
 
/**
 *  CLASSE TIMER : COMPTEURS UTILISES SUR LES FORMULAIRES
 * @author Alban
 * @author Benjamin
 * @author Marc
 */
public class TimerGeneral
{
	// ATTRIBUTS DE LA CLASSE
	public int secondPassed = 0;
	public int minuteAff = 0;
	public int secondeAff = 0;
	String secondeAffS = "";
	public  FenetrePrincipale fp;
	panelFin panFin = new panelFin();
	panelQuestion panQuestion = new panelQuestion();
	questionReponse qr = new questionReponse();
	//Constructeur pour mon héritage Stress
	public TimerGeneral(int secondPassed, FenetrePrincipale fp, panelQuestion pan, questionReponse qr)
	{
		this.secondPassed = secondPassed;
		this.fp = fp;
		this.panQuestion=pan;
		this.qr=qr;
	}
	public TimerGeneral(int secondPassed, FenetrePrincipale fp)
	{
		this.secondPassed = secondPassed;
		this.fp = fp;
		
		
	}
	
	
    Timer timer = new Timer();
    public TimerTask tache = new TimerTask() 
    {     
        @Override
        public void run() 
        {
        	if(secondPassed <= 0)
        	{
        		fp.getContentPane().removeAll();
        		fp.setContentPane(panFin);
        		fp.validate(); 
        		tache.cancel();
        		
        	}
        	
        	
        	else
        	{
        		secondPassed--;
        		affichage(secondPassed);
        	}
        }
    };
    public TimerTask tache2 = new TimerTask() 
    {     
        @Override
        public void run() 
        {
        	if(secondPassed <= 0)
        	{
        		
        		fp.compteurQuestions++;
				
				panQuestion.getReponse1().setSelected(false);
				panQuestion.getReponse2().setSelected(false);
				panQuestion.getReponse3().setSelected(false);
				panQuestion.getReponse4().setSelected(false);				

				panQuestion.getLabelQuestion().setText(qr.questionsCandidat[fp.compteurQuestions-1].libelleQuestion);
				panQuestion.getReponse1().setText(qr.questionsCandidat[fp.compteurQuestions-1].libelleReponse1);
				panQuestion.getReponse2().setText(qr.questionsCandidat[fp.compteurQuestions-1].libelleReponse2);
				panQuestion.getReponse3().setText(qr.questionsCandidat[fp.compteurQuestions-1].libelleReponse3);
				panQuestion.getReponse4().setText(qr.questionsCandidat[fp.compteurQuestions-1].libelleReponse4);
				 
        		tache2.cancel();
        		
        	}
        	
        	
        	else
        	{
        		secondPassed--;
        		affichage(secondPassed);
        	}
        }
    };
    
    // DELAI TIMER
    public void start()
    {
    	timer.scheduleAtFixedRate(tache, 1000, 1000);
    }
    public void start2()
    {
    	timer.scheduleAtFixedRate(tache2, 1000, 1000);
    }
    // CONVERTIR LE TIMER : SECONDES => MINUTES/SECONDES
    public String affichage(int sec)
    {
		String res = "";
    	secondeAff = (sec%60);
		minuteAff = (sec - secondeAff)/60;
		if(secondeAff < 10)
		{
			secondeAffS = "0" + secondeAff;
			res = minuteAff + ":" + secondeAffS;
			System.out.println(minuteAff + ":" + secondeAffS);
		}
		else
		{
			res = minuteAff + ":" + secondeAff;
        	System.out.println(minuteAff + ":" + secondeAff);
		}
		return res;
    }

    
     
//    public static void main(String[] args) 
//    {
//    	//Timer general 30min
//    	TimerGeneral tp = new TimerGeneral(1800);
//    	tp.start();
//    	//Timer stress 2min
//		TimerGeneral Stress = new TimerGeneral(120);
//		Stress.start();
//    }
}