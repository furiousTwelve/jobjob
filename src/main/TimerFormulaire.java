package main;
import java.util.Timer;
import java.util.TimerTask;
 
/**
 * 
 * @author 34011-82-02
 * CLASSE TIMER : COMPTEURS UTILISES SUR LES FORMULAIRES
 */
public class TimerFormulaire
{
	// ATTRIBUTS DE LA CLASSE
	int secondPassed = 1800;
	int minuteAff = 0;
	int secondeAff = 0;
	String secondeAffS = "";
	
    Timer timer = new Timer();
    TimerTask tache = new TimerTask() 
    {     
        @Override
        public void run() 
        {
        	if(secondPassed <= 0)
        	{
        		tache.cancel();
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
    
    // CONVERTIR LE TIMER : SECONDES => MINUTES/SECONDES
    public void affichage(int sec)
    {
		secondeAff = (sec%60);
		minuteAff = (sec - secondeAff)/60;
		if(secondeAff < 10)
		{
			secondeAffS = "0" + secondeAff;
			System.out.println(minuteAff + ":" + secondeAffS);
		}
		else
		{
        	System.out.println(minuteAff + ":" + secondeAff);
		}
    }
     
    public static void main(String[] args) 
    {
    	TimerFormulaire tp = new TimerFormulaire();
    	tp.start();
    }
}