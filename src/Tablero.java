import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Tablero {
	
	private int alto;
	private int ancho;
	private JFrame tablero;

	public Tablero() {		
		tablero = new JFrame("4 en linea");
		obtenerResolucion();
		tablero.setSize(ancho,alto);
		tablero.setLocationRelativeTo(null);
		tablero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tablero.add(new Panel(this));
		tablero.repaint();
		tablero.setVisible(true);
		
	}
	
	public void obtenerResolucion() {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screen = t.getScreenSize();
		ancho = (int) ((screen.width)-(screen.width*0.1));
		alto = (int) ((screen.height)-(screen.height*0.1));	
	}
	
	public void apagarTablero() {
		tablero.setEnabled(false);
	}
	
	public void encenderTablero() {
		tablero.setEnabled(true);
	}

}
