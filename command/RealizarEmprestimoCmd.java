package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;
import trabalhoEngenharia.Usuarios.*;

public class RealizarEmprestimoCmd implements Comando { //classe que implementa o command
	
	@Override
	public void executar(BibliotecaFachada fachada, Object... args) {
		
		System.out.println("Emprestimo realizado!");	
	}

}
