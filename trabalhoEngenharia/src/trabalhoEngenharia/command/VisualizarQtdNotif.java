package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;

public class VisualizarQtdNotif implements Comando{

	@Override
	public void executar(Object... args) {
		
		String idUsuario = (String)args[1];
		BibliotecaFachada fachada = BibliotecaFachada.getInstance();
		fachada.visualizarQtdNtf(idUsuario);
	}

}
