import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaSecundaria {

	private JButton boton1;
	private JButton boton2;
	private Juego juego;
	private JFrame windows;

	@SuppressWarnings("serial")
	public class PanelSecundario extends JPanel implements ActionListener {

		public PanelSecundario() {
			setSize(400, 400);
			setLayout(null);
			setBackground(Color.BLACK);
			etiquetas();
			botones();
		}

		public void etiquetas() {
			JLabel et1 = new JLabel();
			JLabel et2 = new JLabel();
			et1.setFont(new Font("Serif", Font.PLAIN, 30));
			et2.setFont(new Font("Serif", Font.PLAIN, 30));
			et1.setForeground(Color.WHITE);
			et1.setText("GANÓ EL JUGADOR");
			if (juego.turnoJugador() == 1) {
				et2.setForeground(Color.RED);
				et2.setText("ROJO");
				et2.setBounds(130, 100, 80, 50);
			} else if (juego.turnoJugador() == 2) {
				et2.setForeground(Color.YELLOW);
				et2.setText("AMARILLO");
				et2.setBounds(110, 100, 170, 50);
			} else if (juego.turnoJugador() == 0) {
				et1.setText("PARTIDA EMPATADA");
			}
			et1.setBounds(40, 40, 350, 50);
			add(et1);
			add(et2);
		}

		public void botones() {
			boton1 = new JButton();
			boton2 = new JButton();
			boton1.setFont(new Font("Serif", Font.PLAIN, 30));
			boton2.setFont(new Font("Serif", Font.PLAIN, 30));
			boton1.setForeground(Color.BLACK);
			boton2.setForeground(Color.BLACK);
			boton1.setText("VOLVER A JUGAR");
			boton2.setText("SALIR DEL JUEGO");
			boton1.setBackground(Color.DARK_GRAY);
			boton2.setBackground(Color.DARK_GRAY);
			boton1.setFocusable(false);
			boton2.setFocusable(false);
			boton1.setBounds(40, 170, 290, 60);
			boton2.setBounds(40, 260, 290, 60);
			boton1.addActionListener(this);
			boton2.addActionListener(this);
			add(boton1);
			add(boton2);

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object fuente = e.getSource();
			
			if(fuente == boton1) {
				juego.reiniciarJuego();
				juego.getPanel().getTablero().encenderTablero();
				windows.setVisible(false);
			}else if(fuente == boton2) {
				System.exit(1);
			}

		}

	}

	public VentanaSecundaria(Juego juego) {
		this.juego = juego;
		windows = new JFrame("Juego finalizado");
		windows.setSize(400, 400);
		windows.setLocationRelativeTo(null);
		windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windows.setBackground(Color.BLACK);
		windows.add(new PanelSecundario());
		windows.setUndecorated(true);
		juego.getPanel().getTablero().apagarTablero();
		windows.setVisible(true);
	}

}
