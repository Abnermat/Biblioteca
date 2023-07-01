package trabalhoEngenharia.command;

import trabalhoEngenharia.Itens_biblioteca.Livro;
import trabalhoEngenharia.Usuarios.Usuario;

public class RealizarReservaCmd implements Comando{

	@Override
	public void executar(Object... args) {
		
		Usuario usu = (Usuario)args[1];
		Livro livro = (Livro)args[2];
		
		usu.solicitarReserva(usu.getId(), livro.getId()); 
		
	}

}
