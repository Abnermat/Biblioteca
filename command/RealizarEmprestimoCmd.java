package trabalhoEngenharia.command;

import trabalhoEngenharia.Itens_biblioteca.Livro;
import trabalhoEngenharia.Usuarios.Usuario;

public class RealizarEmprestimoCmd implements Comando { //classe que implementa o command
	
	private Usuario usuario;
	private Livro livro;

	public RealizarEmprestimoCmd(Usuario usuario, Livro livro) {
		this.usuario = usuario;
		this.livro = livro;
	}
	@Override
	public void executar(String codigo, String... args) {
		this.usuario.solicitarEmprestimo(codigo, args[1],args[2]); //metodo que solicita a determinado tipo
	}

}
