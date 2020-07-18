public class Juego {

	private int matriz[][] = new int[6][7];
	private int jugador = 1;
	private boolean solteFicha = false;
	private int obtenerFilaFicha = 0;
	@SuppressWarnings("unused")
	private VentanaSecundaria ventana2;
	private Panel panel;
	
	public Juego(Panel panel) {
		this.panel = panel;
	}

	public void soltarFicha(int columna) {
		solteFicha = false;
		for (int i = 5; i >= 0; i--) {
			if (matriz[i][columna] == 0) {
				matriz[i][columna] = jugador;
				solteFicha = true;
				obtenerFilaFicha = i;
				break;
			}
		}
		if (jugador == 1) {
			jugador = 2;
		} else {
			jugador = 1;
		}
	}

	public int obtenerFilaFicha() {
		return obtenerFilaFicha;
	}

	public void verificarGanadorHorizontal() {
		for (int i = 5; i >= 0; i--) {
			for (int j = 3; j < 7; j++) {
				if ((matriz[i][j] == matriz[i][j - 1]) && (matriz[i][j] == matriz[i][j - 2])
						&& (matriz[i][j] == matriz[i][j - 3]) && matriz[i][j] != 0) {
					ventana2 = new VentanaSecundaria(this);
				}
			}
		}
	}

	public void verificarGanadorVertical() {
		for (int i = 3; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if ((matriz[i][j] == matriz[i - 1][j]) && (matriz[i][j] == matriz[i - 2][j])
						&& (matriz[i][j] == matriz[i - 3][j]) && matriz[i][j] != 0) {
					ventana2 = new VentanaSecundaria(this);
				}
			}
		}
	}

	public void verificarGanadorDiagonalIzqADer() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if ((matriz[i][j] == matriz[i + 1][j + 1]) && (matriz[i][j] == matriz[i + 2][j + 2])
						&& (matriz[i][j] == matriz[i + 3][j + 3]) && matriz[i][j] != 0) {
					ventana2 = new VentanaSecundaria(this);
				}
			}
		}
	}

	public void verificarGanadorDiagonalDerAIzq() {
		for (int i = 0; i < 3; i++) {
			for (int j = 6; j > 3; j--) {
				if ((matriz[i][j] == matriz[i + 1][j - 1]) && (matriz[i][j] == matriz[i + 2][j - 2])
						&& (matriz[i][j] == matriz[i + 3][j - 3]) && matriz[i][j] != 0) {
					ventana2 = new VentanaSecundaria(this);
				}
			}
		}
	}

	public void verificarEmpate() {
		boolean hayEmpate = true;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (matriz[i][j] == 0) {
					hayEmpate = false;
				}
			}
		}
		if (hayEmpate == true) {
			jugador = 0;
			ventana2 = new VentanaSecundaria(this);
		}
	}

	public int turnoJugador() {
		return jugador;
	}

	public boolean solteFicha() {
		return solteFicha;
	}

	public void reiniciarJuego() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				matriz[i][j] = 0;
			}
		}
		panel.ReinicioImagenes();	
	}
	
	public Panel getPanel() {
		return panel;
	}
}
