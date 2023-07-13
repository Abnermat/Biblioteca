package trabalhoEngenharia.Itens_biblioteca;

import java.time.LocalDate;

import trabalhoEngenharia.Usuarios.Usuario;

public class Reserva {
	
	private Usuario usuario;
	private Livro livro;
	private LocalDate dataSolicitacao;
	
	public Reserva(Usuario usuario, Livro livro) {
		this.usuario = usuario;
		this.livro = livro;
		this.dataSolicitacao = LocalDate.now();
	}

	
	public Usuario getUsuario(){
		return this.usuario;
	}
	public Livro getLivro(){
		return this.livro;
	}


	public LocalDate getDataSolicitacao() {
		return dataSolicitacao;
	}	
}
