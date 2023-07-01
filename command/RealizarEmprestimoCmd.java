package trabalhoEngenharia.command;

import trabalhoEngenharia.Itens_biblioteca.Livro;
import trabalhoEngenharia.Usuarios.Usuario;

public class RealizarEmprestimoCmd implements Comando { //classe que implementa o command
	
	@Override
	public void executar(Object... args) {
		
		Usuario usu = (Usuario)args[1];
		Livro livro = (Livro)args[2];
		
		usu.solicitarEmprestimo(usu.getId(), livro.getId()); 
		
	}

}
