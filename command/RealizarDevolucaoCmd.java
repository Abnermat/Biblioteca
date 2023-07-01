package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;
import trabalhoEngenharia.Itens_biblioteca.Livro;
import trabalhoEngenharia.Usuarios.Usuario;

public class RealizarDevolucaoCmd implements Comando{
	
	@Override
	public void executar(Object... args) {
		
		Usuario usu = (Usuario)args[1];
		Livro livro = (Livro)args[2];
		
		usu.devolverExemplar(usu.getId(), livro.getId()); 
		
	}
}
