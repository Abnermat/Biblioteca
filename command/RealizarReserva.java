package trabalhoEngenharia.command;

import trabalhoEngenharia.BibliotecaFachada;
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
	public void executar(Object... args) {
		BibliotecaFachada fachada = BibliotecaFachada.getInstance();
		Usuario usuario = (Usuario)args[1];
		Livro livro = (Livro)args[2];
		fachada.realizarReserva(usuario, livro); //metodo que solicita a determinado tipo usuario o tipo de pedido
		
	}



}
