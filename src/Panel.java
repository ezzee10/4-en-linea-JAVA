import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Panel extends JPanel implements ActionListener {

	private Tablero tableron;
	private Juego juego;
	private int alto;
	private int ancho;
	private JLabel[][] etiqueta;
	private JButton[] boton;

	public Panel(Tablero tablero) {

		juego = new Juego(this);
		tableron = tablero;
		tableron.obtenerResolucion();
		setSize(ancho, alto);
		setLayout(null);
		setBackground(Color.CYAN);
		arrayImagenes();
		arrayBotones();
		escuchaBotones();
	}

	public void arrayImagenes() {
		etiqueta = new JLabel[6][7];
		int contadorY = 180;
		int contadorX = 425;
		int contador = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				etiqueta[i][j] = new JLabel(" " + contador);
				etiqueta[i][j].setBounds(contadorX, contadorY, 130, 116);
				add(etiqueta[i][j]);
				etiqueta[i][j].setIcon(new ImageIcon("imagenes/Vacio.png"));
				contadorX += 125;
				contador++;
			}
			contadorX = 425;
			contadorY += 110;
		}
	}

	public void ReinicioImagenes() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				etiqueta[i][j].setIcon(new ImageIcon("imagenes/Vacio.png"));
			}
		}
	}

	public void arrayBotones() {
		boton = new JButton[7];
		int contadorX = 425;
		for (int i = 0; i < boton.length; i++) {
			boton[i] = new JButton();
			boton[i].setBounds(contadorX, 110, 110, 50);
			boton[i].setHorizontalTextPosition(SwingConstants.LEFT);
			boton[i].setText("SOLTAR");
			boton[i].setBackground(Color.GRAY);
			boton[i].setFocusable(false);
			add(boton[i]);
			contadorX += 125;
		}
	}

	public void escuchaBotones() {

		for (int i = 0; i < boton.length; i++) {
			boton[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object fuente = e.getSource();

		for (int i = 0; i < 7; i++) {
			if (fuente == boton[i]) {
				juego.soltarFicha(i);
				if (juego.solteFicha() == true) {
					if (juego.turnoJugador() == 1) {
						etiqueta[juego.obtenerFilaFicha()][i].setIcon(new ImageIcon("imagenes/Rojo.png"));
					} else {
						etiqueta[juego.obtenerFilaFicha()][i].setIcon(new ImageIcon("imagenes/Amarillo.png"));
					}
				}
				juego.verificarGanadorHorizontal();
				juego.verificarGanadorVertical();
				juego.verificarGanadorDiagonalIzqADer();
				juego.verificarGanadorDiagonalDerAIzq();
				juego.verificarEmpate();
			}
		}
	}
	
	public Tablero getTablero() {
		return tableron;
	}
}
