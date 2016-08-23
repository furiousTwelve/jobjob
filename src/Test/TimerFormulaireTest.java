package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.TimerFormulaire;

public class TimerFormulaireTest {

	TimerFormulaire tf = new TimerFormulaire();
	@Test
	public void testAffichage() {
		String test = tf.affichage(240);
		assertTrue("4:00".equals(test));
	}
}
