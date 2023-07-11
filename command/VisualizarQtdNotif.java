package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;

public class VisualizarQtdNotif implements Comando{

	@Override
	public void executar(Object... args) {
		
		BibliotecaFachada fachada = BibliotecaFachada.getInstance();
		String idUsuario = (String)args[1];
		
		fachada.visualizarQtdNtf(idUsuario);
	}

}
