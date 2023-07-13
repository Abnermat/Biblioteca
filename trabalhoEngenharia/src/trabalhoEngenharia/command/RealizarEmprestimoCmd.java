package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;

public class RealizarEmprestimoCmd implements Comando { 
	
	@Override
	public void executar(Object... args) {
		
		String idUsuario = (String)args[1];
		String idLivro = (String)args[2];
		
		BibliotecaFachada fachada = BibliotecaFachada.getInstance();
		fachada.realizarEmprestimo( idUsuario, idLivro);	
	}

}
