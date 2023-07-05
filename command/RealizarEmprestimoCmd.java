package trabalhoEngenharia.command;

import java.time.LocalDate;

import trabalhoEngenharia.BibliotecaFachada;
import trabalhoEngenharia.Itens_biblioteca.*;
import trabalhoEngenharia.Usuarios.*;

public class RealizarEmprestimoCmd implements Comando { //classe que implementa o command
	
	@Override
	public void executar(Object... args) {
		
		String idUsuario = (String)args[1];
		String idLivro = (String)args[2];
		
		BibliotecaFachada fachada = BibliotecaFachada.getInstance();
		fachada.realizarEmprestimo( idUsuario, idLivro);	
	}

}
