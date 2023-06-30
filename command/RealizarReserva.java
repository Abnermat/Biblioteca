package trabalhoEngenharia.command;

import trabalhoEngenharia.Itens_biblioteca.Livro;
import trabalhoEngenharia.Usuarios.Usuario;

public class RealizarReserva implements Comando{

	/*private Usuario usuario;
	private Livro livro;

	public RealizarReserva(Usuario usuario, Livro livro) {
		this.usuario = usuario;
		this.livro = livro;
	}*/
	@Override
	public void executar(String... args) {
		this.usuario.solicitarReserva(); //metodo que solicita a determinado tipo usuario o tipo de pedido
		
	}

}
