package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;

public class RealizarEmprestimoCmd implements Comando { //classe que implementa o command
	
	@Override
	public void executar(BibliotecaFachada fachada, Object... args) {
		
		fachada.realizarEmprestimo ((String) args[1], (String) args[2]); 	
	}

}
