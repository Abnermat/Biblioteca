package trabalhoEngenharia.Itens_biblioteca;

import java.time.LocalDate;

import trabalhoEngenharia.Usuarios.Usuario;

public class Emprestimo {

	private Usuario usuario;
	private Exemplar exemplar;
	private LocalDate dataEmprestimo, dataDevolucao;
	private boolean emAndamento;
	 
	public Emprestimo(Usuario usuario, Exemplar exemplar) {
		this.setUsuario(usuario);
		this.setExemplar(exemplar);
		this.setEmAndamento(true);
		this.setDataEmprestimo(LocalDate.now());
		this.dataDevolucao = this.calcularDataDevolucao();
		this.exemplar.indisponibilizar();
		this.msgEmprestimo();
	}
	
	public LocalDate calcularDataDevolucao() {
		int limiteUsuario = this.usuario.getLimiteDiasEmprestimo();
		return LocalDate.now().plusDays(limiteUsuario); //pega data atual e devolve uma data posterior
	}
	
	
	private void msgEmprestimo() {
		System.out.println("Emprestimo realizado!");
		System.out.println("Usuario: " + this.usuario.getNome());
		System.out.println("Livro: \"" + this.exemplar.getLivro().getTitulo() + "\", exemplar: " + this.getExemplar().getId());
		System.out.println("Devolução: " + this.getDataDevolucao());
		
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Exemplar getExemplar() {
		return exemplar;
	}

	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public boolean isEmAndamento() {
		return emAndamento;
	}

	public void setEmAndamento(boolean emAndamento) {
		this.emAndamento = emAndamento;
	}
	
	public void setDataDevolucao() {
		this.dataDevolucao = LocalDate.now();
	}
	
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	
	
	
}
