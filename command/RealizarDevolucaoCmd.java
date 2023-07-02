package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;

public class RealizarDevolucaoCmd implements Comando{
	
	@Override
	public void executar(BibliotecaFachada fachada, Object... args) {
		
			fachada.realizarDevolucao ((String) args[1], (String) args[2]);	
	}
}
