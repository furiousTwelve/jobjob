/**
 * Il s'agit du timer du panel de la question 11 (question stress), le timer est initialisé à 2min.
 */
package main.metier;

import javax.swing.JFrame;

import main.metier.TimerGeneral;

/**
 * @author Benjamin
 *version 1.0
 */

//Héritage de la class timer general
public class TimerStress extends TimerGeneral {
		
	public TimerStress(int secondPassed, JFrame fp){
		super(secondPassed, fp);
		
		//Timer stress 2min
		TimerGeneral TimerS = new TimerGeneral(120,fp);
		System.out.println(TimerS);
		
	}
}
