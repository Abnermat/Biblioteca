package trabalhoEngenharia;

import trabalhoEngenharia.command.*;

public class Factory {

	public static BibliotecaFachada getBibliotecaFachada() {
		return BibliotecaFachada.getInstance();
	}
	public static RealizarEmprestimoCmd getRealizarEmprestimoCmd() {
		return new RealizarEmprestimoCmd();
	}
	public static RealizarDevolucaoCmd getRealizarDevolucaoCmd() {
		return new RealizarDevolucaoCmd();
	}
	public static RealizarReservaCmd getReservaCmd() {
		return new RealizarReservaCmd();
	}
	public static VisualizarHistoricoCmd getVisualizarHistoricoCmd() {
		return new VisualizarHistoricoCmd();
	}
	public static SairSistemaCmd getSairCmd() {
		return new SairSistemaCmd();
	}	
	
}
